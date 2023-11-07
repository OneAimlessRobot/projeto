package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.exceptions.ArtistHasWorksInAuctionException;
import artAuctions.exceptions.AuctionEmptyException;
import artAuctions.exceptions.AuctionExistsException;
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
import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.ArtistGeneric;
import artAuctions.specificADTs.interfaces.Auction;
import artAuctions.specificADTs.interfaces.AuctionGeneric;
import artAuctions.specificADTs.interfaces.AuctionManager;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.BidGeneric;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.UserGeneric;
import artAuctions.specificADTs.interfaces.Work;
import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructures.DoubleList;
import dataStructures.FilteredIterator;
import dataStructures.FilteredIteratorWithPredicate;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.Vector;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/



public class AuctionManagerClass implements Serializable, AuctionManager {

	public class WorkIteratorPair{
		private Iterator<WorkGeneric> it1,it2;
		
		public WorkIteratorPair(Iterator<WorkGeneric> it1,Iterator<WorkGeneric> it2) {
			
			this.it1=it1;
			this.it2=it2;
			
		}
		public Iterator<WorkGeneric> getIteratorOneOrTwo(int which){
			Iterator<WorkGeneric> result=null;
			switch(which) {
			case 1:
				result= it1;
			case 2:
				result= it2;
			default:
				break;
			}
			return result;
			
			
		}
		
		
		
		
	}
	private static final long serialVersionUID = 1L;
	
	private List<Work> works;
	private List<User> users;
	private List<Artist> artists;
	private List<Auction> auctions;
	private static final int MIN_AGE= 18;

