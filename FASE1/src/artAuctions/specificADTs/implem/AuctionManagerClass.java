package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Auction;
import artAuctions.specificADTs.interfaces.AuctionManager;
import artAuctions.specificADTs.interfaces.Collector;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;
import dataStructures.DoubleList;
import dataStructures.List;
import dataStructures.Vector;

public class AuctionManagerClass implements Serializable, AuctionManager {

	private static final long serialVersionUID = 1L;

	public List<Work> works;
	public List<User> users;
	public List<Collector> collectors;
	public List<Artist> artists;
	public List<Auction> auctions;

	public AuctionManagerClass() {
		

		works= new Vector<>();
		users= new Vector<>();
		collectors= new Vector<>();
		artists= new Vector<>();
		auctions= new DoubleList<>();
		
	}
	@Override
	public void addWork(int id, String login,int year,String name) throws NoSuchArtistException {
		User user,decoy= new CollectorClass(login," ",0," ");
		int pos=users.find(decoy);
		if(pos<0) {

			throw new NoSuchArtistException();
		}
		
		else if(!((user=users.get(pos)) instanceof ArtistClass)) {
			

			throw new NoSuchArtistException();
			
		}
		
		works.addFirst((Work)new WorkClass(id,(Artist)user , year, name));
	}
	
	@Override
	public void addAuction(int id) {
		
		auctions.addFirst((Auction)new AuctionClass(id));
		
	}
	@Override
	public void addUser(String login,String name,int age,String email) {
		Collector newUser=(Collector)new CollectorClass(login,name,age,email);
		collectors.addFirst(newUser);
		users.addFirst(newUser);
		
	}
	

	@Override
	public void AddArtist(String login,String name,String artsyName,int age,String email) {
		Artist newUser=(Artist)new ArtistClass(login,name,artsyName,age,email);
		artists.addFirst(newUser);
		users.addFirst(newUser);
	}

}
