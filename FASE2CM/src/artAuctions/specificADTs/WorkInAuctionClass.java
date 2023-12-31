/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;

import java.io.Serializable;

import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.List;

/**
* Implements interface Work. Describes a Work (Obra de Arte).
*/
class WorkInAuctionClass implements Serializable, WorkInAuction {

	private static final long serialVersionUID = 1L;
	
	private WorkReadonly work;
	
	
	private List<Bid> workBids;
	private Bid currMaxBid;
	private int minAmmount;
	
	
	public WorkInAuctionClass(WorkReadonly work,int minAmmount) {

		workBids= new DoubleList<>();
		this.work=work;
		this.minAmmount=minAmmount;
		currMaxBid= new BidClass(null,0);
	}
		@Override
	public Iterator<Bid> bids() {
	return workBids.iterator();
}
		@Override
		public void addBid(Bid addedBid) {
			workBids.addLast(addedBid);
			
			
		}
	public boolean equals(Object anotherWorkInAuction) {
		
		if(anotherWorkInAuction instanceof WorkInAuctionClass) {
			return ((WorkInAuctionClass)anotherWorkInAuction).getWork().equals(getWork());
			
		}
		return false;
	}
		@Override
	public int getNumOfBids() {
		return workBids.size();
	}
		@Override
		public WorkReadonly getWork() {
			return work;
		}
	@Override
	public Bid getMaxBid() {
		return currMaxBid;
	}
	@Override
	public void setMaxBid(Bid bid) {
		currMaxBid=bid;
	}
	@Override
	public int getMinBidAmmount() {
		return minAmmount;
	}
	@Override
	public void removeBid(Bid removedBid) {
		workBids.remove(removedBid);
		
	}
}
