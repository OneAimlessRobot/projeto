package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import dataStructures.Iterator;
import dataStructures.DoubleList;
import dataStructures.FilteredIterator;
import dataStructures.List;

/**
* Implements interface Work. Describes a Work (Obra de Arte).
*/
public class WorkClass implements Serializable, Work {

	private static final long serialVersionUID = 1L;
	private int year,minBidAmmount;
	private ArtistGeneric author;
	private UserGeneric buyer;
	private String name,id;
	
	private List<Bid> workBids;
	private Bid currMaxBid;
	
	public WorkClass(String id,ArtistGeneric author,int year,String name) {
		
		this.id=id;
		this.author=author;
		this.year=year;
		this.name=name;
		workBids=new DoubleList<>();
		buyer=null;
		minBidAmmount=0;
		currMaxBid=new BidClass(null,(WorkGeneric)this,0,null);
		
		
	}
	@Override
	public int getYear() {
		return year;
	}
	public void setMinAmmount(int value) {
		minBidAmmount=value;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public ArtistGeneric getAuthor() {
		return author;
	}
	@Override
	public String getName() {
		return name;
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
	public Iterator<Bid> bids() {
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
		FilteredIterator<Bid> fit=workBids.filteredIterator(bid);
		int count=0;
		while(fit.hasNext()) {
			fit.next();
			count++;
		}
		return count;
	}
	@Override
	public FilteredIterator<Bid> bidsFilteredByAuctionId(String auctionId) {
		AuctionGeneric auction= new AuctionClass(auctionId);
		Bid bid= new BidClass(null,null,0,auction);
		return workBids.filteredIterator(bid);
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
	public Bid getMaxBid() {
		return currMaxBid;
	}
	@Override
	public void setMaxBid(Bid bid) {
		currMaxBid=bid;
	}
}
