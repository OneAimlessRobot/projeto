package artAuctions.specificADTs.implem;
import dataStructures.*;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


/**
* Implements interface Auction. Describes an Auction.
*/ 
public class AuctionClass implements Serializable, Auction {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Dictionary<String,WorkGeneric> works;
	private List<WorkGeneric> worksInInsertionOrder;
	private boolean isClosed;

	public AuctionClass(String id) {
		
		this.id=id;
		isClosed=false;
		works= new SepChainHashTable<>();
		worksInInsertionOrder=new DoubleList<>();
	}

	@Override
	public IteratorEntries<String,WorkGeneric> listWorks() {
		
		return works.iterator();
	}
	@Override
	public Iterator<WorkGeneric> listWorksInsertionOrder() {
		
		return worksInInsertionOrder.iterator();
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
		if(works.insert(addedWork.getId(),addedWork)==null) {
		worksInInsertionOrder.addLast(addedWork);
		}
	}

	public String toString() {
		
		return getId()+"\nWorks: "+works.toString();
	}
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public int getNumOfWorks() {
		return works.size();
	}
	

	@Override
	public boolean isClosed() {
		return isClosed;
	}

	@Override
	public void close() {
		isClosed=true;
		
	}

}
