package artAuctions.specificADTs.implem.comparators;
import artAuctions.specificADTs.interfaces.WorkGeneric;
import dataStructure.*;
public class CompareWorkByName implements Comparator<WorkGeneric> {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(WorkGeneric first, WorkGeneric second) {
		return first.getName().compareTo(second.getName());
	}

}
