package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/




public interface Bid extends  BidGeneric{

	void setCollector(User user);

	void setWork(Work work);
	
}
