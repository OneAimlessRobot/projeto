package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.WorkExistsException;
import dataStructures.Iterator;

public interface AuctionManager extends Serializable{

	
	String users();
	
	void addArtist(String login, String name, String artsyName,int age, String email) throws UserExistsException, TooYoungException;

	String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException;

	String getUserInfo(String login) throws NoSuchUserException;

	String getWorkInfo(int id) throws NoSuchWorkException;

	void addUser(String login, String name, int age, String email) throws UserExistsException, TooYoungException;

	void addAuction(int id);

	void addWork(int id, String login, int year, String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException;
	
}
