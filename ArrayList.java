/**
 * ArrayList is an array list implementation of interface List
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * @see #List.java
 *
 */
public class ArrayList implements List {
	
	private Object[] array; // means an array of Objects
	private static int basearraylength; 
	
	public ArrayList() { // constructor
		ArrayList.basearraylength = 50; // define array to be 50 elements in length to start with	
		this.array = new Object [ArrayList.basearraylength]; //arrays have a special type of constructor e.g. String[] employeeArray = new String[5];
	}
	
	 /**
	  *  @return true if the list is empty, false otherwise. 
	  */
	@Override
	public boolean isEmpty() {
		boolean result = true;
		for (int i = 0; i < this.array.length; i ++) {
			if (this.array[i] == null) {
				result = true;	
			} else {
				result = false;
			}
		}
		return result;
	}
	
	
	/**
	 * @return the number of items currently in the list
	 */
	@Override
	public int size() {
		int result = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] != null) {
				result ++;
			} 
		}
		return result;
	}
	
	/**
	 * Returns the element at the given position. 
	 * The first element in the list is at index 0.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, encapsulated in a ReturnObject
	 */
	@Override		
	public ReturnObject get(int index) {
		
		if (this.isEmpty() == true) { 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if the list is empty @return the appropriate error message
		}
		
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is out of range @return the appropriate error message
			
		} else {
			return new ReturnObjectImpl(this.array[index]);
		}
	}

	/** 
	 * @see List#remove(int)
	 * Returns the elements at the given position and removes it from the list. 
	 * The indices of elements after the removed element must be updated accordingly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved, starting at index == 0
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	@Override
	public ReturnObject remove(int index) {
		
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			
		} else {
			ReturnObject objectRemoved = new ReturnObjectImpl(this.array[index]);
			for (int i=index; i < this.size(); i++) {
				this.array[i-1] = this.array[i]; // removing object leaves a gap, pull each object down 1 in the array
			}
		if (this.size() == basearraylength/2) {
			this.decreaseBaseArrayLength(); //if base array is half the size required, decrease its length
		}
		return objectRemoved;
		}
	}
	
	/**
	 * @see List#add(int, java.lang.Object)
	 * Adds an element to the list, inserting it at the given position. 
	 * The list starts at index 0.
	 * The indices of elements at and after that position must be updated accordingly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the request must be ignored and an appropriate error must be returned.
	 * 
	 * @param index the position at which the item should be inserted in the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	@Override
	public ReturnObject add(int index, Object item) {
		
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		
		if (this.size() == basearraylength) {
			this.increaseBaseArrayLength();      //if base array is full, increase its length
		}
		
		// first of all we have to find the element in the array where to add the item. 
		// Then shift everything up the array by 1 to make a space
		int i = 0;
		for (i = index; i< this.size(); i++) { 
			this.array[i+1] = this.array[index];						//destArray[i] = srcArray[i];
		}
		this.array[index]=item;
		return new ReturnObjectImpl(null); // ReturnObject is null for a successful operation
	}	
	
	/**
	 * @see List#add(java.lang.Object)
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
		if (this.isEmpty()) {
			this.array[0] = item;
			return new ReturnObjectImpl(null);
		} else {
			if (this.size() == basearraylength) {
				this.increaseBaseArrayLength(); //if base array is full, increase its length
			}
			this.array[this.size()] = item;     // add item to the next free element in the array
			return new ReturnObjectImpl(null); // ReturnObject is null for a successful operation
		}	
	}

	
	/**
	 * Increases the size of the base array into which the objects will be added, if necessary
	 */
	private void increaseBaseArrayLength() {
		int basearraylength = this.array.length;
		int increasedbasearraylength = 2*basearraylength;
		
		Object[] biggerArray = new Object [increasedbasearraylength];
		
		int i = 0;
		for (i = 0; i < this.size(); i++) {
			biggerArray[i] = this.array[i];
		}
		this.array = biggerArray;
	}
	
	
	/**
	 * Decreases the size of the base array from which objects will be removed, if necessary
	 */
	private void decreaseBaseArrayLength() {
		int basearraylength = this.array.length;
		
		int decreasedbasearraylength = basearraylength/2; // dividing by 2 will return an int, not a double - will be rounded to nearest int
		
		if (decreasedbasearraylength < 10) { //sets 10 as the minimum size of the base array
			decreasedbasearraylength = 10;
		}
		
		Object[] smallerArray = new Object [decreasedbasearraylength];
		
		int i = 0;
		for (i = 0; i < this.size(); i++) {
			smallerArray[i] = this.array[i];
		}
		this.array = smallerArray;
	}
	

} // end of class
