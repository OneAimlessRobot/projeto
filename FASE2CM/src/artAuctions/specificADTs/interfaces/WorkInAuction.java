package artAuctions.specificADTs.interfaces;

import dataStructure.Iterator;

/**
 * Describes a Work that is currently in an Auction
 * 
 */
public interface WorkInAuction {

	//	@Override
	//	public IteratorEntries<Bid,Bid> bids() {
	//		return workBids.iterator();
	//	}
	
	/**
	 * Returns the List of Bids made on a specific Work
	 * @return 
	 */
	Iterator<Bid> bids();

	//	@Override
	//	public void addBid(Bid addedBid) {
	//		workBids.insert(addedBid,addedBid);
	//		
	//		
	//	}
	
	/**
	 * Add a Bid at the end of the List of Bids 
	 * @param addedBid
	 */
	void addBid(Bid addedBid);

	/**
	 * Returns the current highest Bid of a Work
	 * @return Current highest Bid of a Work
	 */
	Bid getMaxBid();

	/**
	 * Sets the current highest Bid of a Work
	 * @param bid
	 */
	void setMaxBid(Bid bid);

	/**
	 * Returns the lenght of the List of Bids of a Work, thus obtaining the total number of Bids
	 * @return
	 */
	int getNumOfBids();

	/**
	 * Returns the Work that is associated with the WorkInAuction
	 * @return
	 */
	WorkReadonly getWork();

	/**
	 * Returns the Auction where the Work is getting auctioned
	 * @return
	 */
	AuctionReadonly getAuction();

}