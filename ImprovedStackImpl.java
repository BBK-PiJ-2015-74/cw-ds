/**
 * ImprovedStackImpl.java is a class which implements ImprovedStack, but does not extend either
 * 	AbstractStack or StackImpl
 * Therefore the Abstract and Stack methods defined by these Interfaces have to be implemented again
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 */


public class ImprovedStackImpl implements ImprovedStack {
	
	protected List underlyingList;
	
	/**
	 * Constructor which does not check whether the underlying list provided is null
	 * @param list the list to be used as the underlying data structure
	 */
	public ImprovedStackImpl(List list) {
		  this.underlyingList = list;			
	    }

	/**
	 * @see Stack#isEmpty()
	 * @return false if the list is empty, true otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (underlyingList != null) {
		return underlyingList.isEmpty();
		} else {
			return true;
		}
	}

	/**
	 * @see Stack#size()
	 * @return the number of elements in the stack
	 */
	public int size() {
		if (underlyingList != null) {
			return underlyingList.size();
		} else {
			return 0;
		}
	}

	/**
	 * @see Stack#push()
	 * Adds items to the top of the stack
	 * * NB. Stacks are LIFO so the top of the stack is the last item in the list
	 */
	@Override
	public void push(Object item) { 
		if (underlyingList != null) {
			underlyingList.add(item);
		} else {
			return;
		}
	}

	/**
	 * @see Stack#top()
	 * @return the object at the top of the stack or an error message if the stack is empty
	 * * NB. Stacks are LIFO so the top of the stack is the last item in the list
	 */
	@Override
	public ReturnObject top() {
		if (this.isEmpty()) {				
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
		return underlyingList.get((underlyingList.size()-1)); 
		}
	}

	/**
	 * @see Stack#pop()
	 * @return the object at the top of the stack and removes it from the stack, or a valid error message
	 * NB. Stacks are LIFO so the top of the stack is the last item in the list
	 */
	@Override
	public ReturnObject pop() {
		if (this.isEmpty()) {		
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return underlyingList.remove((underlyingList.size()-1)); 
		}
	}

	/**
	 * @see ImprovedStack#reverse()
	 * @return a copy of the client stack with the items reversed. 
	 */
	@Override
	public ImprovedStack reverse() {
		if (this.isEmpty()) {
			return this;
		} else {
			List reversedList = new ArrayList();
			ImprovedStack reversedStack = new ImprovedStackImpl(reversedList);
			int i = 0;
			for (i = this.size()-1; i>= 0; i--) { // from the top to the bottom of the existing Stack
				Object obj = underlyingList.get(i).getReturnValue();
				reversedList.add(obj);	
			}
		return reversedStack;
		}
	}

	/**
	 * @see ImprovedStack#remove()
	 * @param object the object to remove. Multiple instances of the same object are all removed.
	 * @return void
	 * The client stack will have the objects removed once this method is called, including multiple instances of the same object.
	 */
	@Override
	public void remove(Object object) {
		if (this.isEmpty()) {
			return;
		} else {
			int i = 0;
			for (i = 0; i < this.size()-1; i++) {
				if (underlyingList.get(i).getReturnValue().equals(object)) {
					underlyingList.remove(i);
				}
			}
		}
	}
	
} 

