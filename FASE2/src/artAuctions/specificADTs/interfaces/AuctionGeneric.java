/**
 * 
 */
package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import dataStructures.Iterator;
import dataStructures.IteratorEntries;

/**
 * Describes a generic Auction.
 * Esta interface contém apenas os 'getters' .
 */
public interface AuctionGeneric extends Serializable{
	
	int getNumOfWorks();
	
	String getId();

	boolean isClosed();
	
	IteratorEntries<String, WorkGeneric> listWorks();

	Iterator<WorkGeneric> listWorksInsertionOrder();
	

}
