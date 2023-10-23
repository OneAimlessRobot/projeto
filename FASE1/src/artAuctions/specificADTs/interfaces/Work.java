package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


import java.io.Serializable;

import dataStructures.Iterator;

public interface Work extends Serializable{

	Iterator<Bid> bids();
	
	void addBid(Bid addedBid);
	
	int getYear();

	void setYear(int year);

	void setSoldAmmount(int value);

	int getBidAmmount();

	String getId();

	int getNumOfBids();
	
	void setId(String id);

	Artist getAuthor();

	void setAuthor(Artist author);

	String getName();

	void setName(String name);

}