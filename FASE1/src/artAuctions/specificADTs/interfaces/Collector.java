package artAuctions.specificADTs.interfaces;

public interface Collector extends User{

	
	void addBid(Bid addedBid);

	int numOfBids();
}
