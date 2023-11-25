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

	int getYear();


	Bid getMaxBid();
	

	String getId();

	ArtistReadonly getAuthor();

	String getName();
	
	UserReadonly getBuyer();
	
	

	int getMinBidAmmount();


	
	
	

}
