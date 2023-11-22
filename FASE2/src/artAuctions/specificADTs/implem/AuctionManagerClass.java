package artAuctions.specificADTs.implem;

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
import artAuctions.specificADTs.implem.comparators.CompareWorkByValueAndName;
import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.ArtistGeneric;
import artAuctions.specificADTs.interfaces.AuctionGeneric;
import artAuctions.specificADTs.interfaces.Auction;
import artAuctions.specificADTs.interfaces.AuctionManager;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.UserGeneric;
import artAuctions.specificADTs.interfaces.Work;
import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructures.AVLBSTComparable;
import dataStructures.Dictionary;
import dataStructures.Entry;
import dataStructures.FilteredIteratorWithPredicate;
import dataStructures.Iterator;
import dataStructures.IteratorEntries;
import dataStructures.OrderedDictionary;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/
import dataStructures.SepChainHashTable;


/**
* Implements interface AuctionManager. All ADT's start here.
*/
public class AuctionManagerClass implements Serializable, AuctionManager {

	private static final long serialVersionUID = 1L;

	private Dictionary<String,Work> works;
	private OrderedDictionary<WorkGeneric,WorkGeneric> soldworks;
	private Dictionary<String,User> users;
	private Dictionary<String,Artist> artists;
	private Dictionary<String,Auction> auctions;
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
		Work addedWork=new WorkClass(id,(ArtistGeneric) user , year, name);
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
		User user= users.find(login);
		if(age<MIN_AGE) {
			

			throw new TooYoungException();
		}
		
