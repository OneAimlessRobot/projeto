package artAuctions.specificADTs.interfaces;

/**
* Users can Bid on Works that are up for sale in an Auction. An Artist is a specific type of User.
* 
*/
public interface User extends UserGeneric {

	

	/**
	 * 
	 * @param addedBid
	 */
	void addBid(Bid addedBid);
	
}
