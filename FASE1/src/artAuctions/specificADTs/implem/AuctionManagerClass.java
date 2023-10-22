package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.exceptions.AuctionEmptyException;
import artAuctions.exceptions.AuctionExistsException;
import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchAuctionException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.WeakBidException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.exceptions.WorkExistsInAuctionException;
import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Auction;
import artAuctions.specificADTs.interfaces.AuctionManager;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.Collector;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;
import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.Vector;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/



public class AuctionManagerClass implements Serializable, AuctionManager {

	private static final long serialVersionUID = 1L;
	
	private List<Work> works;
	private List<User> users;
	private List<Collector> collectors;
	private List<Artist> artists;
	private List<Auction> auctions;
	private static final int MIN_AGE= 18;
	private static final int MIN_BID= 50;

	public AuctionManagerClass() {
//		
		works= new Vector<>();
		users= new Vector<>();
		collectors= new Vector<>();
		artists= new Vector<>();
//		works= new DoubleList<>();
//		users= new DoubleList<>();
//		collectors= new DoubleList<>();
//		artists= new DoubleList<>();
		auctions= new DoubleList<>();
		
	}
	@Override
	public void addWork(int id, String login,int year,String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException {
		User user,decoy= new ArtistClass(login," "," ",0," ");
		Work decoyWork= new WorkClass(id,null,0," ");
		int pos=users.find(decoy),
				artistPos=artists.find((Artist)decoy),
				workPos=works.find(decoyWork);
				
			if(pos<0) {

				throw new NoSuchUserException();
			}
			else if(artistPos<0) {
				

				throw new NoSuchArtistException();
				
			}
			else if(workPos>=0) {
				
				throw new WorkExistsException();
				
			}
		user=artists.get(artistPos);
		works.addFirst((Work)new WorkClass(id,(Artist)user , year, name));
	}
	
	@Override
	public void addAuction(int id) throws AuctionExistsException {
		Auction decoy= new AuctionClass(id);
		int pos=auctions.find(decoy);
		if(pos>=0) {

			throw new AuctionExistsException();
		}
		
		
		auctions.addFirst(decoy);
		
	}
	@Override
	public void addUser(String login,String name,int age,String email) throws UserExistsException, TooYoungException {
		User decoy= new CollectorClass(login," ",0," ");
		int pos=users.find(decoy);
		if(pos>=0) {

			throw new UserExistsException();
		}
		
		else if(age<MIN_AGE) {
			

			throw new TooYoungException();
			
		}
		User newUser=new CollectorClass(login,name,age,email);
		collectors.addFirst((Collector)newUser);
		users.addFirst(newUser);
		
	}
	

	@Override
	public void addArtist(String login,String name,String artsyName,int age,String email) throws UserExistsException, TooYoungException {
		User decoy= new CollectorClass(login," ",0," ");
		int pos=users.find(decoy);
		if(pos>=0) {

			throw new UserExistsException();
		}
		
		else if(age<MIN_AGE) {
			

			throw new TooYoungException();
			
		}
		User newUser=new ArtistClass(login,name,artsyName,age,email);
		artists.addFirst((Artist)newUser);
		users.addFirst(newUser);
	}

	@Override
	public String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException  {
		User decoy= new ArtistClass(login," "," ",0," ");
		int pos=users.find(decoy),
				artistPos=artists.find((Artist)decoy);
			if(pos<0) {

				throw new NoSuchUserException();
			}
			else if(artistPos<0) {
				

				throw new NoSuchArtistException();
				
			}
		Artist artist= artists.get(artistPos);
		return artist.toString();
		
	}
	
	@Override
	public void addBidToWork(int auctionid,int workid,String collectorlogin,int value) throws NoSuchUserException, NoSuchWorkInAuctionException, NoSuchWorkException, NoSuchAuctionException, WeakBidException{
		Work work= new WorkClass(workid, null, value, null);
		Auction auction=new AuctionClass(auctionid);
		User decoy= new CollectorClass(collectorlogin," ",0," ");
		int pos=users.find(decoy),
				workpos=works.find(work),
				auctionpos=auctions.find(auction);
		if(pos<0) {

			throw new NoSuchUserException();
		}
		if(workpos<0) {
			
			throw new NoSuchWorkException();
			
		}
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auction=auctions.get(auctionpos);
		work=works.get(workpos);
		if(!workExistsInAuction(auction,work)) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		if(value<MIN_BID) {
			
			throw new WeakBidException();
			
		}
		work.setSoldAmmount(value);
		Collector collector=(Collector)users.get(pos);
		Bid bid= new BidClass(collector, work, value);
		collector.addBid(bid);
		work.addBid(bid);
		
		
	}
	@Override
	public String getUserInfo(String login) throws NoSuchUserException  {
		User decoy= new CollectorClass(login," ",0," ");
		int pos=users.find(decoy);
			if(pos<0) {

				throw new NoSuchUserException();
			}
			Collector collector=(Collector)users.get(pos);
		return collector.toString();
		
	}
	@Override
	public String getWorkInfo(int id) throws NoSuchWorkException {
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
		result+="\nCollectors: "+collectors;
		result+="\nArtists: "+artists;
		result+="\nAuctions: "+auctions;
		result+="\n";
		return result;
		
		
	}
	@Override

	public void addWorkToAuction(int auctionid, int workid,int minValue) throws NoSuchWorkException, NoSuchAuctionException, WorkExistsInAuctionException {
		Work work= new WorkClass(workid, null, minValue, null);
		Auction auction=new AuctionClass(auctionid);
		int workpos=works.find(work),auctionpos=auctions.find(auction);
		if(workpos<0) {
			
			throw new NoSuchWorkException();
			
		}
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		work=works.get(workpos);
		work.setSoldAmmount(minValue);
		auction=auctions.get(auctionpos);
if(workExistsInAuction(auction,work)) {
			
			throw new WorkExistsInAuctionException();
			
		}
		auctions.get(auctionpos).addWork(works.get(workpos));
		
	}
	@Override
	public Iterator<Bid> getBidsFromAuctionWork(int auctionid,int workid) throws NoSuchWorkException,NoSuchAuctionException,NoSuchWorkInAuctionException {

		Work work= new WorkClass(workid, null, 0, null);
		Auction auction=new AuctionClass(auctionid);
		int workpos=works.find(work),auctionpos=auctions.find(auction);
		if(workpos<0) {
			
			throw new NoSuchWorkException();
			
		}
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auction=auctions.get(auctionpos);
		if(!workExistsInAuction(auction,work)) {
			
			throw new NoSuchWorkInAuctionException();
			
		}
		work=works.get(workpos);
		return work.bids();
		
	}
	private static boolean workExistsInAuction(Auction auction,Work work) {
		
		boolean result=false;
		Iterator<Work> auctionWorkIt= auction.listWorks();
		Work curr= null;
		while(auctionWorkIt.hasNext()) {
			curr=auctionWorkIt.next();
			if(work.equals(curr)) {
				
				return true;
			}
			
		}
		if(curr==null) {
			
			return false;
			
		}
		return result;
	}
	@Override
	public Iterator<Work> getAuctionWorks(int auctionid) throws NoSuchAuctionException, AuctionEmptyException {
		Auction auction=new AuctionClass(auctionid);
		int auctionpos=auctions.find(auction);
		
		if(auctionpos<0) {
			
			throw new NoSuchAuctionException();
		}
		auction=auctions.get(auctionpos);
		if(auction.getNumOfWorks()==0) {
			
			throw new AuctionEmptyException();
			
		}
		return auction.listWorks();
	}

}
