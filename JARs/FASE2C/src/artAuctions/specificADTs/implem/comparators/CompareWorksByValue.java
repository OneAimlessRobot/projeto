package artAuctions.specificADTs.implem.comparators;

import java.io.Serializable;
import dataStructures.Comparator;
import artAuctions.specificADTs.interfaces.WorkGeneric;

public class CompareWorksByValue implements Comparator<WorkGeneric>, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(WorkGeneric arg0, WorkGeneric arg1) {
		return arg0.getMaxBid().getBidAmmount()-arg1.getMaxBid().getBidAmmount();
	}

}
