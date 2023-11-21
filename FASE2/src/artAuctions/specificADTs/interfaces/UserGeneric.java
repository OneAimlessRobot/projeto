package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.FilteredIterator;
import dataStructures.FilteredIteratorWithPredicate;

/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */

public interface UserGeneric extends Serializable {

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
	String printUser();
	FilteredIteratorWithPredicate<Bid> bidsInOpenAuctions();
}
