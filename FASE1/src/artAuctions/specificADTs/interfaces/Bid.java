package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/



/**
* Works that are up for Auction have Bids made on them.
* 
*/

public interface Bid extends  BidGeneric{

	void setCollector(User user);

	void setWork(Work work);

	void setBidAmmount(int bidAmmount);
	
}
