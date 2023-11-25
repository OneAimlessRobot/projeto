/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.interfaces;


import java.io.Serializable;

import artAuctions.exceptions.ArtistHasNoWorksException;
import artAuctions.exceptions.ArtistHasWorksInAuctionException;
import artAuctions.exceptions.AuctionEmptyException;
import artAuctions.exceptions.AuctionExistsException;
import artAuctions.exceptions.NoSoldWorksException;
import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchAuctionException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.UserHasBidsException;
import artAuctions.exceptions.WeakBidException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.exceptions.WorkExistsInAuctionException;
import artAuctions.exceptions.WorkHasNoBidsInAuctionException;
import dataStructure.Entry;
import dataStructure.Iterator;


/**
* Encompasses the whole thing.
*/
public interface AuctionManager extends Serializable{

	
	void addArtist(String login, String name, String artsyName,int age, String email) throws UserExistsException, TooYoungException;

	String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException;

	String getUserInfo(String login) throws NoSuchUserException;

	String getWorkInfo(String id) throws NoSuchWorkException;

	void addWorkToAuction(String auctionid,String workid,int minValue) throws NoSuchAuctionException, WorkExistsInAuctionException, NoSuchWorkException;
	
	Iterator<WorkInAuction> getAuctionWorks(String auctionid) throws NoSuchAuctionException, AuctionEmptyException;

	Iterator<Bid> getBidsFromWork(String auctionid,String workid) throws NoSuchWorkException,  NoSuchAuctionException, NoSuchWorkInAuctionException, WorkHasNoBidsInAuctionException;

	void addUser(String login, String name, int age, String email) throws UserExistsException, TooYoungException;

	void removeUser(String login) throws NoSuchUserException, UserHasBidsException,  ArtistHasWorksInAuctionException;

	void addAuction(String id) throws AuctionExistsException;

	void addWork(String id, String login, int year, String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException;

	void addBidToWork(String auctionid,String workid,String collectorlogin,int value) throws NoSuchUserException, NoSuchWorkInAuctionException, NoSuchWorkException, NoSuchAuctionException, WeakBidException;
	
	AuctionReadonly closeAuction(String auctionid) throws NoSuchAuctionException;


	Iterator<Entry<WorkReadonly, WorkReadonly>> getArtistWorks(String artistLogin) throws NoSuchUserException, NoSuchArtistException, ArtistHasNoWorksException;

	Iterator<Entry<WorkReadonly, WorkReadonly>> listWorksByValue() throws NoSoldWorksException;

	void sellAuctionWork(WorkReadonly currWork, String auctionId);
}
