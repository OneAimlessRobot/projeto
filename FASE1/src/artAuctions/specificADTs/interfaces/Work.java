package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.Iterator;

public interface Work extends Serializable{

	Iterator<Bid> bids();
	
	void addBid(Bid addedBid);
	
	int getYear();

	void setYear(int year);

	void setSoldAmmount(int value);

	int getBidAmmount();

	int getId();

	int getNumOfBids();
	
	void setId(int id);

	Artist getAuthor();

	void setAuthor(Artist author);

	String getName();

	void setName(String name);

}