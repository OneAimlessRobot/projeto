/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


package artAuctions.specificADTs.interfaces;



/**
* Describes a Work (Obra de Arte).
*/
public interface Work extends WorkReadonly{


	void setMaxBid(Bid bid);



	public void setMinAmmount(int value);

}