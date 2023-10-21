package artAuctions.specificADTs.implem;
import dataStructures.*;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;

public class AuctionClass implements Serializable, Auction {

	private static final long serialVersionUID = 1L;

	public Vector<Work> works,users,collectors,artists;
	
	public AuctionClass() {
		

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
	public void AddArtist() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddUser() {
		// TODO Auto-generated method stub
		
	}
	
	
}
