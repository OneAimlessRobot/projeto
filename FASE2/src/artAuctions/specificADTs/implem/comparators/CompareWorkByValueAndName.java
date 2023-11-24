package artAuctions.specificADTs.implem.comparators;

import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructures.Comparator;

public class CompareWorkByValueAndName implements Comparator<WorkGeneric> {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(WorkGeneric first, WorkGeneric second) {
		if(first.getMaxBid().getBidAmmount()!=second.getMaxBid().getBidAmmount()) {
			return second.getMaxBid().getBidAmmount()-first.getMaxBid().getBidAmmount();
		}
		else if(!first.getName().equals(second.getName())) {
			
			return first.getName().compareTo(second.getName());
			
		}
		else {
			
			return 0;
		}
		
	}

}
