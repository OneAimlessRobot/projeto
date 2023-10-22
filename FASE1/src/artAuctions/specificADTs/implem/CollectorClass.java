package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.Collector;
import dataStructures.DoubleList;
import dataStructures.List;

public class CollectorClass extends UserClass implements Serializable, Collector {

	private static final long serialVersionUID = 1L;
	private List<Bid> collectorBids;
	public CollectorClass(String login,String name,int age,String email) {
		
		super(login,name,age, email);
		collectorBids=new DoubleList<>();
		
		
		
	}

	public String toString() {
		
			return getLogin()+" "+ getName()+ " "+ getAge()+" "+getEmail()+"\nBids:"+collectorBids.toString();
			
			
		
	}
	@Override
	public int numOfBids() {
		
		
		return collectorBids.size();
	}
	@Override
	public void addBid(Bid addedBid) {
		
		collectorBids.addFirst(addedBid);
		
	}
}
