package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/




import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;

public class BidClass implements Serializable,Comparable<Bid>, Bid {

	private static final long serialVersionUID = 1L;
	
	private User collector;
	private Work work;
	private String auctionId;
	private int bidAmmount;
	public BidClass(User collector,Work work,int bidAmmount,String auctionId) {
		
		this.collector=collector;
		this.work=work;
		this.setBidAmmount(bidAmmount);
		this.auctionId=auctionId;
		
	}
	@Override
	public User getCollector() {
		
		return collector;
	}
	@Override
	public int compareTo(Bid anotherBid) {
		int result=-1;
		if(anotherBid instanceof BidClass) {
			
			result= anotherBid.getAuctionId().compareTo(auctionId);
				
			
		}
		return result;
		
		
		
	}
	
	
	@Override
	public void setCollector(User user) {
		
		collector=user;
	}
	@Override
	public void setWork(Work work) {
		
		this.work=work;
	}

	@Override
	public Work getWork() {
		
		return work;
	}
	public String toString() {
		return collector.getLogin()+ " "+ collector.getName()+ " "+ bidAmmount;
		
	}
	@Override
	public int getBidAmmount() {
		return bidAmmount;
	}
	public void setBidAmmount(int bidAmmount) {
		this.bidAmmount = bidAmmount;
	}
	@Override
	public String getAuctionId() {
		return auctionId;
	}

}
