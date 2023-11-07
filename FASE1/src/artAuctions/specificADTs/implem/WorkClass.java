package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.lang.Math;
import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
//import dataStructures.DoubleList;
import dataStructures.Vector;
import dataStructures.Iterator;
import dataStructures.FilteredIterator;
import dataStructures.List;

public class WorkClass implements Serializable, Work {

	private static final long serialVersionUID = 1L;
	private int year,minBidAmmount,maxSoldPrice;
	private ArtistGeneric author;
	private UserGeneric buyer;
	private List<AuctionGeneric> auctionsWhoWantThis;
	private String name,id;
	
	private List<BidGeneric> workBids;
	private BidGeneric currMaxBid;
	
	public WorkClass(String id,ArtistGeneric author,int year,String name) {
		
		this.setId(id);
		this.setAuthor(author);
		this.setYear(year);
		this.setName(name);
//		workBids=new DoubleList<>();
		workBids=new Vector<>();
		auctionsWhoWantThis= new Vector<>();
		buyer=null;
		maxSoldPrice=0;
		minBidAmmount=0;
		currMaxBid=new BidClass(null,(WorkGeneric)this,0,null);
		
		
	}
	@Override
	public int getYear() {
		return year;
	}
	@Override
	public void setYear(int year) {
		this.year = year;
	}
	public void setMinAmmount(int value) {
		minBidAmmount=value;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public ArtistGeneric getAuthor() {
		return author;
	}
	@Override
	public void setAuthor(ArtistGeneric author) {
		this.author = author;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return ""+getId()+" "+getName()+ " "+getYear()+" "+currMaxBid.getBidAmmount()+" "+getAuthor().getLogin()+ " "+getAuthor().getName();
		
	}
	public boolean equals(Object work) {
		boolean result=false;

		if(!(work instanceof Work)) {

			return false;
			
		}
		if(id==null) {
			if(((Work)work).getId()==null) {

				result=true;
			}
		}
		else if(((Work)work).getId()==null) {
			
			result=false;
			
		}
		else {
		result= ((Work)work).getId().equals(this.getId());
		}
		return result;
		
		
	}
	@Override
	public Iterator<BidGeneric> bids() {
		return workBids.iterator();
	}
	@Override
	public void addBid(Bid addedBid) {
		workBids.addLast(addedBid);
		
		
	}
	@Override
	public int getNumOfBids() {
		return workBids.size();
	}
	
	@Override
	public int getNumOfBidsFromAuction(String auctionId) {
		AuctionGeneric auction= new AuctionClass(auctionId);
		Bid bid= new BidClass(null,null,0,auction);
		FilteredIterator<BidGeneric> fit=workBids.filteredIterator(bid);
		int count=0;
		while(fit.hasNext()) {
			fit.next();
			count++;
		}
		return count;
	}
	@Override
	public FilteredIterator<BidGeneric> bidsFilteredByAuctionId(String auctionId) {
		AuctionGeneric auction= new AuctionClass(auctionId);
		Bid bid= new BidClass(null,null,0,auction);
		return workBids.filteredIterator(bid);
	}
	
	

	@Override
	public void removeBidsByUser(User user) {
		Iterator<BidGeneric> bids= workBids.iterator();
		while(bids.hasNext()) {
			BidGeneric currBid= bids.next();
			if(user.equals(currBid.getCollector())) {

				workBids.remove(currBid);
				bids.rewind();
			}
		}
		
	}
	@Override
	public int getMinBidAmmount() {
		return minBidAmmount;
	}
	@Override
	public UserGeneric getBuyer() {
		return buyer;
	}
	@Override
	public Iterator<AuctionGeneric> auctionsWhoWantThis() {
		return auctionsWhoWantThis.iterator();
	}
	@Override
	public BidGeneric getMaxBid() {
		return currMaxBid;
	}
	@Override
	public void setMaxBid(BidGeneric bid) {
		currMaxBid=bid;
		maxSoldPrice=bid.getBidAmmount();
	}
}
