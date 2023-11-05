/**
 * 
 */
package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

/**
 * Esta interface contém apenas os 'getters' .
 */
public interface WorkGeneric extends Serializable{

	int getYear();
	
	int getBidAmmount();

	String getId();

	int getNumOfBids();
	
	Artist getAuthor();

	String getName();
	
	
	

}
