package dataStructures;

public interface FilteredIterator<E> extends Iterator<E> {

	void nextEquals(E elem);
	

}
