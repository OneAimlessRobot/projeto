/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.interfaces;

/**
* Users can Bid on Works that are up for sale in an Auction. An Artist is a specific type of User.
* 
*/
public interface User extends UserReadonly {

	

	/**
	 * Stores a bid a user made.
	 * @param addedBid
	 */
	void addBid(Bid addedBid);
	
}
