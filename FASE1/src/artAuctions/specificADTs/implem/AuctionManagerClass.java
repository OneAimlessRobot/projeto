package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Auction;
import artAuctions.specificADTs.interfaces.AuctionManager;
import artAuctions.specificADTs.interfaces.Collector;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;
import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.Vector;

public class AuctionManagerClass implements Serializable, AuctionManager {

	private static final long serialVersionUID = 1L;

	public List<Work> works;
	public List<User> users;
	public List<Collector> collectors;
	public List<Artist> artists;
	public List<Auction> auctions;
	private static final int MIN_AGE= 18;

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
	public void addAuction(int id) {
		
		auctions.addFirst((Auction)new AuctionClass(id));
		
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
	public String getUserInfo(String login) throws NoSuchUserException  {
		User decoy= new CollectorClass(login," ",0," ");
		int pos=users.find(decoy);
			if(pos<0) {

				throw new NoSuchUserException();
			}
		Collector collector=collectors.get(pos);
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

}
