package dataStructures;

import java.io.Serializable;

public abstract class GenericFilterPredicate< P> implements FilterPredicate< P>, Serializable {

	@Override
	public abstract Boolean execute(P param) ;

}
