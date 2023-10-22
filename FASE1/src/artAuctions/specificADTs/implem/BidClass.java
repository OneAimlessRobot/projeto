package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.Collector;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;

public class BidClass implements Serializable, Bid {

	private static final long serialVersionUID = 1L;
	
	private Collector collector;
	private Work work;
	private int bidAmmount;
	public BidClass(Collector collector,Work work,int bidAmmount) {
		
		this.collector=collector;
		this.work=work;
		this.bidAmmount= bidAmmount;
		
	}
	@Override
	public Collector getCollector() {
		
		return collector;
	}

	@Override
	public Work getWork() {
		
		return work;
	}

}
