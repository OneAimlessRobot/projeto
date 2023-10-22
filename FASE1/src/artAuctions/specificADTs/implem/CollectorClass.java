package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.Collector;
import dataStructures.DoubleList;
import dataStructures.List;

public class CollectorClass extends UserClass implements Serializable, Collector {

	private List<Bid> collectorBids;
	public CollectorClass(String login,String name,int age,String email) {
		
		super(login,email,age, email);
		collectorBids=new DoubleList<>();
		
		
		
	}
}
