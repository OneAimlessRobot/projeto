/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


package artAuctions.specificADTs;



/**
* Describes a Work (Obra de Arte).
*/
interface Work extends WorkReadonly{

/**
 * Sets the max EVER bid made on this work. Is the bid REALLY the max one? that is determined by the sell method in the auction Manager type
 * @param bid
 */
	void setMaxBid(Bid bid);



}