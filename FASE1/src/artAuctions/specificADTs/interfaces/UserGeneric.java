package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import dataStructures.FilteredIterator;
import dataStructures.FilteredIteratorWithPredicate;

/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


public interface UserGeneric extends Serializable {


	String getName();
	String getLogin();
	String getEmail();
	int getAge();
	void addBid(Bid addedBid);
	int numOfBids();
	String printUser();
	FilteredIteratorWithPredicate<BidGeneric> bidsInOpenAuctions();
}
