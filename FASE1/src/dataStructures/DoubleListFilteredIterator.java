package dataStructures;



import dataStructures.DoubleList.DoubleListNode;

/**
 * Implementation of Two Way Iterator for DLList 
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 * 
 */
class DoubleListFilteredIterator<E> implements FilteredIterator<E>
{

	/**
	 * Serial Version UID of the Class
	 */
    static final long serialVersionUID = 0L;


    /** 
     * Node with the first element in the iteration.
     */
    protected DoubleListNode<E> firstNode;

    /**
     * Node with the last element in the iteration.
     */
    protected DoubleListNode<E> lastNode;

    /**
     * Node with the next element in the iteration.
     */
    protected DoubleListNode<E> nextToReturn;

    /**
     * Node with the previous element in the iteration.
     */
    protected DoubleListNode<E> prevToReturn;


    /**
     * DoublyLLIterator constructor
     * @param first - Node with the first element of the iteration
     * @param last - Node with the last element of the iteration
     */
    
    private E filter;
    public DoubleListFilteredIterator( DoubleListNode<E> first, DoubleListNode<E> last, E filter )
    {
        firstNode = first;
        lastNode = last;
        this.filter=filter;
        this.rewind();
    }      


    @Override
    public void rewind( )
    {
        nextToReturn = firstNode;
        prevToReturn = null;
        nextEquals(filter);
    }




    @Override
    public boolean hasNext( )
    {
        return nextToReturn != null;
    }




    private void advance( ) throws NoSuchElementException
    {
        if ( !this.hasNext() )
            throw new NoSuchElementException();

        E element = nextToReturn.getElement();
        prevToReturn = nextToReturn.getPrevious();
        nextToReturn = nextToReturn.getNext();
    }
    @Override
    public E next( ) throws NoSuchElementException
    {
        if ( !this.hasNext() )
            throw new NoSuchElementException();

        E element = nextToReturn.getElement();
        advance();
        nextEquals(filter);
        return element;
    }

	@Override
	public void nextEquals(E elem) {

		while(hasNext()){
			
			if(nextToReturn.getElement().equals(elem)) {
				return;
			}
			advance();
			
		}
		
}
}
