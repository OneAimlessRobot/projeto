package artAuctions.specificADTs.interfaces;

import dataStructures.Iterator;

/**
* Generic Artist. Has the 'getters'.
*/
public interface ArtistGeneric extends UserGeneric {

	

	String getArtsyName();

	String printArtist();
	
	int getNumOfWorks();
	
	Iterator<WorkGeneric> works();

	boolean hasWork(Work work);
}
