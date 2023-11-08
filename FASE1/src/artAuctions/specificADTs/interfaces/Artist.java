package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


import dataStructures.Iterator;

/**
* Specific type of User. Creates Works of art.
*/
public interface Artist extends ArtistGeneric {


	void removeWork(Work work);
	
	
	void addWork(Work work);
	


	void setArtsyName(String newName);

	void clearWorks();
	
	

}