		else if(user!=null) {

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
	public String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException  {
		User analyzedUser=users.find(login);
		Artist analyzedArtist=artists.find(login);
				
			if(analyzedUser==null) {

				throw new NoSuchUserException();
			}
			else if(analyzedArtist==null) {
				

				throw new NoSuchArtistException();
				
			}
		return analyzedArtist.printArtist();
		
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
		Work workInAuction=null;
		if((workInAuction=(Work)getWorkInAuction(auction,work))==null) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(value<workInAuction.getMinBidAmmount()) {
			
			throw new WeakBidException();
			
		}
		Bid bid= new BidClass(collector, work, value,auction);
		collector.addBid(bid);
		work.addBid(bid);
		
		
	}
	@Override
	public String getUserInfo(String login) throws NoSuchUserException  {
		User collector= users.find(login);
			if(collector==null) {

				throw new NoSuchUserException();
			}
		return ((UserClass)collector).printUser();
		
	}
//	@Override
//	public void sellAuctionWork(Work currWork,String auctionId) {
//		if(soldworks.find(currWork)!=null) {
//			
//			soldworks.remove(currWork);
//		}
//		
//		IteratorEntries<Bid,Bid> currBidIt= currWork.bids();
//		while(currBidIt.hasNext()) {
//			Bid currBid=currBidIt.next().getValue();
//			if(currBid.getBidAmmount()>currWork.getMaxBid().getBidAmmount()) {
//				
//				currWork.setMaxBid(currBid);
//			}
//			
//		}
//		soldworks.insert(currWork,currWork);
//	}
	@Override
	public void sellAuctionWork(Work currWork,String auctionId) {
		boolean alreadySold=false;
		if(alreadySold=(soldworks.find(currWork)!=null) ){

			soldworks.remove(currWork);
			System.out.println("AQUI!!!!!");
			
			
			
		}
		Iterator<Bid> currBidIt= currWork.bids();
		while(currBidIt.hasNext()) {
			Bid currBid=currBidIt.next();
			if(currBid.getAuction().getId().equals(auctionId)) {
			if(currBid.getBidAmmount()>currWork.getMaxBid().getBidAmmount()) {
					currWork.setMaxBid(currBid);
			}
			}
			
		}
			soldworks.insert(currWork,currWork);

	}
	@Override
	public String getWorkInfo(String id) throws NoSuchWorkException {
		Work result=works.find(id);
			if(result==null) {

				throw new NoSuchWorkException();
			}
		return result.toString();
			
	}
	
	
	@Override
	public String users() {
		return users.toString();
	}
	public String toString() {
		String result ="Informaçao sobre este manager:\n";
		result+="\nWorks: "+works;
		result+="\nUsers: "+users;
		result+="\nArtists: "+artists;
		result+="\nAuctions: "+auctions;
		result+="\n";
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
		if(getWorkInAuction(auction,work)!=null) {
			
			throw new WorkExistsInAuctionException();
			
		}
		work.setMinAmmount(minValue);
		auction.addWork(work);
		
	}
	@Override
	public Iterator<Bid> getBidsFromWork(String auctionid,String workid) throws NoSuchWorkException,NoSuchAuctionException,NoSuchWorkInAuctionException ,WorkHasNoBidsInAuctionException{

		Work work=works.find(workid);
				Auction auction=auctions.find(auctionid);
		WorkGeneric workinauction=null;

		if(auction==null) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(work==null) {

			throw new NoSuchWorkInAuctionException();
			
		}
		if((workinauction=getWorkInAuction(auction,work))==null) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(workinauction.getNumOfBidsFromAuction(auctionid)==0) {
			
			throw new WorkHasNoBidsInAuctionException();
		}
		return work.bids();
		
	}
	private static WorkGeneric getWorkInAuction(Auction auction,WorkGeneric work) {
		
		IteratorEntries<String,WorkGeneric> auctionWorkIt= auction.listWorks();
		WorkGeneric curr= null;
		while(auctionWorkIt.hasNext()) {
			curr=auctionWorkIt.next().getValue();
			
			if(work.equals(curr)) {
				
				return curr;
			}
		}
		if(curr==null) {
			
			return null;
			
		}
		return null;
	}
	private void removeArtistWorks(Artist artist) {
		
		IteratorEntries<WorkGeneric,WorkGeneric> artistWorksIt=artist.works();

		while(artistWorksIt.hasNext()) {
			Entry<WorkGeneric,WorkGeneric> currArtistWork= artistWorksIt.next();
			works.remove(currArtistWork.getValue().getId());
			soldworks.remove(currArtistWork.getValue());
			}
		artist.clearWorks();

		}
	private boolean artistHasWorksInAuction(Artist artist) {
		
		boolean result=false;
		IteratorEntries<String,Auction> auctionIt= auctions.iterator();
		while(auctionIt.hasNext()) {
			Auction currAuction= auctionIt.next().getValue();
			IteratorEntries<String,WorkGeneric> currAuctionWorksIt= currAuction.listWorks();
			while(currAuctionWorksIt.hasNext()) {
				WorkGeneric currWorkInCurrAuction= currAuctionWorksIt.next().getValue();
				if(currWorkInCurrAuction.getAuthor().equals(artist)) {
					if(!currAuction.isClosed()) {
						return true;
					}
				}
				
			}
			
			
		}
		return result;
	}
private boolean userHasBidsInOpenAuction(UserGeneric user) {
		
		boolean result=false;
		FilteredIteratorWithPredicate<Bid> bidit= user.bidsInOpenAuctions();
		if(bidit.hasNext()) {
			
			result=true;
		}
		return result;
	}
	@Override
	public Iterator<WorkGeneric> getAuctionWorks(String auctionid) throws NoSuchAuctionException, AuctionEmptyException {
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
		return auction.listWorksInsertionOrder();
	}

	@Override
	public IteratorEntries<WorkGeneric,WorkGeneric> listWorksByValue() throws NoSoldWorksException  {
		if(soldworks.isEmpty()) {
			throw new NoSoldWorksException();
		}
		return soldworks.iterator();
	}
	@Override
	public IteratorEntries<WorkGeneric,WorkGeneric> getArtistWorks(String artistLogin) throws NoSuchUserException, NoSuchArtistException, ArtistHasNoWorksException{
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
		
			if(userHasBidsInOpenAuction(user)) {
				
				throw new UserHasBidsException();
			}
			users.remove(login);
		}
		else {
			
			if(userHasBidsInOpenAuction((UserGeneric)user)) {
				
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
	public AuctionGeneric closeAuction(String auctionid) throws NoSuchAuctionException {
		Auction removed=auctions.find(auctionid);
		if(removed==null) {
			
			throw new NoSuchAuctionException();
		}
		removed.close();
		return removed;
		
	}

}
