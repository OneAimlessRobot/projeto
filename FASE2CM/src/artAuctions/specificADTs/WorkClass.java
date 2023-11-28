/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;

import java.io.Serializable;


/**
* Implements interface Work. Describes a Work (Obra de Arte).
*/
class WorkClass implements Serializable, Work {

	private static final long serialVersionUID = 1L;
	private int year;
	private ArtistReadonly author;
	private UserReadonly buyer;
	private String name,id;
	
	
	public Bid currMaxBid;
	
	public WorkClass(String id,ArtistReadonly author,int year,String name) {
		
		this.id=id;
		this.author=author;
		this.year=year;
		this.name=name;
		buyer=null;
		currMaxBid= new BidClass(null,null,0,null);
		
		
	}
	@Override
	public int getYear() {
		return year;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public ArtistReadonly getAuthor() {
		return author;
	}
	@Override
	public String getName() {
		return name;
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
	public UserReadonly getBuyer() {
		return buyer;
	}
	@Override
	public Bid getMaxBid() {
		return currMaxBid;
	}
	@Override
	public void setMaxBid(Bid bid) {
		currMaxBid=bid;
	}
	@Override
	public int compareTo(WorkReadonly arg0) {
		return getId().compareTo(arg0.getId());
	}
}
