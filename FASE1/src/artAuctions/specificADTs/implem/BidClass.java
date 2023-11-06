package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/




import java.io.Serializable;

import artAuctions.specificADTs.interfaces.AuctionGeneric;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.UserGeneric;
import artAuctions.specificADTs.interfaces.Work;
import artAuctions.specificADTs.interfaces.WorkGeneric;

public class BidClass implements Serializable, Bid {

	private static final long serialVersionUID = 1L;
	
	private UserGeneric collector;
	private WorkGeneric work;
	private AuctionGeneric auction;
	private int bidAmmount;
	public BidClass(UserGeneric collector,WorkGeneric work,int bidAmmount,AuctionGeneric auction) {
		
		this.collector=collector;
		this.work=work;
		this.setBidAmmount(bidAmmount);
		this.auction=auction;
		
	}
	@Override
	public UserGeneric getCollector() {
		
		return collector;
	}
	@Override
	public boolean equals(Object anotherBid) {
		boolean result=false;
		if(anotherBid instanceof BidClass) {
			
			result= ((Bid)anotherBid).getAuction().equals(auction);
				
			
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
	public WorkGeneric getWork() {
		
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
	public AuctionGeneric getAuction() {
		return auction;
	}

}
