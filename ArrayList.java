/**
 * ArrayList is an array list implementation of interface List
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * @see #List.java
 *
 */
public class ArrayList implements List {
	
	private Object[] objectArray; // means an array of Objects
	private int size;
	private static int basearraylength = 50; 

	
	public ArrayList() { // constructor
		this.objectArray = new Object[ArrayList.basearraylength]; //arrays have a special type of constructor e.g. String[] employeeArray = new String[5];
		this.size = 0;
	}

	 /**
	  *  @return true if the list is empty, false otherwise. 
	  */
	@Override
	public boolean isEmpty() {
		boolean result = true;
		for (int i = 0; i < this.objectArray.length; i++) {
			if (this.objectArray[i] != null) {
				result = false;
				return result;
			}
		}
		return result;
	}
	
	/**
	 * @return the number of items currently in the list
	 */
	@Override
	public int size() {
		return size; 
//		int result = 0;
//		for (int i = 0; i < this.objectArray.length; i++) {
//			if (this.objectArray[i] != null) {
//				result ++;
//			} 
//		}
//		return result;
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
		
		if (index < 0 || index > (this.size()-1)) {  // if this.size is 4, max index is 3
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is out of range @return the appropriate error message
			
		} else {
			return new ReturnObjectImpl(objectArray[index]);
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
		
		if (this.isEmpty() == true) { 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if the list is empty @return the appropriate error message
		}
		
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			
		} else {		
			Object[] destArray = new Object [this.objectArray.length];	
			int i = 0;
			for (i = index; i< this.size(); i++) { 
				destArray[i] = objectArray[i];	//Copy every element from objectArray into destArray (remember destArray = srcArray) starting at the index
			}
			
			ReturnObject objectRemoved = new ReturnObjectImpl(this.objectArray[index]);
			size--;
			
			for (i = index; i< this.size(); i++) {
				objectArray[i] = destArray[i+1];	// copy everything back from destArray (at position i+1) into objectArray (at position i), starting at the index
			}
			
			if (baseArrayNeedsToBeSmaller()) {
				this.decreaseBaseArrayLength(); //if base array is full, increase its length
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
		
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		
		if (baseArrayNeedsToBeLarger()) {
			this.increaseBaseArrayLength(); //if base array is full, increase its length
		}
		
		// first of all we have to find the element in the array where to add the item. 
		// Then shift everything up the array by 1 to make a space
		
		int i = 0;
		Object[] destArray = new Object [this.objectArray.length];	
		
		for (i = index; i< this.size(); i++) { 
			destArray[i] = objectArray[i];	//Copy every element from objectArray into destArray (remember destArray = srcArray) starting at the index
		}
		
		objectArray[index] = item;			// at item at index
		size++;
		
		for (i = index; i< this.size(); i++) {
			objectArray[i+1] = destArray[i];// copy everything back from destArray (at position i) into objectArray (at position i + 1), starting at the index
		}
		return new ReturnObjectImpl(null); // ReturnObject is null for a successful operation when adding an object
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
		if (baseArrayNeedsToBeLarger()) {
			this.increaseBaseArrayLength(); //if base array is full, increase its length
		}
		this.objectArray[this.size()] = item;     // add item to the next free element in the array
		size++;
		return new ReturnObjectImpl(null); // ReturnObject is null for a successful operation
	}	

	
	/**
	 * Increases the size of the base array into which the objects will be added, if necessary
	 */
	private void increaseBaseArrayLength() {
		int currentarraylength = this.objectArray.length;
		int increasedbasearraylength = 2*currentarraylength;
		
		Object[] biggerArray = new Object [increasedbasearraylength];
		
		int i = 0;
		for (i = 0; i < this.size(); i++) {
			biggerArray[i] = this.objectArray[i];
		}
		this.objectArray = biggerArray;
	}
	
	private boolean baseArrayNeedsToBeLarger() {
		boolean result = false;
		if (this.size() >= this.objectArray.length) {
			result = true;
			return result;
		}
		return result;
	}
	
	/**
	 * Decreases the size of the base array from which objects will be removed, if necessary
	 */
	private void decreaseBaseArrayLength() {
		int basearraylength = this.objectArray.length;
		
		int decreasedbasearraylength = basearraylength/2; // dividing by 2 will return an int, not a double - will be rounded to nearest int
		
		if (decreasedbasearraylength < 10) { //sets 10 as the minimum size of the base array
			decreasedbasearraylength = 10;
		}
		
		Object[] smallerArray = new Object [decreasedbasearraylength];
		
		int i = 0;
		for (i = 0; i < this.size(); i++) {
			smallerArray[i] = this.objectArray[i];
		}
		this.objectArray = smallerArray;
	}
	
	private boolean baseArrayNeedsToBeSmaller() {
		boolean result = false;
		if (this.size() <= this.objectArray.length/2) {
			result = true;
			return result;
		}
		return result;
	}

} // end of class
