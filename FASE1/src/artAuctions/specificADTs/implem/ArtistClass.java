package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Work;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.Vector;
public class ArtistClass extends UserClass implements Serializable,Artist {

	private static final long serialVersionUID = 1L;
	private String artsyName;
	private List<Work> works;
	public ArtistClass(String login,String name,String artsyName,int age,String email) {
		
		super(login,name,age,email);
		this.artsyName=artsyName;
		works=new Vector<>();
	}
	@Override
	public String getArtsyName() {
		
		
		return artsyName;
	}

	public String toString() {
		
		return getLogin()+" "+ getName()+ " "+ getArtsyName()+ " "+ getAge()+" "+getEmail();
		
		
		
		
}
	@Override
	public int getNumOfWorks() {
		
		return works.size();
	}
	@Override
	public void addWork(Work work) {
		works.addFirst(work);
		
	}
	@Override
	public Iterator<Work> works() {
		return works.iterator();
	}
}
