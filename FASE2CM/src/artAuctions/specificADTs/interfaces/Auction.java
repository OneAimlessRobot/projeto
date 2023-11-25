/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/
package artAuctions.specificADTs.interfaces;



/**
* Contains a collection of Works.
*/

public interface Auction extends AuctionReadonly{
/**
 * Adds work to auction
 * @param addedWork
 * @param minAmmount
 */

	void addWork(Work addedWork, int minAmmount);

	
	/**
	 * 
	 * closes the auction
	 */
	void close();

	
}
