package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


import java.io.Serializable;

import dataStructures.Iterator;
public interface Auction extends Serializable{


	int getNumOfWorks();
	

	Iterator<Work> listWorks();
	
	String getId();

	boolean hasWork(Work work);

	void removeWork(Work work);

	void addWork(Work addedWork);

	
}
