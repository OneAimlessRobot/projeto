/**
 * 
 */
package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


/**
 * Describes a Generic Work. This interface is used for the 'getters' of the interface Work, essentially.
 * Esta interface contém apenas os 'getters' .
 */
public interface WorkGeneric extends Comparable<WorkGeneric>{

	int getYear();


	Bid getMaxBid();
	

	String getId();

	ArtistGeneric getAuthor();

	String getName();
	
	UserGeneric getBuyer();
	
	

	int getMinBidAmmount();


	
	
	

}
