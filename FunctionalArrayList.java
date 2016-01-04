/**
* Implementation of interface FunctionalList
* @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
* @See#FunctionalList.java interface
* @See#List.java interface
* @See#ArrayList.java implementation
*/

public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	public FunctionalArrayList(){
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
	  * @return a list with the elements in this list except the head, leaving the original list unchanged
	  * If the list is empty, another empty list is returned. 
	  */
	@Override
	public FunctionalList rest() {
		FunctionalList myFL = new FunctionalArrayList();
	    if (this.isEmpty() == true) { 
	    	return myFL;
	    } else {	
	    	for (int index = 1; index <= (this.size()-1); index++) {
	    		Object obj = this.get(index).getReturnValue();
	    		myFL.add(obj);
	    	}
			return myFL;
	    }
	}
		
}


