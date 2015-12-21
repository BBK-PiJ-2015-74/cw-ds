/**
 * LinkedListImpl.java is a pointer-based linked list implementation of interface List.java
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 *
 */
public class LinkedListImpl implements List {
	
	private Object obj;
	private LinkedListImpl nextList;
	private LinkedListImpl prevList; // don't think I need this
	
	/**
	* Constructor of LinkedListImpl
	* obj is the first object in the list
	* nextList is the list (which is empty if obj == null)
	*/
	public LinkedListImpl() {
		this.obj = obj;
		this.nextList = null; 
		this.prevList = null;		// don't think I need this
	} 	

//	public Object getObject() { 		// don't need these as can access private fields within own class
//		return this.obj;
//	}
//	
//	public LinkedListImpl getNext() {
//		return this.nextList;
//	}
//	
//	public void setNext(LinkedListImpl n) {
//		this.nextList = n;
//	}
//	
//	public LinkedListImpl getPrev() {
//		return this.prevList;
//	}
//	
//	public void setPrev(LinkedListImpl p) {
//		this.prevList = p;
//	}
	
	
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
	}
	
	/**
	 * @see List#size()
	 * @return the number of items currently in the list
	 */
	@Override
	public int size() {
		if (obj == null) {
			return 0;
		} else if (this.nextList == null) { // should nextList be getNext()
			return 1;
		} else {
			return (1 + nextList.size());
		} 
	}
	

	/** 
	 * @see List#get(int)
	 * Returns the element at the given position. 
	 * If the index is negative or greater or equal than the size of the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, encapsulated in a ReturnObject
	 */
//	@Override
//	public ReturnObject get(int index) {
//		
//		if (index < 0 || index > (this.size()-1)) {
//			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
//		}
//		
//		if (this.isEmpty() == true) { 
//			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if the list is empty @return the appropriate error message: obj == null
//		}
//			
//		if (index == 0) {												// at start of list
//			return new ReturnObjectImpl(this.prevList.obj);		// maybe just this.prevList.obj
//			
//		} else if (index == (this.size()-1)) {
//			return new ReturnObjectImpl(this.nextList.obj);		// at end of list
//																		// maybe just this.nextList.obj
//			
//		} else {
//			int indexhere = 0;
//			LinkedListImpl secondList = new LinkedListImpl();
//			if (indexhere > (secondList.size()-1)/2) {				// calculate half way through list to find out which is most efficient access
//				secondList = nextList;
//				indexhere = secondList.size()-1;
//				while (secondList.prevList != null) {				// there must be an easier recursive way of doing this
//					if (indexhere == index) {
//						break;
//					}
//					secondList = secondList.prevList;
//					indexhere--;
//				}
//			} else {
//				secondList = prevList;
//				while (secondList.nextList != null) {
//					if (indexhere == index) {
//						break;
//					secondList = secondList.nextList;
//					indexhere++;
//				}
//			}
//		return new ReturnObjectImpl(this.nextList.obj);
//	}
			
	// try recursively
	public ReturnObject get(int index) {
				
		if (index < 0 || index > (this.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
		}
				
		if (this.isEmpty() == true) { 
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // if the list is empty @return the appropriate error message: obj == null
				
		} else if (index == (this.size()-1)) {
			LinkedListImpl myList = new LinkedListImpl();
			myList.get(index);
			nextList = myList;
			} else {
			nextList.get(index);
			}
		return new ReturnObjectImpl(this.nextList.obj);	
	}
			
			

	/* (non-Javadoc)
	 * @see List#remove(int)
	 */
	@Override
	public ReturnObject remove(int index) {
		// TODO Auto-generated method stub
		return null;
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
		
		LinkedListImpl myList = new LinkedListImpl();
		
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT); // if a null object is provided, @return an appropriate error message
		}
		
		if (index < 0 || index > (myList.size()-1)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
		}
		
		int elementnumber = 0;
		if (obj == null) { // list is empty, therefore by definition index of object to be added is at position zero
			obj = item;
			elementnumber = 0;
		}	
		
		else if (nextList == null) { // we are at end of list, therefore by definition the index of the object to be added is myList.size()-1
			elementnumber = 1;
			myList.add(item);
		}
		
		if (nextList != null) { // we are in the middle of the list
			if (index == 0) { // add the new object at the start of the list
				
				
			
			
			
		}
			int indexValue = myList.size()-1;
			
		}
		
		
				// create a new List of the objects up until the index
				prevList = myList; // myList is now the previous part of the List
				myList.nextList = null; //set the pointer of myList to nextList to be null
				myList.add(item); // add the item using add()
				myList.add(myList);
				
	
			}	
			
		}
		return new ReturnObjectImpl(null); // @return a ReturnObject, empty if the operation is successful
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
		int elementnumber = 0;
		if (obj == null) { // list is empty
			obj = item;
		} else if (nextList == null) { // if we are at end of list
			LinkedListImpl myList  = new LinkedListImpl();
			myList.add(item);
			nextList = myList;	
		} else {
			nextList.add(item);
		}
		return new ReturnObjectImpl(null); // @return a ReturnObject, empty if the operation is successful
	}
	
}



			
		

