package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/




import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;

public class BidClass implements Serializable, Bid {

	private static final long serialVersionUID = 1L;
	
	private User collector;
	private Work work;
	private int bidAmmount;
	public BidClass(User collector,Work work,int bidAmmount) {
		
		this.collector=collector;
		this.work=work;
		this.setBidAmmount(bidAmmount);
		
	}
	@Override
	public User getCollector() {
		
		return collector;
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

}
