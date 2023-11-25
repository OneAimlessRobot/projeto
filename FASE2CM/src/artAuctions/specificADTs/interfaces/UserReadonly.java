/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/
package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructure.Iterator;



/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */

public interface UserReadonly extends Serializable {

/**
 * Name of this user
 * @return
 */
	String getName();
	/**
	 * 
	 * @return
	 */
	String getLogin();
	/**
	 * 
	 * @return
	 */
	String getEmail();
	/**
	 * 
	 * @return
	 */
	int getAge();
	/**
	 * 
	 * @return
	 */
	int numOfBids();
	/**
	 * 
	 * @return
	 */
	
	boolean userHasBidsInOpenAuction();
	String printUser();
	Iterator<Bid> bids();
}
