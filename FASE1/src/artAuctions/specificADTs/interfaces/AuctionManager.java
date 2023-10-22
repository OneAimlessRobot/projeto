package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import artAuctions.exceptions.NoSuchArtistException;

public interface AuctionManager extends Serializable{

	

	void AddArtist(String login, String name, String artsyName,int age, String email);

	void addUser(String login, String name, int age, String email);

	void addAuction(int id);

	void addWork(int id, String login, int year, String name) throws NoSuchArtistException;
	
}
