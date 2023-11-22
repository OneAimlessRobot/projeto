package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/




/**
* Describes a Work (Obra de Arte).
*/
public interface Work extends WorkGeneric{

	void addBid(Bid addedBid);

	void setMaxBid(Bid bid);



	public void setMinAmmount(int value);

}