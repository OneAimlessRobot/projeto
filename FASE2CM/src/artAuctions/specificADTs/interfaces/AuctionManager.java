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
import dataStructures.interfaces.Entry;
import dataStructures.interfaces.Iterator;


/**
 * An auction manager. This type is going to be used as a singleton that wrapps this application up.
 * It pulls all the strings and manipulates all the other classes. The other classes are merely vessels of other classes and fields.
 * This one contains all the muscle.
 * 
 * An auction manager manages auctions of artworks. People can create accounts and make bids in one auction, if present, on one or multiple
 * works present in said auctions. The accounts can be of two types: 
 * Users and Artists. 
 * Users can only make bids.
 * Artists can do everything users do and also publish works 
 * (Every work present in an auction must be from a registered auction)
 * Users are essentially containers of bids. 
 * Artists are the same and also contain Works.
 * Works are what artists make. They can only be bidded on after a certain value. ( Value is shared across all auctions where they reside)
 * Auctions are containers of works.
 * Users and Artists are uniquely determined by a shared pool of ids. (Artists are just premium Users)
 * Works are also determined by ids, same with auctions.
 * These last 4 entities are the main actors of the system.
 * There are 2 of what we like to call "Linker objects". Objects that are purely made to allow direct communication between classes.
 * One of them is Bid. it connects a user to a work. A user (Artist or not) can make a bid on a work. The bid connects the two.
 * A user can have several of them.
 * The other one is WorkInAuction. They connect auctions to works and contain a collection of bids make on that work on that auction.
 * 
 * These commands resume everything that can be done in any application that should implement and instantiate this type. 
 * 
 * This is the main type and it does ALL the logic. Adds things, removes things. Calls all the iterators.
 * 
 * 
 * 
 * 
* Encompasses the whole thing.
*/
public interface AuctionManager extends Serializable{

	/**
	 * addArtist command.
	 * Adds an Artist to the artists collection.
	 * @param login
	 * @param name
	 * @param artsyName
	 * @param age
	 * @param email
	 * @throws UserExistsException
	 * @throws TooYoungException
	 */
	void addArtist(String login, String name, String artsyName,int age, String email) throws UserExistsException, TooYoungException;

	/**
	 * Returns information about a specific Artist. 
	 * Prints the Login, the Name, The Artistic Name, the Age and the Email of an Artist.
	 * @param login
	 * @return Returns information about a specific Artist, in the collection of Artists, in an auctionManager class.
	 * @throws NoSuchArtistException
	 * @throws NoSuchUserException
	 */
	String getArtistInfo(String login) throws NoSuchArtistException, NoSuchUserException;
	
	/**
	 * Searches for the User with the specific login in the User collection
	 * Returns a string consisting of: Login Name Age Email
	 * @param login
	 * @return A string consisting of: Login Name Age Email
	 * @throws NoSuchUserException
	 */
	String getUserInfo(String login) throws NoSuchUserException;

	/**
	 * Searches for a Work by id in the collections of Works.
	 * Returns a string consisting of: IdOfWork Name Year CurrentMaxBidAmmount AuthorLogin AuthorName.
	 * @param id
	 * @return IdOfWork Name Year CurrentMaxBidAmmount AuthorLogin AuthorName
	 * @throws NoSuchWorkException
	 */
	String getWorkInfo(String id) throws NoSuchWorkException;

	/**
	 * addWork command.
	 * Searches the collection of Auctions for the Auction with the specific auctionid.
	 * Then Searches the collection of Works for the Work with the specific workid.
	 * Throws the appropriate exceptions if those are not found.
	 * Finally, adds the Work with workid to the Auction with auctionid
	 * @param auctionid
	 * @param workid
	 * @param minValue
	 * @throws NoSuchAuctionException
	 * @throws WorkExistsInAuctionException
	 * @throws NoSuchWorkException
	 */
	void addWorkToAuction(String auctionid,String workid,int minValue) throws NoSuchAuctionException, WorkExistsInAuctionException, NoSuchWorkException;
	
