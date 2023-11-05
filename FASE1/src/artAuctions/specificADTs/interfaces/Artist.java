package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


import dataStructures.Iterator;

public interface Artist extends User {

	
	String getArtsyName();
	
	int getNumOfWorks();
	
	void clearWorks();

	void removeWork(Work work);
	
	boolean hasWork(Work work);
	
	void addWork(Work work);
	
	Iterator<Work> works();

	String printArtist();
	
	void setArtsyName(String newName);
}

