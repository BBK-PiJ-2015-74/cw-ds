/**
 * Implementation of interface ReturnObject
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 */
 
 // NB remove all comments starting with // before handing in as these are for me only
 // ReturnObjectImpl creates a ReturnObject
 
 public class ReturnObjectImpl implements ReturnObject {
 
 	/**
 	* Set up the fields in the class
 	*/
 	private Object myObject;
 	private ErrorMessage myError;
 	private boolean whetherThereIsAnError;
 	
 	/**
 	* Constructor of ReturnObjectImpl
 	* ReturnObjectImpl: This class must have two constructors, each of them with only one parameter. 
 	* The constructor used for successful operations must receive an Object
 	* In the case of successful operations, hasError() returns false, therefore boolean whetherThereIsAnError is false
 	* the constructor used for failed operations must receive an ErrorMessage as its only parameter
 	* In the case of failed operations, hasError() returns true, therefore boolean whetherThereIsAnError is true
 	* 
 	*/
 	public ReturnObjectImpl (Object obj) {
		myObject = obj;
		whetherThereIsAnError = false;
	}
	
	public ReturnObjectImpl (ErrorMessage error) {
		myError = error;
		whetherThereIsAnError = true;
 	}
 	
 	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	//@return
	public boolean hasError() {
		return whetherThereIsAnError;
	}

	/**
	 * Returns the error message. 
	 * This method must return NO_ERROR if and only if {@hasError} returns false.
	 * @return the error message
	 */
	//@return
	public ErrorMessage getError() {
		if (whetherThereIsAnError == false) {
			return myError = ErrorMessage.NO_ERROR;
		} else {
			return myError;
		}	
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
	//@return
	public Object getReturnValue() {
		return myObject;
	}

}

	

 
 	