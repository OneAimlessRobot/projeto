package artAuctions.specificADTs;

interface UserBidder extends UserBidderReadonly {
	
	void incBids();

	void decBids();
}
