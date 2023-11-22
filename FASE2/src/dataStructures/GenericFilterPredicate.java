package dataStructures;

import java.io.Serializable;

public abstract class GenericFilterPredicate< P> implements FilterPredicate< P>, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public abstract Boolean execute(P param) ;

}
