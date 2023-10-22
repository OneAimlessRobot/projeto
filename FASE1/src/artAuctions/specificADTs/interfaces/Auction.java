package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.Iterator;
public interface Auction extends Serializable{



	Iterator<Work> listWorks();
	
	void AddWork();
	
	
	void AddUser();
	
	int getId();

	void AddArtist(String login, String name, String artsyName,int age, String email);
	
	
}
