/**
* This file contains an implementation of interface List, described in file List.java
* @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
*
* all the text below here was copied from the List.java file to remind myself what I need to implement
* All the script file will need to see is the List.java file
* LinkedListImpl is an implementation of interface List, using pointers to create the LinkedList
* Objects are objects in the list. Once an object is in the list it forms a new LinkedList
*/

public class LinkedListImpl implements List {
	
	Object obj;
	LinkedListImpl nextList;
	
	/**
	* Constructor of LinkedListImpl
	*/
	
	public LinkedListImpl() { // constructor instantiating the class LinkedList
	} 	
	
	/**
	 * @return true if the list is empty, false otherwise. 
	 */
	//@return boolean - need to sort out javadoc comments
	public boolean isEmpty() { // method isEmpty, does not take parameters, returns a boolean
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the number of items currently in the list
	 */
	public int size();
		if (obj == null) {
			return 0;
		} else if (nextList == null) {
			return 1;
		} else {
			return (1 + nextList.size());
		} 
	}
			
			
		
		

	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index);

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index);

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(int index, Object item) {
	}



	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item) { // item is the name of the slot, object is the physical memory we have allocated
	
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
	
		// list is empty
		if (obj == null) {
			obj = item;
		}
			
		// we are at the end of the list
		} else if (nextList == null) {
			linkedList l  = new linkedList();
			l.add(item);
			nextList = l;	
		// add an item to the list (because the objects themselves don't have pointers)
		} else {
			nextList.add(item);
		}
		return new ReturnObjectImpl(null);
	}
		
			
		 
		 
		
	
	
}
