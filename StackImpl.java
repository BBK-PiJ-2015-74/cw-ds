/**
 * StackImpl.java is a class which extends AbstractStack, which implements Interface Stack
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 */

// If I'm understanding you correctly this should be fine at runtime:
// Stack nullListStack = new StackImpl(null);
// Correct. That line must not throw a NullPointerException. 
// But as soon as you try to do anything to that Stack instance at runtime, for example:
// nullListStack.push("oops");
// The specification requires that a NullPointerException is thrown?
// Correct again. Please note that you do not have to do anything especial for a NullPointerException to be thrown at this point. 
// As the internal pointer is null (given the constructor of AbstractStack), Java will throw the exception as soon as you try to call any methods on it.
// not sure if I need to use override here or not. Override is used to override methods in the ancestor class. The ancestor class here is AbstractStack


public class StackImpl extends AbstractStack {
	
	/**
	* @see AbstractStack
	* Note, the constructor of AbstractStack does not check whether the provided list is null
	* If a null list is provided, the constructor of AbstractStack is such that a NullPointerException will be thrown at runtime
    * as soon as any operation is attempted on the underlying list.
    * Therefore, I have ensured that NPEs are not thrown by adding operations for when internalList == null.
	*/

	public StackImpl (List list) {  // protected List internalList; 
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
	*  @return the number of items currently in the stack
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
	 */
	// the top of the stack is the end of the list (Stacks are LIFO)
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
	 */
	// the top of the stack is the LAST item in the list (Stacks are LIFO)
	@Override
	public ReturnObject top() {
		if (this.isEmpty()) {				
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
		return internalList.get((internalList.size()-1)); // return the top of the stack (last item in the list)
		}
	}
	
	/**
	 * @see Stack#pop()
	 * Returns the element at the top of the stack. The element is
	 * removed from the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	// the top of the stack is the LAST item in the list (Stacks are LIFO)
	@Override
	public ReturnObject pop() {
		if (this.isEmpty()) {		
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return internalList.remove((internalList.size()-1)); // remove the top of the stack (last item in the list)
		}
	}

} // end of class
