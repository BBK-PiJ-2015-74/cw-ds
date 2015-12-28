/**
 * LinkedList.java is a pointer-based linked list implementation of interface List.java
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 *
 */
public class LinkedList implements List {
	
	private Object obj;
	private LinkedList nextList;
	
	/**
	* Constructor of LinkedList
	* obj is the first object in the list
	* nextList is the pointer to the rest of the list (which is empty if obj == null)
	*/
	public LinkedList() {
		this.obj = obj;
		this.nextList = null; 
	} 	

	public Object getObject() { 		
		return this.obj;
	}

	public LinkedList getNextList() {
		return this.nextList;
	}
	
	public void setNextList(LinkedList newList) {
		this.nextList = newList;
	}
	
	
	/**
	 * @see List#isEmpty()
	 * @return true if the list is empty, false otherwise. 
	 */
	@Override
	public boolean isEmpty() {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	} // end of isEmpty()
	
	/**
	 * @see List#size()
	 * @return the number of items currently in the list
	 * Note index starts at 0, so the number of items in the list is size = (index + 1)
	 */
	@Override
	public int size() {
		if (obj == null) {
			return 0;
		} else if (this.nextList == null) { // we are at the end of the list
			return 1;
		} else {
			return (1 + nextList.size()); // not at the end of the list, count 1 and move to the next object in in the list until nextList == null
		} 
	} // end of size()
	

	/** 
	 * @see List#get(int)
	 * Returns the element at the given position. 
	 * If the index is negative or greater or equal than the size of the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, encapsulated in a ReturnObject
	 * 
	 * LB NOTE: indexing starts at zero
	 */

	// try recursively
	public ReturnObject get(int index) {
				
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // index out of range
		}
				
		if (this.isEmpty() == true) { 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // empty structure, no object to retrieve, obj == null
		}
			
		else if (index == 0) { // index is within bounds, we are at start of list and list is not empty
			return new ReturnObjectImpl(getObject());
		}
		
		else {
			return nextList.get(index-1);
		}
	} // end of get(index)
				
				
//		} else if (index == (this.size()-1)) {
//			LinkedList myList = new LinkedList();
//			myList.get(index);
//			nextList = myList;
//			} else {
//			nextList.get(index);
//			}
//		return new ReturnObjectImpl(this.nextList.obj);	
//	}
//			
			

	/** 
	 * @see List#remove(int)
	 * @param index - is the index of the element to be removed from the list, starting from the first element in the list which is zero
	 */
//	@Override
//	public ReturnObject remove(int index) {
//		TO DO 
//		return null;
//	}

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
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT); // can't add a null object to the list
		}

		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
		}

		if (index == 0) {
			if (this.isEmpty()) {
				obj = item; 	// if we are at the head of the list, and the list is empty, just add the object here
			} else {			// insert newList here
				LinkedList newList = new LinkedList(); // create a new empty list, which will become the second element
				newList.obj = this.getObject();       // this.getObject() is the object in the original list, which now becomes the object in the new list, leaving a space at the head of the list
				this.obj = item;					// add the item to the space at the head of the list
				newList.nextList = this.getNextList();	// link the tail of newList to nextList of head element
				this.nextList = newList;           // finally, set nextList of the new combined list
			}
			return new ReturnObjectImpl(null);
			
		} else {
			return nextList.add(index-1, item);
		}
	}

		

	
//		// different method
//		if (index != 0) {
//			if (this.isEmpty()) {
//				obj = item;
//			} else {
//				LinkedList listBefore = new LinkedList();
//				listBefore.obj.get(index-1) = this.getObject();
//				listBefore.add(item);
//				LinkedList listAfter = new LinkedList();
//				
//			}
//		}


	/**
	 * @see List#add(java.lang.Object)
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the request must be ignored and an appropriate error must be returned.
	 * If the list is empty, then obj is the item to be inserted
	 * or if nextList is null, create a new LinkedListImpl called myList
	 * or if nextList is not null (already has objects in it), add the item to the list 
	 * 
	 * @param item is the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise (because this list cannot contain null objects)
	 */
	@Override
	public ReturnObject add(Object item) {
		
		if (item == null) { // if we try to add a null item to the list
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT); // @return a ReturnObject containing an appropriate error message
		}
		
		if (this.isEmpty() == true) { // list is empty, add here
			obj = item;
			
		} else if (nextList == null) { // if we are at end of list
			LinkedList newList  = new LinkedList();
			newList.add(item);
			nextList = newList;	
		} else {
			nextList.add(item);
		}
		return new ReturnObjectImpl(null); // @return a ReturnObject, empty if the operation is successful - not sure why this should be null
	}
	
} // end of LinkedListImpl class


// Another way of trying 'get' which seemed not to work
//@Override
//public ReturnObject get(int index) {
//	
//	if (index < 0 || index > (this.size()-1)) {
//		return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
//	}
//	
//	if (this.isEmpty() == true) { 
//		return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if the list is empty @return the appropriate error message: obj == null
//	}
//		
//	if (index == 0) {												// at start of list
//		return new ReturnObjectImpl(this.prevList.obj);		// maybe just this.prevList.obj
//		
//	} else if (index == (this.size()-1)) {
//		return new ReturnObjectImpl(this.nextList.obj);		// at end of list
//																	// maybe just this.nextList.obj
//		
//	} else {
//		int indexhere = 0;
//		LinkedListImpl secondList = new LinkedListImpl();
//		if (indexhere > (secondList.size()-1)/2) {				// calculate half way through list to find out which is most efficient access
//			secondList = nextList;
//			indexhere = secondList.size()-1;
//			while (secondList.prevList != null) {				// there must be an easier recursive way of doing this
//				if (indexhere == index) {
//					break;
//				}
//				secondList = secondList.prevList;
//				indexhere--;
//			}
//		} else {
//			secondList = prevList;
//			while (secondList.nextList != null) {
//				if (indexhere == index) {
//					break;
//				secondList = secondList.nextList;
//				indexhere++;
//			}
//		}
//	return new ReturnObjectImpl(this.nextList.obj);
//}
		
			
		

