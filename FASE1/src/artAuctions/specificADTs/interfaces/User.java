package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


public interface User extends Serializable {
	

	String getName();
	String getLogin();
	String getEmail();
	int getAge();
	void addBid(Bid addedBid);
	void removeBidsByWork(Work work);
	int numOfBids();
	String printUser();
}
