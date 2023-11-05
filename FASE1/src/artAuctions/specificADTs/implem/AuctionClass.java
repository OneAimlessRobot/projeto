package artAuctions.specificADTs.implem;
import dataStructures.*;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/



public class AuctionClass implements Serializable, Auction {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<Work> works;

	public AuctionClass(String id) {
		
		this.id=id;
//		works= new DoubleList<>();
		works= new Vector<>();
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
		if(id==null) {
			if(((Auction)auction).getId()==null) {

				result=true;
			}
		}
		else if(((Auction)auction).getId()==null) {
			
			result=false;
			
		}
		else {
		result= ((Auction)auction).getId().equals(this.getId());
		}
		return result;
		
	}
	@Override
	public void addWork(Work addedWork) {
		works.addLast(addedWork);
	}

	public String toString() {
		
		return getId()+"\nWorks: "+works.toString();
	}
	
	@Override
	public String getId() {
		return id;
	}

	public int getNumOfWorks() {
		return works.size();
	}
	

	@Override
	public boolean hasWork(Work work) {

		return works.find(work)>=0;
		
	}
	@Override
	public void removeWork(Work work) {
		
		if(hasWork(work)) {
			
			works.remove(work);
		}
		
	}
}
