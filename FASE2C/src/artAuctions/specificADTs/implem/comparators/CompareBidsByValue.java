package artAuctions.specificADTs.implem.comparators;

import artAuctions.specificADTs.interfaces.Bid;
import dataStructures.Comparator;

public class CompareBidsByValue implements Comparator<Bid> {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Bid first, Bid second) {
		return first.getBidAmmount()-second.getBidAmmount();
	}

}
