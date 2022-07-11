package utilities;

import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E> {

	private E[] list;
	int iteratorIndex;
	
	public MyIterator(E[] input) {
		this.list = input;
		this.iteratorIndex = 0;
	}
	


	@Override
	public boolean hasNext() {
		if (iteratorIndex < this.list.length) {
			if (this.list.length > 0) {
				return (list[iteratorIndex] != null);
			} else return false;
		} else return false;		
	}

	@Override
	public E next() throws NoSuchElementException {
		if (list[iteratorIndex] != null) 
			return (list[iteratorIndex++]);
		else 
			throw new NoSuchElementException("No more elements available");
	}
	

}
