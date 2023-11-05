package artAuctions.specificADTs.interfaces;

import dataStructures.Iterator;

public interface ArtistGeneric extends UserGeneric {

	

	String getArtsyName();

	String printArtist();
	
	int getNumOfWorks();

	boolean hasWork(Work work);
}
