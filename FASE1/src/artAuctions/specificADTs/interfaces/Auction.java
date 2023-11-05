package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/



import dataStructures.Iterator;
public interface Auction extends AuctionGeneric{


	Iterator<Work> listWorks();
	
	boolean hasWork(Work work);

	void removeWork(Work work);

	void addWork(Work addedWork);

	
}
