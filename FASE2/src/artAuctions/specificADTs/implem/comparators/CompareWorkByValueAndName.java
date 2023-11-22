package artAuctions.specificADTs.implem.comparators;

import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructures.Comparator;

public class CompareWorkByValueAndName implements Comparator<WorkGeneric> {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(WorkGeneric first, WorkGeneric second) {
		if(first.getMaxBid().getBidAmmount()!=second.getMaxBid().getBidAmmount()) {
			return first.getMaxBid().getBidAmmount()-second.getMaxBid().getBidAmmount();
		}
		else if(!first.getId().equals(second.getId())) {
			
			return first.getId().compareTo(second.getId());
			
		}
		else {
			
			return 0;
		}
		
	}

}
