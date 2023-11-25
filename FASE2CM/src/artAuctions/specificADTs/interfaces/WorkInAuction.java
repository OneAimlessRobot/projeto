package artAuctions.specificADTs.interfaces;

import dataStructure.Iterator;

public interface WorkInAuction {

	//	@Override
	//	public IteratorEntries<Bid,Bid> bids() {
	//		return workBids.iterator();
	//	}
	Iterator<Bid> bids();

	//	@Override
	//	public void addBid(Bid addedBid) {
	//		workBids.insert(addedBid,addedBid);
	//		
	//		
	//	}
	void addBid(Bid addedBid);

	Bid getMaxBid();

	void setMaxBid(Bid bid);

	int getNumOfBids();

	WorkGeneric getWork();

	AuctionGeneric getAuction();

}