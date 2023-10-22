package dataStructures;


public class Vector<T> implements List<T> {

	private static final long serialVersionUID = 1L;
	private static class VectorIterator<T> implements TwoWayIterator<T>{
		
		private static final long serialVersionUID = 1L;
		private Vector<T> support;
		private int currPos;
		public VectorIterator(Vector<T> support) {
			this.support=support;
			currPos=0;
			
		}
		@Override
		public T next() {
			return support.get(currPos++);
		}
		@Override
		public boolean hasNext() {
			return this.currPos!=support.size();
		}
		@Override
		public void rewind() {
			this.currPos=0;
		}
		@Override
		public T previous() {
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
		if(index >= this.size()|| index < 0) {
			
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
		int i=0;
		for(;i<currPos&&!get(i).equals(elem);i++);
		if(arr[i]==null) {
			return -1;
		}
		return i;
	}
	@Override
	public T getLast() throws EmptyListException {
		return get(currPos);
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
		add(currPos,element);
		
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
		if(find(element)>=0) {
			remove(element);
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
}
