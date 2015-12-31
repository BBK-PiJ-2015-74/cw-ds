/**
 * LinkedList.java is a pointer-based linked list implementation of interface List.java
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 *
 */
public class LinkedList implements List {
	
	private Object head;
	private LinkedList nextList;
	private int size;
	
	/**
	* Constructor of LinkedList
	* obj is the first object in the list
	* nextList is the pointer to the rest of the list (which is empty if head == null)
	*/
	public LinkedList() {
		this.head = null;
		this.nextList = null; 
		this.size = 0;
	} 	

	public Object getHead() { 		
		return this.head;
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
		if (this.head == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * @see List#size()
	 * @return the number of items currently in the list
	 * Note index starts at 0, so the number of items in the list is size = (index + 1)
	 */
	@Override
	public int size() {
		return size;
	}
//		if (head == null) { // list is empty
//			return 0;
//		} else if (this.nextList == null) { // we are at the end of the list
//			return 1;
//		} else {
//			return (1 + nextList.size()); // not at the end of the list, count 1 and move to the next object in in the list until nextList == null
//		}
//	}
	

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
	public ReturnObject get(int index) {
				
		if (this.isEmpty() == true) { 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // empty structure, no object to retrieve, obj == null
		}
		
		if (index < 0 || index > this.size()-1) { 
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // index out of range
		}
			
		else if (index == 0) { // index is within bounds, we are at start of list and list is not empty
			return new ReturnObjectImpl(getHead());
		
		} else {
			return nextList.get(index-1); // ask the rest of the list, as if the next element is at index 0, i.e. as if next element is the head
		}
	}

	/** 
	 * @see List#remove(int)
	 * Returns the elements at the given position and removes it from the list. 
	 * The indeces of elements after the removed element must be updated accordignly.
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

		if (this.head == null) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if list is empty, @return EMPTY_STRUCTURE
		}

		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
		}
		
		else if (index == 0) {
			ReturnObject myRO = new ReturnObjectImpl(this.head); // return object at head of list
			if (nextList == null) {
				this.head = null; // signals an empty list
			} else {
				head = nextList.getHead(); // copy object at the head of the list following, into the existing head, to leave a null object
				this.nextList = nextList.getNextList(); // move pointer nextList to the list one along (nextList.getNext()), around the empty object
			}
			size--;
			return myRO;
		
		} else {
			size--;
			return nextList.remove(index-1); // remove next element like it's the head - if at n = 1, needs to be zero, so n-1
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
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT); // can't add a null object to the list
		}

		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
		}

		else if (index == 0) {			// **** was if not else if
			if (this.isEmpty()) {
				head = item; 	// if list is empty, add item to head
			} else {			
				LinkedList newList = new LinkedList(); // create a new empty list, which will become the second element
				newList.head = this.getHead();       // copies value of head element, A, of existing list into the new empty list
				this.head = item;					// adds item C into empty slot left by A
				newList.size = this.size();        // additional line of code for revised size() method
				newList.nextList = this.getNextList();	// this.getNextList is pointer from head to object B after
				this.nextList = newList;           // finally, set nextList of the new combined list
			}
			size++;
			return new ReturnObjectImpl(null);
		} else {
			size++;
			return nextList.add(index-1, item);
		}
	}

	
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
			head = item;
			
		} else if (nextList == null) { // if we are at end of list
			LinkedList newList  = new LinkedList();
			newList.add(item);
			nextList = newList;	
		} else {
			nextList.add(item);
		}
		size++;
		return new ReturnObjectImpl(null); // @return a ReturnObject, empty if the operation is successful
	}
	
} // end of LinkedList class



			
		

