package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.Iterator;
public interface Auction extends Serializable{



	Iterator<Work> listWorks();
	
	void AddWork();
	
	void AddArtist();
	
	void AddUser();
	
	
}
