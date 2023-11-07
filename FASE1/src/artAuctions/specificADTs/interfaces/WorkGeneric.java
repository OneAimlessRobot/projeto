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
 * Esta interface contém apenas os 'getters' .
 */
public interface WorkGeneric extends Serializable{

	int getYear();

	int getBidAmmount();

	Iterator<AuctionGeneric> auctionsWhoWantThis();
	
	int getMinBidAmmount();

	String getId();

	int getNumOfBids();
	
	ArtistGeneric getAuthor();

	String getName();
	
	UserGeneric getBuyer();
	
	
	Iterator<BidGeneric> bids();
	
	int getNumOfBidsFromAuction(String auctionid);

	FilteredIterator<BidGeneric> bidsFilteredByAuctionId(String auctionid);

	
	
	

}
