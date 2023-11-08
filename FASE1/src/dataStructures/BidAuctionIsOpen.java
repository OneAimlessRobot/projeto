package dataStructures;

import artAuctions.specificADTs.interfaces.Bid;

public class BidAuctionIsOpen implements FilterPredicate<Bid> {

	private static final long serialVersionUID = 1L;

	public BidAuctionIsOpen() {
		
		
	}
	@Override
	public Boolean execute(Bid param) {
		return !param.getAuction().isClosed();
	}

}
