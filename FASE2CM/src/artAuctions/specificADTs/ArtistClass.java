/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;

import java.io.Serializable;

import dataStructures.AVLBSTComparable;
import dataStructures.Entry;
import dataStructures.Iterator;
import dataStructures.OrderedDictionaryCleanable;

/**
* Implements interface Artist. An Artist is a specific type of User. It can author Works.
*/
class ArtistClass extends UserClass implements Serializable, Artist {

	private static final long serialVersionUID = 1L;

	private String artsyName;			//Nome artístico
	private OrderedDictionaryCleanable<WorkReadonly,WorkReadonly> works;	//Lista de obras de arte autoradas pelo Artist
	private int numOfWorksInAuction;
	public ArtistClass(String login, String name, int age, String email) {
		super(login, name, age, email);
		works=new AVLBSTComparable<>(new CompareWorkByName());
		numOfWorksInAuction=0;
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
	public int getNumOfWorksInAuction() {
		
		return numOfWorksInAuction;
	}
	@Override
	public void addWork(Work work) {
		works.insert(work,work);
		
	}
	@Override
	public Iterator<Entry<WorkReadonly,WorkReadonly>> works() {
		return works.iterator();
	}
	@Override
	public String getArtsyName() {
		return artsyName;
	}
	@Override
	public void clearWorks() {
		
		works.clean();
	}
	@Override
	public void addWorkInAuction() {
		numOfWorksInAuction++;
	}
	@Override
	public void removeWorkInAuction() {
		numOfWorksInAuction--;
	}
	

}
