package artAuctions.specificADTs.implem;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;

import artAuctions.specificADTs.implem.comparators.CompareWorkByName;
import artAuctions.specificADTs.interfaces.Artist;
import artAuctions.specificADTs.interfaces.Work;
import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructure.AVLBSTComparable;
import dataStructure.IteratorEntries;
import dataStructure.OrderedDictionary;

/**
* Implements interface Artist. An Artist is a specific type of User. It can author Works.
*/
public class ArtistClass extends UserClass implements Serializable, Artist {

	private static final long serialVersionUID = 1L;

	private String artsyName;			//Nome artístico
	private OrderedDictionary<WorkGeneric,WorkGeneric> works;	//Lista de obras de arte autoradas pelo Artist
	
	public ArtistClass(String login, String name, int age, String email) {
		super(login, name, age, email);
		works=new AVLBSTComparable<>(new CompareWorkByName());
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
		works.insert(work,work);
		
	}
	@Override
	public IteratorEntries<WorkGeneric,WorkGeneric> works() {
		return works.iterator();
	}
	@Override
	public String getArtsyName() {
		return artsyName;
	}
	@Override
	public void clearWorks() {
		
		while(!works.isEmpty()) {
			
			works.remove(works.maxEntry().getKey());
		}
	}
	

}
