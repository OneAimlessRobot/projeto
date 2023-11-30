/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;

import java.io.Serializable;

import artAuctions.exceptions.ArtistHasNoWorksException;
import artAuctions.exceptions.ArtistHasWorksInAuctionException;
import artAuctions.exceptions.AuctionEmptyException;
import artAuctions.exceptions.AuctionExistsException;
import artAuctions.exceptions.NoSoldWorksException;
import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchAuctionException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.UserHasBidsException;
import artAuctions.exceptions.WeakBidException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.exceptions.WorkExistsInAuctionException;
import artAuctions.exceptions.WorkHasNoBidsInAuctionException;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import dataStructures.AVLBSTComparable;
import dataStructures.SepChainHashTable;
import dataStructures.Dictionary;
import dataStructures.Entry;
import dataStructures.Iterator;
import dataStructures.OrderedDictionary;


/**
* Implements interface AuctionManager. All ADT's start here.
*/
public class AuctionManagerClass implements Serializable, AuctionManager {

	private static final long serialVersionUID = 1L;

	/**
	 * These are all the works that have been added (they are just "Thrown in there")
	 */
	private Dictionary<String,Work> works;
	/**
	 * Users. Also just "thrown in there". Same for artists and auctions. Its the same for all auctions and the rest of the main actors.
	 * They are all indexed and compared by a String which is their ID
	 */
	
	private Dictionary<String,User> users;
	private Dictionary<String,Artist> artists;
	private Dictionary<String,Auction> auctions;
	/**
	 * Collection of all the works that have been sold. They are constantly kept sorted by price and then name
	 */
	private OrderedDictionary<WorkReadonly,WorkReadonly> soldworks;
	/**
	 * Auctions are 18+. We don't trust them youngsters to be responsible with their money,
	 * so we make their parents' lifes' easier
	 */
	private static final int MIN_AGE= 18;

	public AuctionManagerClass() {
		
		works= new SepChainHashTable<>();
		soldworks= new AVLBSTComparable<>(new CompareWorkByValueAndName());
		users= new SepChainHashTable<>();
		artists= new SepChainHashTable<>();
		auctions= new SepChainHashTable<>();
		
	}
	@Override
	public void addWork(String id, String login,int year,String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException {
		User user=  users.find(login);
		Artist artist=  artists.find(login);
		Work work= works.find(id);

		if(work!=null) {
			
			throw new WorkExistsException();
			
		}
		if(user==null) {

				throw new NoSuchUserException();
			}
		if(artist==null) {
				

				throw new NoSuchArtistException();
				
		}
		Work addedWork=new WorkClass(id,artist , year, name);
		works.insert(id,addedWork);
		artist.addWork(addedWork);
	}
	
	@Override
	public void addAuction(String id) throws AuctionExistsException {
		Auction auction=auctions.find(id);
		if(auction!=null) {

			throw new AuctionExistsException();
		}
		
		
		auctions.insert(id, new AuctionClass(id));
		
	}
	@Override
	public void addUser(String login,String name,int age,String email) throws UserExistsException, TooYoungException {
		
		if(age<MIN_AGE) {
			
			throw new TooYoungException();
		}
		
		User user= users.find(login);
		
		if(user!=null) {

			throw new UserExistsException();
		}
		users.insert(login,new UserClass(login,name,age,email));
		
	}
	

	@Override
	public void addArtist(String login,String name,String artsyName,int age,String email) throws UserExistsException, TooYoungException {

		Artist newArtist= new ArtistClass(login,name,age,email);
		User newUser=users.find(login);
		if(age<MIN_AGE) {
			

			throw new TooYoungException();
		}
		
		else if(newUser!=null) {

			throw new UserExistsException();
		}

		newArtist.setArtsyName(artsyName);
		artists.insert(login,newArtist);
		users.insert(login,(User)newArtist);
	}

	@Override
	public ArtistReadonly getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException  {
		User analyzedUser=users.find(login);
		Artist analyzedArtist=artists.find(login);
				
			if(analyzedUser==null) {

				throw new NoSuchUserException();
			}
			else if(analyzedArtist==null) {
				

				throw new NoSuchArtistException();
				
			}
		return analyzedArtist;
		
	}
	
	@Override
	public void addBidToWork(String auctionid,String workid,String collectorlogin,int value) throws NoSuchUserException, NoSuchWorkInAuctionException, NoSuchWorkException, NoSuchAuctionException, WeakBidException{
		Work work=works.find(workid);

		Auction auction=auctions.find(auctionid);
		User collector= users.find(collectorlogin);
			
		if(collector==null) {

			throw new NoSuchUserException();
		}
		if(auction==null) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(work==null) {
			
			throw new NoSuchWorkInAuctionException();  //Se a Obra n existe no vector de Obras, então tb não vai existir no Leilão.
			
		}
		WorkInAuction workInAuction=null;
		if((workInAuction=(WorkInAuction) auction.getWorkInAuction(work))==null) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(value<workInAuction.getMinBidAmmount()) {
			
			throw new WeakBidException();
			
		}
		Bid bid= new BidClass(collector, value);
		collector.addBid();
		workInAuction.addBid(bid);
		
		
	}
	@Override
	public UserReadonly getUserInfo(String login) throws NoSuchUserException  {
		User collector= users.find(login);
			if(collector==null) {

				throw new NoSuchUserException();
			}
		return collector;
		
	}
	@Override
	public void sellAuctionWork(WorkInAuctionReadonly currWork,AuctionReadonly auction) {
		//Gets the Work from the system's hashtable works, instead of the Auction's list of Works
		
		Iterator<Bid> currBidIt=currWork.bids();
		
		while(currBidIt.hasNext()) {
			Bid currBid=currBidIt.next();

			if(currBid.getBidAmmount()>currWork.getMaxBid().getBidAmmount()) {
				
				((WorkInAuction) currWork).setMaxBid(currBid);
				
			}
			if(currBid.getBidAmmount()>currWork.getWork().getMaxBid().getBidAmmount()) {
				if(soldworks.find(currWork.getWork())!=null ){
					
					soldworks.remove(currWork.getWork());


					
				}
				((Work)(currWork.getWork())).setMaxBid(currBid);
				
			}
			
		}
			soldworks.insert(((Work)(currWork.getWork())),((Work)(currWork.getWork())));
			

	}
	@Override
	public WorkReadonly getWorkInfo(String id) throws NoSuchWorkException {
		Work result=works.find(id);
			if(result==null) {

				throw new NoSuchWorkException();
			}
		return result;
			
	}
	
	
	@Override

	public void addWorkToAuction(String auctionid, String workid,int minValue) throws NoSuchAuctionException, WorkExistsInAuctionException, NoSuchWorkException {
		Work work=works.find(workid);
		Auction auction=auctions.find(auctionid);

		if(auction==null) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(work==null) {
			
			throw new NoSuchWorkException();
			
		}
		if(auction.getWorkInAuction(work)!=null) {
			
			throw new WorkExistsInAuctionException();
			
		}
		auction.addWork(work,minValue);
		
	}
	@Override
	public Iterator<Bid> getBidsFromWork(String auctionid,String workid) throws NoSuchWorkException,NoSuchAuctionException,NoSuchWorkInAuctionException ,WorkHasNoBidsInAuctionException{

		Work work=works.find(workid);
				Auction auction=auctions.find(auctionid);
		WorkInAuctionReadonly workinauction=null;

		if(auction==null) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(work==null) {

			throw new NoSuchWorkInAuctionException();
			
		}
		if((workinauction=auction.getWorkInAuction(work))==null) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(workinauction.getNumOfBids()==0) {
			
			throw new WorkHasNoBidsInAuctionException();
		}
		return workinauction.bids();
		
	}
	private void removeArtistWorks(Artist artist) {
		
		Iterator<Entry<WorkReadonly,WorkReadonly>> artistWorksIt=artist.works();

		while(artistWorksIt.hasNext()) {
			Entry<WorkReadonly,WorkReadonly> currArtistWork= artistWorksIt.next();
			works.remove(currArtistWork.getValue().getId());
			soldworks.remove(currArtistWork.getValue());
			}
		artist.clearWorks();

		}
	/**
	 * This method sweeps the auction collection, element by element, looking 
	 * @param artist
	 * @return
	 */
	private boolean artistHasWorksInAuction(Artist artist) {
		
		boolean result=false;
		Iterator<Entry<String,Auction>> auctionIt= auctions.iterator();
		while(auctionIt.hasNext()) {
			Auction currAuction= auctionIt.next().getValue();
			if(currAuction.isClosed()) {
				continue;
			}
			Iterator<WorkInAuctionReadonly> currAuctionWorksIt= currAuction.listWorks();
			while(currAuctionWorksIt.hasNext()) {
				WorkReadonly currWorkInCurrAuction= currAuctionWorksIt.next().getWork();
				if(currWorkInCurrAuction.getAuthor().equals(artist)) {
					return true;
				}
				
			}
			
			
		}
		return result;
	}
	@Override
	public Iterator<WorkInAuctionReadonly> getAuctionWorks(String auctionid) throws NoSuchAuctionException, AuctionEmptyException {
		Auction auction=auctions.find(auctionid);
		
		if(auction==null) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.getNumOfWorks()==0) {
			
			throw new AuctionEmptyException();
			
		}
		return auction.listWorks();
	}

