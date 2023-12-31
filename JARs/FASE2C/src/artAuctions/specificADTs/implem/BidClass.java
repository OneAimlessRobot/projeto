package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/




import java.io.Serializable;

import artAuctions.specificADTs.interfaces.AuctionGeneric;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.UserGeneric;
import artAuctions.specificADTs.interfaces.WorkGeneric;

/**
* Implements interface Bid. Describes a Bid.
*/
public class BidClass implements Serializable, Bid {

	private static final long serialVersionUID = 1L;
	
	private UserGeneric collector;
	private WorkGeneric work;
	private int bidAmmount;
	private AuctionGeneric auction;
	public BidClass(UserGeneric collector,WorkGeneric work,int bidAmmount,AuctionGeneric auction) {
		
		this.collector=collector;
		this.work=work;
		this.bidAmmount=bidAmmount;
		this.auction=auction;
	}
	@Override
	public UserGeneric getCollector() {
		
		return collector;
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
	@Override
	public AuctionGeneric getAuction() {
		return auction;
	}

}
