package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import dataStructures.DoubleList;
import dataStructures.List;
import artAuctions.specificADTs.implem.*;

public class WorkClass implements Serializable, Work {

	private static final int minBidAmmount=50;
	private int id,year,lastSoldPrice;
	private Artist author;
	private String name;
	
	private List<Bid> workBids;
	
	public WorkClass(int id,Artist author,int year,String name) {
		
		this.setId(id);
		this.setAuthor(author);
		this.setYear(year);
		this.setName(name);
		workBids=new DoubleList<>();
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
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
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
		//idObra nome ano valorVendaMaisAlto loginAutor nomeAutor
		return ""+getId()+" "+getName()+ " "+getYear()+" "+getBidAmmount()+" "+getAuthor().getLogin()+ " "+getAuthor().getName();
		
	}
	public boolean equals(Object work) {
		boolean result=false;

		if(!(work instanceof Work)) {

			return false;
			
		}
		else {
		result= ((Work)work).getId()==this.getId();
		}
		return result;
		
		
		
	}
	
}
