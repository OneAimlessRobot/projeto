package artAuctions.specificADTs.implem;
import dataStructures.*;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import artAuctions.specificADTs.interfaces.Work;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/



public class AuctionClass implements Serializable, Auction {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private List<Work> works;
//	public List<User> users;
//	public List<Collector> collectors;
//	public List<Artist> artists;

	public AuctionClass(int id) {
		
		this.id=id;
		works= new Vector<>();
//		users= new Vector<>();
//		collectors= new Vector<>();
//		artists= new Vector<>();
	}

	@Override
	public Iterator<Work> listWorks() {
		
		return works.iterator();
	}

	public boolean equals(Object auction) {
		boolean result=false;

		if(!(auction instanceof Auction)) {

			return false;
			
		}
		else {
		result= ((Auction)auction).getId()==this.getId();
		}
		return result;
		
		
		
	}
	@Override
	public void addWork(Work addedWork) {
		works.addFirst(addedWork);
	}

	public String toString() {
		
		return ""+getId()+"\nWorks: "+works.toString();
	}
	
	@Override
	public int getId() {
		return id;
	}

	public int getNumOfWorks() {
		return works.size();
	}
	
	
}
