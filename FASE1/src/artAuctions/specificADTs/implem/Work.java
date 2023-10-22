package artAuctions.specificADTs.implem;

import artAuctions.specificADTs.interfaces.Artist;

public interface Work {

	int getYear();

	void setYear(int year);

	void setMinBidAmmount(int value);

	int getMinBidAmmount();

	int getId();

	void setId(int id);

	Artist getAuthor();

	void setAuthor(Artist author);

	String getName();

	void setName(String name);

}