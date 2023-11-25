/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructure.Iterator;

/**
 * Describes a generic Auction.
 * Esta interface contém apenas os 'getters' .
 */
public interface AuctionReadonly extends Serializable{
	
	int getNumOfWorks();
	
	String getId();

	boolean isClosed();
	
	Iterator<WorkInAuction> listWorks();

	WorkInAuction getWorkInAuction(WorkReadonly work);


	

}