	public AuctionManagerClass() {
//		
		works= new Vector<>();
		users= new Vector<>();
		artists= new Vector<>();
//		works= new DoubleList<>();
//		users= new DoubleList<>();
//		artists= new DoubleList<>();
		auctions= new DoubleList<>();
		
	}
	@Override
	public void addWork(String id, String login,int year,String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException {
		Artist decoy= new ArtistClass(login," ",0," ");
		Work decoyWork= new WorkClass(id,null,0," ");
		int pos=users.find((User)(UserGeneric)(ArtistGeneric)decoy),
				artistPos=artists.find(decoy),
				workPos=works.find(decoyWork);

		if(workPos>=0) {
			
			throw new WorkExistsException();
			
		}
		if(pos<0) {

				throw new NoSuchUserException();
			}
		if(artistPos<0) {
				

				throw new NoSuchArtistException();
				
			}
		Artist user=artists.get(artistPos);
		Work addedWork=new WorkClass(id,user , year, name);
		works.addLast(addedWork);
		user.addWork(addedWork);
	}
	
	@Override
	public void addAuction(String id) throws AuctionExistsException {
		Auction decoy= new AuctionClass(id);
		int pos=auctions.find(decoy);
		if(pos>=0) {

			throw new AuctionExistsException();
		}
		
		
		auctions.addLast(decoy);
		
	}
	@Override
	public void addUser(String login,String name,int age,String email) throws UserExistsException, TooYoungException {
		User user= new UserClass(login,name,age,email);
		int pos=users.find(user);
if(age<MIN_AGE) {
			

			throw new TooYoungException();
}
		
		else if(pos>=0) {

			throw new UserExistsException();
		}
		users.addLast(user);
		
	}
	

	@Override
	public void addArtist(String login,String name,String artsyName,int age,String email) throws UserExistsException, TooYoungException {

		Artist newUser=new ArtistClass(login,name,age,email);
		int pos=users.find((User)(UserGeneric)(ArtistGeneric)newUser);
if(age<MIN_AGE) {
			

			throw new TooYoungException();
}
		
		else if(pos>=0) {

			throw new UserExistsException();
		}
		newUser.setArtsyName(artsyName);
		artists.addLast(newUser);
		users.addLast((User)newUser);
	}

	@Override
	public String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException  {
		Artist decoy= new ArtistClass(login," ",0," ");
		int pos=users.find((User)decoy),
				artistPos=artists.find(decoy);
			if(pos<0) {

				throw new NoSuchUserException();
			}
			else if(artistPos<0) {
				

				throw new NoSuchArtistException();
				
			}
		Artist artist= artists.get(artistPos);
		return artist.printArtist();
		
	}
	
	@Override
	public void addBidToWork(String auctionid,String workid,String collectorlogin,int value) throws NoSuchUserException, NoSuchWorkInAuctionException, NoSuchWorkException, NoSuchAuctionException, WeakBidException{
		Work work= new WorkClass(workid, null, value, null);

		Auction auction=new AuctionClass(auctionid);
		User decoy= new UserClass(collectorlogin," ",0," ");
		int pos=users.find(decoy),
			workpos=works.find(work),
			auctionpos=auctions.find(auction);
		if(pos<0) {

			throw new NoSuchUserException();
		}
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}

		auction=auctions.get(auctionpos);
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(workpos<0) {
			
			//throw new NoSuchWorkException();	
			throw new NoSuchWorkInAuctionException();  //Se a Obra n existe no vector de Obras, então tb não vai existir no Leilão.
			
		}
		work=works.get(workpos);
		Work workInAuction=null;
		if((workInAuction=(Work)getWorkInAuction(auction,work))==null) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(value<workInAuction.getMinBidAmmount()) {
			
			throw new WeakBidException();
			
		}
		User collector=users.get(pos);
		Bid bid= new BidClass(collector, work, value,auction);
		collector.addBid(bid);
		work.addBid(bid);
		
		
	}
	@Override
	public String getUserInfo(String login) throws NoSuchUserException  {
		User decoy= new UserClass(login," ",0," ");
		int pos=users.find(decoy);
			if(pos<0) {

				throw new NoSuchUserException();
			}
			User collector=users.get(pos);
		return ((UserClass)collector).printUser();
		
	}
	@Override
	public void sellAuctionWork(Work currWork,String auctionId) {
		
		
		FilteredIterator<BidGeneric> currBidIt= currWork.bidsFilteredByAuctionId(auctionId);
		while(currBidIt.hasNext()) {
			BidGeneric currBid=currBidIt.next();
			if(currBid.getBidAmmount()>currWork.getMaxBid().getBidAmmount()) {
				
				currWork.setMaxBid(currBid);
			}
			
		}
		int auxPosValue=works.find(currWork);
	}
	@Override
	public String getWorkInfo(String id) throws NoSuchWorkException {
		Work result,decoy= new WorkClass(id, null, 0," ");
		int pos=works.find(decoy);
			if(pos<0) {

				throw new NoSuchWorkException();
			} 
		result=works.get(pos);
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
		Work work= new WorkClass(workid, null, minValue, null);
		Auction auction=new AuctionClass(auctionid);
		int workpos=works.find(work),auctionpos=auctions.find(auction);

		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auction=auctions.get(auctionpos);
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(workpos<0) {
			
			throw new NoSuchWorkException();
			
		}
		work=works.get(workpos);
		if(getWorkInAuction(auction,work)!=null) {
			
			throw new WorkExistsInAuctionException();
			
		}
		work.setMinAmmount(minValue);
		auctions.get(auctionpos).addWork(work);
		
	}
	@Override
	public FilteredIterator<BidGeneric> getBidsFromAuctionWork(String auctionid,String workid) throws NoSuchWorkException,NoSuchAuctionException,NoSuchWorkInAuctionException ,WorkHasNoBidsInAuctionException{

		Work work= new WorkClass(workid, null, 0, null);
		Auction auction=new AuctionClass(auctionid);
		int workpos=works.find(work),auctionpos=auctions.find(auction);
		WorkGeneric workinauction=null;

		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auction=auctions.get(auctionpos);
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if((workinauction=getWorkInAuction(auction,work))==null) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(workpos<0) {
			
			throw new NoSuchWorkException();
			
		}
		if(workinauction.getNumOfBidsFromAuction(auctionid)==0) {
			
			throw new WorkHasNoBidsInAuctionException();
		}
		return works.get(workpos).bidsFilteredByAuctionId(auctionid);
		
	}
	private static WorkGeneric getWorkInAuction(Auction auction,WorkGeneric work) {
		
		Iterator<WorkGeneric> auctionWorkIt= auction.listWorks();
		WorkGeneric curr= null;
		while(auctionWorkIt.hasNext()) {
			curr=auctionWorkIt.next();
			
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
		
		Iterator<WorkGeneric> artistWorksIt=artist.works();

//		while(artistWorksIt.hasNext()) {
//			Work currArtistWork= artistWorksIt.next();
//			works.remove(currArtistWork);
//			artistWorksIt.rewind();
//			}
		while(artistWorksIt.hasNext()) {
			WorkGeneric currArtistWork= artistWorksIt.next();
			works.remove((Work)currArtistWork);
			}
		artist.clearWorks();

		}
	private boolean artistHasWorksInAuction(Artist artist) {
		
		boolean result=false;
		Iterator<Auction> auctionIt= auctions.iterator();
		while(auctionIt.hasNext()) {
			Auction currAuction= auctionIt.next();
			Iterator<WorkGeneric> currAuctionWorksIt= currAuction.listWorks();
			while(currAuctionWorksIt.hasNext()) {
				WorkGeneric currWorkInCurrAuction= currAuctionWorksIt.next();
				if(currWorkInCurrAuction.getAuthor().equals(artist)) {
					
					return true;
				}
				
			}
			
			
		}
		return result;
	}
private boolean userHasBidsInOpenAuction(UserGeneric user) {
		
		boolean result=false;
		FilteredIteratorWithPredicate<BidGeneric> bidit= user.bidsInOpenAuctions();
		if(bidit.hasNext()) {
			
			result=true;
		}
		return result;
	}
	@Override
	public Iterator<WorkGeneric> getAuctionWorks(String auctionid) throws NoSuchAuctionException, AuctionEmptyException {
		Auction auction=new AuctionClass(auctionid);
		int auctionpos=auctions.find(auction);
		
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auction=auctions.get(auctionpos);
		if(auction.isClosed()) {
			
			throw new NoSuchAuctionException();
		}
		if(auction.getNumOfWorks()==0) {//224 
			
			throw new AuctionEmptyException();
			
		}
		return auction.listWorks();
	}
	@Override
	public void removeUser(String login)
			throws NoSuchUserException,UserHasBidsException, ArtistHasWorksInAuctionException {
		Artist removedIfArtist,user=new ArtistClass(login, "",0,"");
		User removedIfUser;
		int artistpos=artists.find(user);
		int userpos=users.find((User)user);
		if(userpos<0) {
			
			throw new NoSuchUserException();
		}
		
		if(artistpos<0) {
		
			removedIfUser=users.get(userpos);
			if(userHasBidsInOpenAuction(removedIfUser)) {
				
				throw new UserHasBidsException();
			}
			users.remove(userpos);
		}
		else {
			
			removedIfArtist=artists.get(artistpos);
			if(userHasBidsInOpenAuction((UserGeneric)removedIfArtist)) {
				
				throw new UserHasBidsException();
			}
			if(artistHasWorksInAuction(removedIfArtist)) {
				
				throw new ArtistHasWorksInAuctionException();
			}
			if(removedIfArtist.getNumOfWorks()>0) {
			removeArtistWorks(removedIfArtist);
			}
			users.remove(userpos);
			artists.remove(artistpos);
		}
	}
	@Override
	public Auction closeAuction(String auctionid) throws NoSuchAuctionException {
		Auction removed= new AuctionClass(auctionid);
		int auctionpos=auctions.find(removed);
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auctions.get(auctionpos).close();
		return auctions.remove(auctionpos);
		
		
	}

}
