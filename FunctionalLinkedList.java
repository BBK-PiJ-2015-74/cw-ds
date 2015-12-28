/**
 * Implementation of interface FunctionalList
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * @See#FunctionalList.java
 * @See#List.java
 */

// FunctionalLinkedList is just like LinkedList
// FunctionalList is just like List.java
// we could easily have the methods within the LinkedList.java file, and the specification of interface FunctionalList within the List.java file

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	@Override
    public ReturnObject head() {
        if (this.isEmpty() == true) {
        	return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); // empty structure, no object to retrieve, Object head == null
        } else {
        	return new ReturnObjectImpl(this.get(0).getReturnValue()); 
        }
    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	@Override
    public FunctionalList rest() {
    	if (this.isEmpty() == true) { // if the original list is empty, return an empty list
    		FunctionalList myFL = new FunctionalLinkedList();
    		return myFL;
    	}
    	if(this.size() == 1) { // if the original list has only one element, return an empty list
    		FunctionalList myFL = new FunctionalLinkedList();
    		return myFL;
    	} else {
    		FunctionalList myFL = new FunctionalLinkedList();
    		this.remove(0);
    		myFL = this;
    		return myFL;
    	}
    }
}
