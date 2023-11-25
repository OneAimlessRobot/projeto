/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs.implem.comparators;
import artAuctions.specificADTs.interfaces.WorkReadonly;
import dataStructures.interfaces.Comparator;
public class CompareWorkByName implements Comparator<WorkReadonly> {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(WorkReadonly first, WorkReadonly second) {
		return first.getName().compareTo(second.getName());
	}

}
