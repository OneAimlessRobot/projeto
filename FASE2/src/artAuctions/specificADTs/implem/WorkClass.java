package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import dataStructures.IteratorEntries;
import dataStructures.List;
import dataStructures.Dictionary;
import dataStructures.DoubleList;
import dataStructures.Entry;
import dataStructures.Iterator;
import dataStructures.SepChainHashTable;

/**
* Implements interface Work. Describes a Work (Obra de Arte).
*/
public class WorkClass implements Serializable, Work {

	private static final long serialVersionUID = 1L;
	private int year,minBidAmmount;
	private ArtistGeneric author;
	private UserGeneric buyer;
	private String name,id;
	
//	private Dictionary<Bid,Bid> workBids;
	private List<Bid> workBids;
	private Bid currMaxBid;
	
	public WorkClass(String id,ArtistGeneric author,int year,String name) {
		
		this.id=id;
		this.author=author;
		this.year=year;
		this.name=name;
//		workBids=new SepChainHashTable<>();
		workBids= new DoubleList<>();
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
//	@Override
//	public IteratorEntries<Bid,Bid> bids() {
//		return workBids.iterator();
//	}
		@Override
	public Iterator<Bid> bids() {
	return workBids.iterator();
}
//	@Override
//	public void addBid(Bid addedBid) {
//		workBids.insert(addedBid,addedBid);
//		
//		
//	}
		@Override
		public void addBid(Bid addedBid) {
			workBids.addLast(addedBid);
			
			
		}
		@Override
	public int getNumOfBids() {
		return workBids.size();
	}
	
//		@Override
//		public int getNumOfBidsFromAuction(String auctionId) {
//			IteratorEntries<Bid,Bid> fit=workBids.iterator();
//			int count=0;
//			while(fit.hasNext()) {
//				Entry<Bid,Bid> curr=fit.next();
//				if(curr.getValue().getAuction().getId().equals(auctionId)) {
//				count++;
//				}
//			}
//			return count;
//		}
		@Override
		public int getNumOfBidsFromAuction(String auctionId) {
			Iterator<Bid> fit=workBids.iterator();
			int count=0;
			while(fit.hasNext()) {
				Bid curr=fit.next();
				if(curr.getAuction().getId().equals(auctionId)) {
				count++;
				}
			}
			return count;
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
	@Override
	public int compareTo(WorkGeneric arg0) {
		return getId().compareTo(arg0.getId());
	}
}