	@Override
	public Iterator<Entry<WorkReadonly,WorkReadonly>> listWorksByValue() throws NoSoldWorksException  {
		if(soldworks.isEmpty()) {
			throw new NoSoldWorksException();
		}
		return soldworks.iterator();
	}
	@Override
	public Iterator<Entry<WorkReadonly,WorkReadonly>> getArtistWorks(String artistLogin) throws NoSuchUserException, NoSuchArtistException, ArtistHasNoWorksException{
		Artist targetedArtist= artists.find(artistLogin);
		User targetedUser= users.find(artistLogin);
		if(targetedUser==null) {
			
			throw new NoSuchUserException();
		}if(targetedArtist==null) {
			
			throw new NoSuchArtistException();
		}if(targetedArtist.getNumOfWorks()==0) {
			
			throw new ArtistHasNoWorksException();
		}
		return targetedArtist.works();
		
		
	}
	@Override
	public void removeUser(String login)
			throws NoSuchUserException,UserHasBidsException, ArtistHasWorksInAuctionException {
		Artist artist=artists.find(login);
		User user=users.find(login);
		if(user==null) {
			
			throw new NoSuchUserException();
		}
		
		if(artist==null) {
		
			if(user.numOfBids()>0) {
				
				throw new UserHasBidsException();
			}
			users.remove(login);
		}
		else {
			
			if(user.numOfBids()>0) {
				
				throw new UserHasBidsException();
			}
			if(artistHasWorksInAuction(artist)) {
				
				throw new ArtistHasWorksInAuctionException();
			}
			if(artist.getNumOfWorks()>0) {
			removeArtistWorks(artist);
			}
			users.remove(login);
			artists.remove(login);
		}
	}
	@Override
	public AuctionReadonly getAuction(String auctionid) throws NoSuchAuctionException {
		Auction removed=auctions.find(auctionid);
		if(removed==null) {
			
			throw new NoSuchAuctionException();
		}
		if(removed.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		removed.close();
		return removed;
		
	}
	@Override
	public void removeAuction(String auctionid){
		auctions.remove(auctionid);
		
	}


}
