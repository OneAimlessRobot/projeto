/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;

import java.io.Serializable;

/**
 * This is the interface for a Generic Bid.
 * Esta interface contém apenas os 'getters' .
 */
public interface Bid extends Serializable{
	/**
	 * Returns the bidder
	 * 
	 * @return UserGeneric who made the Bid
	 */
	UserReadonly getCollector();
	
	/**
	 * Returns the Work that was bid on.
	 * 
	 * @return
	 */

	
	/**
	 * Returns the Amount of money the bidder decided to part with in order to acquire the work of art.
	 * 
	 * @return
	 */
	int getBidAmmount();

}
