package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

public interface Work extends Serializable{

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