/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;




import java.io.Serializable;

/**
* Implements interface Bid. Describes a Bid.
*/
class BidClass implements Serializable, Bid {

	private static final long serialVersionUID = 1L;
	
	private UserReadonly collector;
	private int bidAmmount;
	public BidClass(UserReadonly collector,int bidAmmount) {
		
		this.collector=collector;
		this.bidAmmount=bidAmmount;
	}
	@Override
	public UserReadonly getCollector() {
		
		return collector;
	}
	
	@Override
	public int getBidAmmount() {
		return bidAmmount;
	}

}