	/**
	 * Returns the collection of Works present at a specific Auction.
	 * 
	 * @param auctionid
	 * @return
	 * @throws NoSuchAuctionException
	 * @throws AuctionEmptyException
	 */
	Iterator<WorkInAuctionReadonly> getAuctionWorks(String auctionid) throws NoSuchAuctionException, AuctionEmptyException;
	
	/**
	 * Returns the Bids that a Work has on a specific Auction.
	 * 
	 * @param auctionid
	 * @param workid
	 * @return
	 * @throws NoSuchWorkException
	 * @throws NoSuchAuctionException
	 * @throws NoSuchWorkInAuctionException
	 * @throws WorkHasNoBidsInAuctionException
	 */
	Iterator<Bid> getBidsFromWork(String auctionid,String workid) throws NoSuchWorkException,  NoSuchAuctionException, NoSuchWorkInAuctionException, WorkHasNoBidsInAuctionException;
	
	/**
	 * addUser command.
	 * Inserts a User at the end of the collection of Users.
	 * Checks the minimum age and if the User already exists.
	 */
	void addUser(String login, String name, int age, String email) throws UserExistsException, TooYoungException;

	/**
	 * removeUser command.
	 * Finds User in the users and artists collections. 
	 * If the Artist has works in a bid or the User has bids in an Auction, throws exception.
	 * @param login
	 * @throws NoSuchUserException
	 * @throws UserHasBidsException
	 * @throws ArtistHasWorksInAuctionException
	 */
	void removeUser(String login) throws NoSuchUserException, UserHasBidsException,  ArtistHasWorksInAuctionException;

	/**
	 * createAuction command.
	 * Adds Auction with the Id id to the collection of auctions. Adds at the end of the collection.
	 * @param id
	 * @throws AuctionExistsException
	 */
	void addAuction(String id) throws AuctionExistsException;

	/**
	 * addWork command.
	 * Adds a Work to the general collection of Works, and to the collection of Works of a specific Artist.
	 * 
	 * @param id
	 * @param login
	 * @param year
	 * @param name
	 * @throws NoSuchArtistException
	 * @throws NoSuchUserException
	 * @throws WorkExistsException
	 */
	void addWork(String id, String login, int year, String name) throws NoSuchArtistException, NoSuchUserException, WorkExistsException;

	/**
	 * bid command.
	 * Finds the User in the users collection. Find the work and the auction in their respective collections, too.
	 * Checks the exceptions.
	 * Adds a bid to the collection of bids of a specific User.
	 * Then Adds the bid to the collection of bids of a specific Work.
	 * 
	 * @param auctionid
	 * @param workid
	 * @param collectorlogin
	 * @param value
	 * @throws NoSuchUserException
	 * @throws NoSuchWorkInAuctionException
	 * @throws NoSuchWorkException
	 * @throws NoSuchAuctionException
	 * @throws WeakBidException
	 */
	void addBidToWork(String auctionid,String workid,String collectorlogin,int value) throws NoSuchUserException, NoSuchWorkInAuctionException, NoSuchWorkException, NoSuchAuctionException, WeakBidException;
	
	/**
	 * closeAuction command.
	 * Find the auction in the collection of Auctions and closes it.
	 * Then removes the Auction from the collection of Auctions of the system.
	 * 
	 * @param auctionid
	 * @return AuctionReadonly
	 * @throws NoSuchAuctionException
	 */
	AuctionReadonly closeAuction(String auctionid) throws NoSuchAuctionException;

	/**
	 * Returns a iterator of Works sorted by value and name.
	 * @param artistLogin
	 * @return Iterator<Entry<WorkReadonly
	 * @throws NoSuchUserException
	 * @throws NoSuchArtistException
	 * @throws ArtistHasNoWorksException
	 */

	Iterator<Entry<WorkReadonly, WorkReadonly>> getArtistWorks(String artistLogin) throws NoSuchUserException, NoSuchArtistException, ArtistHasNoWorksException;
/**
 * Returns a sorted iterator of works by their value and by their name
 * @return
 * @throws NoSoldWorksException
 */
	Iterator<Entry<WorkReadonly, WorkReadonly>> listWorksByValue() throws NoSoldWorksException;

	void sellAuctionWork(WorkReadonly currWork, String auctionId);
}
