/**
 * Implementation of interface ReturnObject
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 */
 
 // NB remove all comments starting with // before handing in as these are for me only
 
 public class ReturnObjectImpl implements ReturnObject {
 
 	private Object myObject = new Object(String title, String author, int yearpublished, boolean copyrightstatus);
 	
 	/**
 	* Constructor of ReturnObjectImpl
 	*/
 	public ReturnObjectImpl (Object myObject) {
		this.myObject = myObject; 
	}
 
 	/**
	 * @returns whether or not there has been an error. True for an error, False for no error
	 */
 	public boolean hasError() {// method which returns true if there has been an error
 		boolean titleisastring = false;
 		if (myObject.getTitle() instanceof String) { //checks whether Title has been correctly entered as a String
 			titleisastring = true;
 		}
 		boolean authorisastring = false;
 		if (myObject.getAuthor() instanceof String) { //checks whether Author has been correctly entered as a String
 			authorisastring = true;
 		}
 		boolean pubyearcorrect = false;
 		if ((myObject.getYearPublished() <= 2016) && (myObject.getYearPublished() >= 1400)) { // checks whether publication year is within reasonable boundaries
 			pubyearcorrect = true;
 		}
 		if ((titleisastring = true) && (authorisastring = true) && (pubyearcorrect = true)){
 			boolean result = false;
 		} else {
 			boolean result = true; // there has been some sort of error
 		}
 		return result;
 	}
 			
 		

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError() {
	}
	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue() {
	
		if (myObject.hasError() = true) {
			return null;
		}
		while (myObject.hasError() = false) {
			if (myObject != null) {
				return myObject; // if there is an object in the list 
			} else {
				return null;
			}
		}
	}	 

}


 
 	