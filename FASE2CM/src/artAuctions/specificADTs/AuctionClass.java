/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;
import java.io.Serializable;
 
import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.List;

/**
* Implements interface Auction. Describes an Auction.
*/ 
class AuctionClass implements Serializable, Auction {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Key for an auction in collections that store them
	 */
	private String id;
	/**
	 * Collection of connections between works and the bids made in them in this auction
	 */
	private List<WorkInAuctionReadonly> works;
	
	public AuctionClass(String id) {
		
		this.id=id;
		works= new DoubleList<>();
	}

	@Override
	public WorkInAuctionReadonly getWorkInAuction(WorkReadonly work) {
		
		Iterator<WorkInAuctionReadonly> auctionWorkIt= listWorks();
		WorkInAuctionReadonly curr= null;
		while(auctionWorkIt.hasNext()) {
			curr=auctionWorkIt.next();
			
			if(work.equals(curr.getWork())) {
				
				return curr;
			}
		}
		return null;
	}

	@Override
	public Iterator<WorkInAuctionReadonly> listWorks() {
		
		return works.iterator();
	}

	public boolean equals(Object auction) {
		boolean result=false;

		if(!(auction instanceof Auction)) {

			return false;
			
		}
		if(id==null) {
			if(((Auction)auction).getId()==null) {

				result=true;
			}
		}
		else if(((Auction)auction).getId()==null) {
			
			result=false;
			
		}
		else {
		result= ((Auction)auction).getId().equals(this.getId());
		}
		return result;
		
	}
	@Override
	public void addWork(Work addedWork,int minAmmount) {
		works.addLast(new WorkInAuctionClass(addedWork,minAmmount));
	}
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public int getNumOfWorks() {
		return works.size();
	}
	


	@Override
	public void close() {
		Iterator<WorkInAuctionReadonly> it= works.iterator();
		while(it.hasNext()) {
			WorkInAuction next= (WorkInAuction) it.next();
			Iterator<Bid> it2= next.bids();
			while(it2.hasNext()) {
				Bid next2=it2.next();
				((User)next2.getCollector()).removeBid();
			}
		}
	}

}
