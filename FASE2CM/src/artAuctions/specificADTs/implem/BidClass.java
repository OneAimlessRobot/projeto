/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.implem;




import java.io.Serializable;

import artAuctions.specificADTs.interfaces.AuctionReadonly;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.UserReadonly;
import artAuctions.specificADTs.interfaces.WorkReadonly;

/**
* Implements interface Bid. Describes a Bid.
*/
public class BidClass implements Serializable, Bid {

	private static final long serialVersionUID = 1L;
	
	private UserReadonly collector;
	private WorkReadonly work;
	private int bidAmmount;
	private AuctionReadonly auction;
	public BidClass(UserReadonly collector,WorkReadonly work,int bidAmmount,AuctionReadonly auction) {
		
		this.collector=collector;
		this.work=work;
		this.bidAmmount=bidAmmount;
		this.auction=auction;
	}
	@Override
	public UserReadonly getCollector() {
		
		return collector;
	}
	

	@Override
	public WorkReadonly getWork() {
		
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
	public AuctionReadonly getAuction() {
		return auction;
	}

}
