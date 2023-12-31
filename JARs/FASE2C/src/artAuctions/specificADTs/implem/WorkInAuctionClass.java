package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import dataStructures.List;
import dataStructures.DoubleList;
import dataStructures.Iterator;

/**
* Implements interface Work. Describes a Work (Obra de Arte).
*/
public class WorkInAuctionClass implements Serializable, WorkInAuction {

	private static final long serialVersionUID = 1L;
	
	private WorkGeneric work;
	private AuctionGeneric auction;
	
	
	public List<Bid> workBids;
	public Bid currMaxBid;
	
	public WorkInAuctionClass(WorkGeneric work) {
		
//		workBids=new SepChainHashTable<>();
		workBids= new DoubleList<>();
		this.work=work;
		currMaxBid= new BidClass(null,null,0,null);
	}
		@Override
	public Iterator<Bid> bids() {
	return workBids.iterator();
}
//	@Override
//	public void addBid(Bid addedBid) {
//		workBids.insert(addedBid,addedBid);
//		
//		
//	}
		@Override
		public void addBid(Bid addedBid) {
			workBids.addLast(addedBid);
			
			
		}
		@Override
	public int getNumOfBids() {
		return workBids.size();
	}
		@Override
		public WorkGeneric getWork() {
			return work;
		}@Override
		public AuctionGeneric getAuction() {
			return auction;
		}
	@Override
	public Bid getMaxBid() {
		return currMaxBid;
	}
	@Override
	public void setMaxBid(Bid bid) {
		currMaxBid=bid;
	}
}
