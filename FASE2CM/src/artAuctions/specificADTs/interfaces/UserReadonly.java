/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/
package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.interfaces.Iterator;



/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */

public interface UserReadonly extends Serializable {
	/**
	 * Returns the name of a specific User
	 * @return
	 */
	String getName();
	
	/**
	 * Returns the login of a specific User
	 * 
	 * @return
	 */
	String getLogin();
	
	/**
	 * Returns the email of a specific User
	 * 
	 * @return
	 */
	String getEmail();
	
	/**
	 * Returns the age of a specific User
	 * 
	 * @return
	 */
	int getAge();
	
	/**
	 * Returns the number of Bids of a specific User
	 * @return
	 */
	int numOfBids();
	
	/**
	 * For a specific User, returns a string consisting of: Login Name Age Email
	 * 
	 * @return
	 */
	String printUser();
	/**
	 * Checks if the user can still be profitable.
	 * @return
	 */
	boolean userHasBidsInOpenAuction();
	/**
	 * Returns the bids made by this user
	 * @return
	 */
	Iterator<Bid> bids();
}
