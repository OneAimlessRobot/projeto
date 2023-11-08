/**
 * 
 */
package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import dataStructures.FilteredIterator;
import dataStructures.Iterator;


/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */
public interface WorkGeneric extends Serializable{

	int getYear();


	BidGeneric getMaxBid();
	

	String getId();

	int getNumOfBids();
	
	ArtistGeneric getAuthor();

	String getName();
	
	UserGeneric getBuyer();
	
	
	Iterator<BidGeneric> bids();
	
	int getNumOfBidsFromAuction(String auctionid);

	FilteredIterator<BidGeneric> bidsFilteredByAuctionId(String auctionid);


	int getMinBidAmmount();


	
	
	

}
