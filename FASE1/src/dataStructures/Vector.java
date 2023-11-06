package dataStructures;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/

import java.io.Serializable;


public class Vector<T> implements List<T>,Serializable {

	private static final long serialVersionUID = 1L;
private static class VectorIterator<T> implements TwoWayIterator<T>{
		
		private static final long serialVersionUID = 1L;
		private Vector<T> support;
		private int currPos;
		public VectorIterator(Vector<T> support) {
			this.support=support;
			rewind();
			
		}
		@Override
		public T next() {
	        if ( !this.hasNext() )
	            throw new NoSuchElementException();

			return support.get(currPos++);
		}
		@Override
		public boolean hasNext() {
			return this.currPos!=support.size();
		}
		@Override
		public T previous() {
	        if ( !this.hasPrevious() )
	            throw new NoSuchElementException();
			return support.get(currPos--);
		}
		@Override
		public void fullForward() {
			currPos=support.size()-1;
		}
		@Override
		public boolean hasPrevious() {
			return currPos!=-1;
		}
		@Override
		public void rewind() {
			this.currPos=0;
			
		}
		
}

private static class VectorFilteredIterator<T> implements FilteredIterator<T>{
		
		private static final long serialVersionUID = 1L;
		private Vector<T> support;
		private int currPos;
		private T filter;
		public VectorFilteredIterator(Vector<T> support,T filter) {
			this.support=support;
			this.filter=filter;
			rewind();
			
		}
		@Override
		public T next() {
	        if ( !this.hasNext() )
	            throw new NoSuchElementException();

	        T result= support.get(currPos);
	        advance();
			nextEquals(filter);
			return result;
		}
		
		private void advance() {
	        if ( !this.hasNext() )
	            throw new NoSuchElementException();

	        currPos++;
			
		}
		@Override
		public boolean hasNext() {
			return this.currPos!=support.size();
		}
		@Override
		public void rewind() {
			this.currPos=0;
			nextEquals(filter);
		}
		@Override
		public void nextEquals(T elem) {

			while(hasNext()){
		
				if(support.get(currPos).equals(elem)) {
					return;
				}
				advance();
			}
			
}
}
private static class VectorFilteredIteratorWithPredicate<T> implements FilteredIteratorWithPredicate<T> {
	
	private static final long serialVersionUID = 1L;
	private Vector<T> support;
	private int currPos;
	private FilterPredicate<T> filterP;
	public VectorFilteredIteratorWithPredicate(Vector<T> support,FilterPredicate<T> predicate) {
		this.support=support;
		filterP=predicate;
		rewind();
		
	}
	@Override
	public T next() {
        if ( !this.hasNext() )
            throw new NoSuchElementException();

        T result= support.get(currPos);
        advance();
		nextEquals();
		return result;
	}
	
	private void advance() {
        if ( !this.hasNext() )
            throw new NoSuchElementException();

        currPos++;
		
	}
	@Override
	public boolean hasNext() {
		return this.currPos!=support.size();
	}
	@Override
	public void rewind() {
		this.currPos=0;
		nextEquals();
	}
	@Override
	public void nextEquals() {

		while(hasNext()){
	
			if(filterP.execute(support.get(currPos))) {
				return;
			}
			advance();
		}
		
}
}
	private T[] arr;
	private static final int INIT_SIZE=20000;
	private int currPos,size;
	//Constroi uma stack vazia
	public Vector() {
		
		arr= (T[])new Object[INIT_SIZE];
		currPos=-1;
		size=INIT_SIZE;
		
	}
	//Constroi uma stack com elementos de um Array ordenados pela ordem em
	//que estao nele (ultimo elemento em cima, primeiro em baixo)
	private void grow() {
		
		T[] aux= (T[]) new Object[size*2];
		
		for(int i=0;i<size;i++) {
			
			aux[i]=arr[i];
		}
		for(int i=0;i<size;i++) {
			arr[i]=null;
		}
		size*=2;
		arr=aux;		
	}
	private boolean isFull() {
		
		return currPos==size-1;
		
	}
	public boolean isEmpty() {
		
		return this.currPos==-1;
	}
	@Override
	public int size() {
		return currPos+1;
	}
	@Override
	public Iterator<T> iterator()  {
		return (Iterator<T>) new VectorIterator<>(this);
	}
	@Override
	public T get(int index) {
		if(index<0||index>currPos) {
			
			throw new IndexOutOfBoundsException();
		}
			
		return arr[index];
	}
	public String toString() {
    	
    	String result="[";
    	Iterator<T> it=iterator();
    	while(it.hasNext()) {
    		T elem= it.next();
    		if(elem==null) {
    			
    			result= result+"null";
    		}
    		else {
    			
    			result+=" "+elem.toString()+" ";
    			
    		}
    		
    		
    	}
    	result=result+"]";
    	
    	return result;
    	
    	
    	
    }
	@Override
	public void add(int index,T elem) {
		if(index<0||index>currPos+1) {
			throw new InvalidPositionException();
		}
		if(isFull()) {
			grow();
		}
		currPos++;
		int i=this.currPos;
		for(;i>=index;i--) {
			
			arr[i+1]=arr[i];
			
			
		}
		arr[index]=elem;
	}

	@Override
	public T remove(int index) {
		if(index<0||index>currPos) {
			throw new InvalidPositionException();
		}
		if(isEmpty()) {
		
			throw new EmptyListException();
		
		}
		T result=arr[index];
		for(int i=index;i<currPos;i++) {
			arr[i]=arr[i+1];
			
		}
		currPos--;
		return result;
		
	}
	@Override
	public int find(T elem) {
		if(isEmpty()) {	
			
			return -1;
		}
		int i=-1;
		for(;i<currPos;) {
			i++;
		if(elem.equals(get(i))) {
			return i;
		}
		}
		return -1;
	}
	@Override
	public T getLast() throws EmptyListException {
		return get(currPos+1);
	}
	@Override
	public T getFirst() throws EmptyListException {
		return get(0);
	}
	@Override
	public void addFirst(T element) {
		add(0,element);
		
	}
	@Override
	public void addLast(T element) {
		add(currPos+1,element);
		
	}
	@Override
	public T removeFirst() throws EmptyListException {
		return remove(0);
	}
	@Override
	public T removeLast() throws EmptyListException {
		return remove(currPos);
	}
	@Override
	public boolean remove(T element) {
		boolean result;
		int pos;
		if((pos=find(element))>=0) {
			remove(pos);
			result=true;
		}
		else {
			result=false;
			
		}
		return result;
	}
	@Override
	public void append(List<T> list) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public FilteredIterator<T> filteredIterator(T elem) {
		return new VectorFilteredIterator<T>(this,elem);
	}
	@Override
	public FilteredIteratorWithPredicate<T> filteredIteratorWithPredicate( FilterPredicate<T> filter) {
		return new VectorFilteredIteratorWithPredicate<>(this,filter);
	}
}
