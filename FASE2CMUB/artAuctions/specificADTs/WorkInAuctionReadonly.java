package artAuctions.specificADTs;

import dataStructures.Iterator;

public interface WorkInAuctionReadonly {

	/**
	 * Returns the current highest Bid of a Work
	 * @return Current highest Bid of a Work
	 */
	Bid getMaxBid();

	/**
	 * Returns the List of Bids made on a specific Work
	 * @return 
	 */
	Iterator<Bid> bids();

	
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
	/**
	 * The minBidammount of a work in the auction this is connected to
	 * @return
	 */
	int getMinBidAmmount();
}
