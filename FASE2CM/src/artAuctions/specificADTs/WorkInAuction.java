package artAuctions.specificADTs;


/**
 * Describes a Work that is currently in an Auction
 * 
 */
interface WorkInAuction extends WorkInAuctionReadonly{


	/**
	 * Sets the current highest Bid of a Work
	 * @param bid
	 */
	void setMaxBid(Bid bid);

	/**
	 * Add a Bid at the end of the List of Bids 
	 * @param addedBid
	 */
	void addBid(Bid addedBid);
	
	void removeBid(Bid removedBid);


}