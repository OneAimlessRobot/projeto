package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.Iterator;
public interface Auction extends Serializable{


	int getNumOfWorks();
	

	Iterator<Work> listWorks();
	
	int getId();

	void addWork(Work addedWork);

	
}
