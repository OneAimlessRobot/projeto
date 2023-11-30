/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;

import java.io.Serializable;

import dataStructures.Iterator;

/**
 * Describes a generic Auction.
 * Esta interface contém apenas os 'getters' .
 */
public interface AuctionReadonly extends Serializable{

	/**
	 * Returns the number of Works present for auction in a specific Auction.
	 * Uses the method size().
	 * @return
	 */
	int getNumOfWorks();
	
	/**
	 * Returns the ID of an Auction
	 * Used in the method equals().
	 * @return
	 */
	String getId();
	
	/**
	 * Returns an iterator of the collection of Works of a specific Auction
	 * @return
	 */
	

	Iterator<WorkInAuctionReadonly> listWorks();
	/**
	 * If present returns a work in this auctions work collection that is equal to the parameter
	 * @return
	 */
	
	WorkInAuctionReadonly getWorkInAuction(WorkReadonly work);

	

}
