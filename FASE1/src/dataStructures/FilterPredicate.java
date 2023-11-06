package dataStructures;

import java.io.Serializable;

public interface FilterPredicate<P> extends Serializable {
	
	Boolean execute(P param);

}
