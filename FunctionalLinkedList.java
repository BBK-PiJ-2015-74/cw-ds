/**
 * Implementation of interface FunctionalList
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 * @See FunctionalList.java
 * @See LinkedList.java
 * @See List.java
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	public FunctionalLinkedList(){
		super();
	}
	
	/**
     * @see FunctionalList#head()
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	@Override
    public ReturnObject head() {
        if (this.isEmpty() == true) {
        	return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
        	return new ReturnObjectImpl(this.get(0).getReturnValue()); 
        }
    }

    /**
     * @see FunctionalList#rest()
     * @return a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * If the list is empty, another empty list is returned. 
     * Note using remove() changes the underlying list so I haven't used this
     */
	@Override
    public FunctionalList rest() {
		FunctionalList myFL = new FunctionalLinkedList();
    	if (this.isEmpty() == true) { 
    		return myFL;
    	} else {	
    		for (int index = 1; index < this.size(); index++) {
    			Object obj = this.get(index).getReturnValue();
    			myFL.add(obj);
    		}
			return myFL;
    	}
    }
	
} 


