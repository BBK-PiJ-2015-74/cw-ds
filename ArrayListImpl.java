/**
 * ArrayList is an array list implementation of interface List.java
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 *
 */
public class ArrayListImpl implements List {
	
	private Object[] array; // means an array of Objects
	private static int numberofelements = 50; // define array to be 50 elements in length to start with
	
	public ArrayListImpl() {
		ArrayListImpl.numberofelements = 50;
		this.array = new Object [ArrayListImpl.numberofelements]; //arrays have a special type of constructor e.g. String[] employeeArray = new String[5];
	}
	
	 /**
	  *  @return true if the list is empty, false otherwise. 
	  */
	@Override
	public boolean isEmpty() {
		if (this.array == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return the number of items currently in the list
	 */
//	@Override
//	public int size() {
//		if (this.array == null) {
//			return 0;
//		} else if (this.array[i]!=null) {
//			return 1;
//		} else { 
//			return (1 + this.size()); // or this.array.size, or just array.size?
//		}
//	}

	@Override 
	public int size() {
		int result = 0;
		for (int i = 0; i < this.array.length; i ++) {
			if (this.array[i] != null) {
				result ++;
			}
		}
	return result;
	}
	
	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, encapsulated in a ReturnObject
	 */
	@Override		
	public ReturnObject get(int index) {
		
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
		}
				
		if (this.isEmpty() == true) { 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if the list is empty @return the appropriate error message: obj == null
		}
	
			return new ReturnObjectImpl(this.array[index]);
		}

	/**
	 * Returns the elements at the given position and removes it from the list. 
	 * The indices of elements after the removed element must be updated accordingly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	@Override
	public ReturnObject remove(int index) {
		
		if (index<0 || index>=this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		
		ReturnObject objectRemoved = new ReturnObjectImpl(this.array[index]);
		
		int i = 0;
		for (i = index; i < this.size(); i++)
			this.array[i+1] = this.array[i]; // removing object leaves a gap, pull each object down 1 in the array
		
		return objectRemoved;
	}
	

	@Override
	public ReturnObject add(int index, Object item) {
		
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		
		int currentsize = this.size();	// currentsize is number of full elements, starting at position zero, so next available space is at index currentsize
		if (currentsize == numberofelements) {
			this.increaseBaseArrayLength(); //increase the length of the base array
		}
		
		// first of all we have to find the element in the array where to add the item. Then shift everything up the array by 1

		
		int i = 0;
		for (i = index+1; i<=this.size(); i++) { 
			this.array[i] = this.array[index];						//destArray[i] = srcArray[i];
		}
	
		this.array[index]=item;
		
		int newsize = this.size();	// currentsize is number of full elements, starting at position zero, so next available space is at index currentsize
		if (newsize <= 0.5*numberofelements) {
			this.decreaseBaseArrayLength(); //increase the length of the base array
		}
		
		return new ReturnObjectImpl(null); // ReturnObject is null for a successful operation
	}

	
	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the request must be ignored and an appropriate error must be returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 * 			or containing an appropriate error message otherwise
	 */
	@Override
	public ReturnObject add(Object item) {
		
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		int currentsize = this.size();	// currentsize is number of full elements, starting at position zero, so next available space is at index currentsize
		if (currentsize == numberofelements) {
			this.increaseBaseArrayLength(); //increase the length of the base array
		}
		this.array[currentsize] = item;  // add item - find when an item is not null, and then add the item
		return new ReturnObjectImpl(null); // ReturnObject is null for a successful operation
	}
	
	/**
	 * Increases the size of the base array into which the objects will be added, if necessary
	 * 
	 */
	private void increaseBaseArrayLength() {
		int baseArrayLength = this.array.length;
		int increasedBaseArrayLength = 2*baseArrayLength;
		
		Object[] biggerArray = new Object [increasedBaseArrayLength];
		
		int i = 0;
		for (i = 0; i < this.size(); i++) {
			biggerArray[i] = this.array[i];
		}
		this.array = biggerArray;
	}
	
	
	/**
	 * Decreases the size of the base array from which objects will be removed, if necessary
	 * 
	 */
	private void decreaseBaseArrayLength() {
		int baseArrayLength = this.array.length;
		
		int decreasedBaseArrayLength = 0;
		if ((0.5*baseArrayLength)%2 != 0) {  // solves the problem when baseArrayLength divided by 2 gives an odd number
			decreasedBaseArrayLength = baseArrayLength/2+1;
		} else { 
			decreasedBaseArrayLength = baseArrayLength/2;
		}
		
		if (decreasedBaseArrayLength < 10) { //sets 10 as the minimum size of the base array
			decreasedBaseArrayLength = 10;
		}
		
		Object[] smallerArray = new Object [decreasedBaseArrayLength];
		
		int i = 0;
		for (i = 0; i < this.size(); i++) {
			smallerArray[i] = this.array[i];
		}
		this.array = smallerArray;
	}
	

} // end of class
