package dataStructures;

import artAuctions.specificADTs.interfaces.BidGeneric;

public class BidAuctionIsOpen implements FilterPredicate<BidGeneric> {

	private static final long serialVersionUID = 1L;

	public BidAuctionIsOpen() {
		
		
	}
	@Override
	public Boolean execute(BidGeneric param) {
		return !param.getAuction().isClosed();
	}

}
