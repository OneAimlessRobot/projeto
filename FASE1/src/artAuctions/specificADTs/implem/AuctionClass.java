package artAuctions.specificADTs.implem;
import dataStructures.*;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import artAuctions.specificADTs.interfaces.Work;

public class AuctionClass implements Serializable, Auction {

	private static final long serialVersionUID = 1L;
	
	public int id;
	public List<Work> works;
	public List<User> users;
	public List<Collector> collectors;
	public List<Artist> artists;

	public AuctionClass(int id) {
		
		this.id=id;
		works= new Vector<>();
		users= new Vector<>();
		collectors= new Vector<>();
		artists= new Vector<>();
	}

	@Override
	public Iterator<Work> listWorks() {
		
		return works.iterator();
	}

	@Override
	public void AddWork() {
		return;
		
	}

	@Override
	public void AddArtist(String login,String name,String artsyName,int age,String email) {
		artists.addFirst((Artist)new ArtistClass(login,name,artsyName,age,email));
	}

	@Override
	public void AddUser() {
		
		
	}

	@Override
	public int getId() {
		return id;
	}
	
	
}
