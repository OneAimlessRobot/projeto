package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.BidGeneric;
import artAuctions.specificADTs.interfaces.User;
import artAuctions.specificADTs.interfaces.Work;
import dataStructures.BidAuctionIsOpen;
import dataStructures.DoubleList;
import dataStructures.FilteredIteratorWithPredicate;
import dataStructures.Iterator;
import dataStructures.List;

public class UserClass implements User, Serializable {

	private static final long serialVersionUID = 1L;
	protected String login,email,name;
	protected int age;
	protected List<BidGeneric> collectorBids;
	public UserClass(String login,String name,int age,String email) {
		this.login=login;
		this.email=email;
		this.age=age;
		this.name=name;
		collectorBids=new DoubleList<>();
		
	}

	public String toString() {
		
		if((this instanceof ArtistClass)) {

			return ((Artist)this).printArtist();
			/*
			Artist c=new UserClass("","",0,"");
			User d=new UserClass("","",0,"");
			c=d__;*/
			
		}
		return printUser();

		
	}
	@Override
	public String printUser() {
		
		return getLogin()+" "+ getName()+ " "+ getAge()+" "+getEmail();
		
		
}
	@Override
	public String getName() {
		
		return name;
		
	}
	@Override

	public String getLogin() {
		
		return login;
		
	}
	@Override
	public String getEmail() {
		
		return email;
		
	}
	@Override
	public int getAge() {
		
		
		return age;
	}
	public boolean equals(Object user) {
		boolean result=false;

		if(!(user instanceof User)) {

			return false;
			
		}
		if(login==null) {
			if(((User)user).getLogin()==null) {

				result=true;
			}
		}
		else if(((User)user).getLogin()==null) {
			
			result=false;
			
		}
		else {
		result= ((User)user).getLogin().equals(this.getLogin());
		}
		return result;
		
		
	}@Override
	public void removeBidsByWork(Work work) {
		Iterator<BidGeneric> bids= collectorBids.iterator();
		while(bids.hasNext()) {
			BidGeneric currBid= bids.next();
			if(work.equals(currBid.getWork())) {
				
				collectorBids.remove(currBid);
				bids.rewind();
			}
		}
		
	}
	@Override
	public int numOfBids() {
		
		
		return collectorBids.size();
	}
	@Override
	public void addBid(Bid addedBid) {
		
		collectorBids.addLast(addedBid);
		
	}

	@Override
	public FilteredIteratorWithPredicate<BidGeneric> bidsInOpenAuctions() {
		BidAuctionIsOpen bidpred= new BidAuctionIsOpen();
		return collectorBids.filteredIteratorWithPredicate(bidpred);
	}


}
