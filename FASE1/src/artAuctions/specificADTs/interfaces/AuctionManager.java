package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

import artAuctions.exceptions.AuctionEmptyException;
import artAuctions.exceptions.AuctionExistsException;
import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchAuctionException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.WeakBidException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.exceptions.WorkExistsInAuctionException;
import dataStructures.Iterator;

public interface AuctionManager extends Serializable{

	
	String users();
	
	void addArtist(String login, String name, String artsyName,int age, String email) throws UserExistsException, TooYoungException;

	String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException;

	String getUserInfo(String login) throws NoSuchUserException;

	String getWorkInfo(int id) throws NoSuchWorkException;

	void addWorkToAuction(int auctionid,int workid,int minValue) throws NoSuchWorkException, NoSuchAuctionException, WorkExistsInAuctionException;
	
	Iterator<Work> getAuctionWorks(int auctionid) throws NoSuchAuctionException, AuctionEmptyException;
	Iterator<Bid> getBidsFromAuctionWork(int auctionid,int workid) throws NoSuchWorkException,  NoSuchAuctionException, NoSuchWorkInAuctionException;
	void addUser(String login, String name, int age, String email) throws UserExistsException, TooYoungException;

	void addAuction(int id) throws AuctionExistsException;

	void addWork(int id, String login, int year, String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException;

	void addBidToWork(int auctionid,int workid,String collectorlogin,int value) throws NoSuchUserException, NoSuchWorkInAuctionException, NoSuchWorkException, NoSuchAuctionException, WeakBidException;
}
