package artAuctions.specificADTs.interfaces;

import dataStructures.Iterator;

public interface Artist extends User {

	
	String getArtsyName();
	
	int getNumOfWorks();
	
	void addWork(Work work);
	
	Iterator<Work> works();
}

