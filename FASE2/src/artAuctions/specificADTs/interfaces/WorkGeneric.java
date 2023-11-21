/**
 * 
 */
package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import dataStructures.FilteredIterator;
import dataStructures.Iterator;


/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */
public interface WorkGeneric extends Comparable<WorkGeneric>{

	int getYear();


	Bid getMaxBid();
	

	String getId();

	int getNumOfBids();
	
	ArtistGeneric getAuthor();

	String getName();
	
	UserGeneric getBuyer();
	
	
	Iterator<Bid> bids();
	
	int getNumOfBidsFromAuction(String auctionid);

	FilteredIterator<Bid> bidsFilteredByAuctionId(String auctionid);


	int getMinBidAmmount();


	
	
	

}
