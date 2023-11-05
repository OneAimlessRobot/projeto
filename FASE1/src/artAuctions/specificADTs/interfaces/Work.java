package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


import java.io.Serializable;

import dataStructures.FilteredIterator;
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
	
	int getNumOfBidsFromAuction(String auctionid);
	
	void setId(String id);

	Artist getAuthor();

	void setAuthor(Artist author);

	String getName();

	void setName(String name);

	public void setMinAmmount(int value);

	void removeBidsByUser(User user);

	FilteredIterator<Bid> bidsFilteredByAuctionId(String auctionId);

}