package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/




import dataStructures.FilteredIterator;
import dataStructures.Iterator;

public interface Work extends WorkGeneric{

	void addBid(Bid addedBid);

	void setYear(int year);

	void setSoldAmmount(int value);

	void setId(String id);

	void setAuthor(Artist author);
	
	void setName(String name);

	public void setMinAmmount(int value);

	void removeBidsByUser(User user);

}