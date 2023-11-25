/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.interfaces;


/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */
public interface WorkReadonly extends Comparable<WorkReadonly>{

	/**
	 * Return the year of creation of a Work
	 * 
	 * @return
	 */
	int getYear();

	/**
	 * Returns the highest Bid of an Work
	 * 
	 * @return
	 */
	Bid getMaxBid();
	
	/**
	 * Returns the Id of a Work.
	 * 
	 * @return
	 */
	String getId();

	/**
	 * Returns the Artist that created a specific Work
	 * 
	 * @return ArtistGeneric
	 */
	ArtistReadonly getAuthor();

	/**
	 * Returns the name of the Work as a string of characters.
	 * 
	 * @return String
	 */
	String getName();
	
	/**
	 * Returns the buyer (User) of a Work.
	 * 
	 * @return 
	 */
	UserReadonly getBuyer();
	
	
	
	

}
