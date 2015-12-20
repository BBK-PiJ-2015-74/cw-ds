/**
 * LinkedListImpl.java is a pointer-based linked list implementation of interface List.java
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 *
 */
public class LinkedListImpl implements List {
	
	private Object obj;
	private LinkedListImpl nextList;
	private LinkedListImpl prevList;
	private int element;
	
	/**
	* Constructor of LinkedListImpl
	* obj is the first object in the list
	* nextList is the list (which is empty if obj == null)
	*/
	public LinkedListImpl() {
		this.obj = obj;
		this.nextList = nextList; 
		this.prevList = prevList;
		this.element = element;
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
	}
	
	/**
	 * @see List#size()
	 * @return the number of items currently in the list
	 */
	@Override
	public int size() {
		if (obj == null) {
			return 0;
		} else if (nextList == null) {
			return 1;
		} else {
			return (1 + nextList.size());
		} 
	}
	
	

	/* (non-Javadoc)
	 * @see List#get(int)
	 */
	@Override
	public ReturnObject get(int index) {
		// TODO Auto-generated method stub
		return null;
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
		
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT); // if a null object is provided, @return an appropriate error message
		}
		
		if (obj == null) { // list is empty
			obj = item;
		
		} else if (nextList != null) { // i.e. if we are inserting element in the middle of the list
			LinkedListImpl myList  = new LinkedListImpl();
			if (index < 0 || index >= (myList.size()-1)) {
				return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); // if the index is incorrect @return the appropriate error message
			} else {
				// create a new List of the objects up until the index
				myList = 
				prevList = myList; // myList is now the previous part of the List
				myList.nextList = null; //set the pointer of myList to nextList to be null
				myList.add(item); // add the item using add()
				
	
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
	 * or if nextList is null, create a nextList called myList
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
