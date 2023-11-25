/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

/**
 * This is the interface for a Generic Bid.
 * Esta interface contém apenas os 'getters' .
 */
public interface Bid extends Serializable{
	
	UserReadonly getCollector();
	
	WorkReadonly getWork();

	int getBidAmmount();
	
	AuctionReadonly getAuction();

}
