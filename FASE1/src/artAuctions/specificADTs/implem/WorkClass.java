package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.*;
import artAuctions.specificADTs.interfaces.Work;
import dataStructures.DoubleList;
import dataStructures.List;
import artAuctions.specificADTs.implem.*;

public class WorkClass implements Serializable, Work {

	private int id,year,minBidAmmount;
	private Artist author;
	private String name;
	private List<Bid> workBids;
	
	public WorkClass(int id,Artist author,int year,String name) {
		
		this.setId(id);
		this.setAuthor(author);
		this.setYear(year);
		this.setName(name);
		workBids=new DoubleList<>();
		
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
	public void setMinBidAmmount(int value) {
		minBidAmmount = value;
	}
	@Override
	public int getMinBidAmmount() {
		return minBidAmmount;
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
		
		return "";
		
	}
	
}
