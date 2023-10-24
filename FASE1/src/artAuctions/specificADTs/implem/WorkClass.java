package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.Vector;

public class WorkClass implements Serializable, Work {

	private static final long serialVersionUID = 1L;
	private static final int minBidAmmount=100;
	private int year,lastSoldPrice;
	private Artist author;
	private String name,id;
	
	private List<Bid> workBids;
	
	public WorkClass(String id,Artist author,int year,String name) {
		
		this.setId(id);
		this.setAuthor(author);
		this.setYear(year);
		this.setName(name);
		workBids=new DoubleList<>();
//		workBids=new Vector<>();
		lastSoldPrice=0;
		
		
	}
	@Override
	public int getYear() {
		return year;
	}
	@Override
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public void setSoldAmmount(int value) {
		if(value>lastSoldPrice&&value>minBidAmmount) {
		lastSoldPrice = value;
		}
	}
	@Override
	public int getBidAmmount() {
		return lastSoldPrice;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public Artist getAuthor() {
		return author;
	}
	@Override
	public void setAuthor(Artist author) {
		this.author = author;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return ""+getId()+" "+getName()+ " "+getYear()+" "+getBidAmmount()+" "+getAuthor().getLogin()+ " "+getAuthor().getName();
		
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
	@Override
	public Iterator<Bid> bids() {
		return workBids.iterator();
	}
	@Override
	public void addBid(Bid addedBid) {
		if(addedBid.getBidAmmount()<minBidAmmount) {
			
			return;
		}
		workBids.addLast(addedBid);
		
	}
	public int getNumOfBids() {
		return workBids.size();
	}

	@Override
	public void removeBidsByUser(User user) {
		Iterator<Bid> bids= workBids.iterator();
		while(bids.hasNext()) {
			Bid currBid= bids.next();
			if(user.equals(currBid.getCollector())) {

				workBids.remove(currBid);
				bids.rewind();
			}
		}
		
	}
}
