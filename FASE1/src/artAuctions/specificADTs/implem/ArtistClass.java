package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Work;
import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.List;

public class ArtistClass extends UserClass implements Serializable, Artist {

	private static final long serialVersionUID = 1L;

	private String artsyName;
	private List<WorkGeneric> works;
	
	public ArtistClass(String login, String name, int age, String email) {
		super(login, name, age, email);
		works=new DoubleList <>();
	}
	@Override
	public String printArtist() {
		
		return getLogin()+" "+ getName()+ " "+ getArtsyName()+ " "+ getAge()+" "+getEmail();
		
		
		
		
}
	@Override
	public void setArtsyName(String newName) {
		
		
		artsyName=newName;
	}

	@Override
	public int getNumOfWorks() {
		
		return works.size();
	}
	@Override
	public void addWork(Work work) {
		works.addLast(work);
		
	}
	@Override
	public Iterator<WorkGeneric> works() {
		return works.iterator();
	}
	@Override
	public String getArtsyName() {
		return artsyName;
	}

	@Override
	public boolean hasWork(Work work) {

		return works.find(work)>=0;
		
	}
	@Override
	public void removeWork(Work work) {
		
		if(hasWork(work)) {
			
			works.remove(work);
		}
		
	}
	@Override
	public void clearWorks() {
		
		while(!works.isEmpty()) {
			
			works.removeLast();
		}
	}
	

}
