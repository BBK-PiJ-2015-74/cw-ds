/**
 * StackImpl.java is a class which extends AbstractStack, which implements Interface Stack
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 * @see AbstractStack.java
 * @see Stack.java
 */

public class StackImpl extends AbstractStack {
	
	/**
	* @see AbstractStack
	* Note, the constructor of AbstractStack does not check whether the provided list is null
	* If a null list is provided, the constructor of AbstractStack is such that a NullPointerException will be thrown at runtime
    * as soon as any operation is attempted on the underlying list.
    * Therefore, I have ensured that NPEs are not thrown by adding operations for when internalList == null.
	*/

	public StackImpl (List list) { 
		super(list);				// special constructor for class which extends another class
    }
	
	/**
	* @see Stack#isEmpty()
	* @return true if the stack is empty, false otherwise
	*/
	@Override							
	public boolean isEmpty() {
		if (internalList != null) {
		return internalList.isEmpty();
		} else {
			return true;
		}
	}

	/**
	* @see Stack#size()
	* @return the number of items currently in the stack
	*/
	@Override
	public int size() {
		if (internalList != null) {
			return internalList.size();
		} else {
			return 0;
		}
	}

	/**
	 * @see Stack#push()
	 * Adds an element at the top of the stack. 
	 * @param item the new item to be added
	 * if internalList is null, nothing happens (routine executes but returns void)
	 * if item is null, the add(item) method will automatically return an error
	 * NB. the top of the stack is the end of the list (stacks are LIFO)
	 */
	@Override
	public void push(Object item) { 
		if (internalList != null) {
			internalList.add(item);
		} else {
			return;
		}
	}

	/**
	 * @see Stack#top()
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 * NB. the top of the stack is the last item in the list (stacks are LIFO)
	 */
	@Override
	public ReturnObject top() {
		if (this.isEmpty()) {				
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
		return internalList.get((internalList.size()-1)); 
		}
	}
	
	/**
	 * @see Stack#pop()
	 * Returns the element at the top of the stack. The element is
	 * removed from the stack.
	 * NB. the top of the stack is the last item in the list (stacks are LIFO)
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	@Override
	public ReturnObject pop() {
		if (this.isEmpty()) {		
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return internalList.remove((internalList.size()-1)); 
		}
	}

} 
