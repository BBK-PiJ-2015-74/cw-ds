/**
* This file contains a test script for implementation of interface ReturnObject and implementation ReturnObjectImpl
* @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
*/

public class ReturnObjectTest {

	public static void main(String[] args) {
		
		// test a null object: at this point the constructor doesn't know if we have a Object or an ErrorMessage as the input argument
		
		/**  
		* Test hasError() on a null object
		* hasError() should return true when called on a null object
		* @Test
		*/	
		ReturnObject myTestRO1 = new ReturnObjectImpl(null);
		System.out.println("Test 1");
		System.out.println(myTestRO1);
		System.out.println("hasError() should return true when called on a null object");
		System.out.println((myTestRO1.hasError() == true)? "Everything is working correctly" : "There is a problem");
		
		
		/**
		 * Test getError() on a null object
		 * getError() should return null when called on a null object
		 * This is the case where it is not specified that Error Message EMPTY_STRUCTURE should be returned
		 * @Test
		 */
		ReturnObject myTestRO2 = new ReturnObjectImpl(null);
		System.out.println("Test 2");
		System.out.println("getError() should return null when called on a null object");
		System.out.println((myTestRO2.getError() == null)? "Everything is working correctly" : "There is a problem");
	
		
		/**
		 * Test getReturnValue() on a null object
		 * getReturnValue() should return null on a null object, especially if hasError() is true 
		 * @Test
		 */
		ReturnObject myTestRO3 = new ReturnObjectImpl(null);
		System.out.println("Test 3");
		System.out.println("getReturnValue() should return null when called on a null object");
		System.out.println((myTestRO3.getReturnValue() == null)? "Everything is working correctly" : "There is a problem");
		
		
		// test a valid input object
		
		/**
		* Check that hasError() returns false if a valid test object is passed.
		* @Test
		*/
		Object testObject4 = "thisIsATest";
		ReturnObject myTestRO4 = new ReturnObjectImpl(testObject4);
		System.out.println("Test 4");
		System.out.println(testObject4);
		System.out.println("hasError() should return false when a valid test object is passed");
		System.out.println(myTestRO4.hasError() == false? "Everything is working correctly" : "There is a problem"); 
		

		/**
		* Check that getError() method returns NO_ERROR if a valid test object is passed.
		* @Test
		*/
		Object testObject5 = 3.142;
		ReturnObject myTestRO5 = new ReturnObjectImpl(testObject5);
		System.out.println("Test 5");
		System.out.println(testObject5);
		System.out.println("getError() should return NO_ERROR when a valid test object is passed");
		System.out.println(myTestRO5.getError() == ErrorMessage.NO_ERROR? "Everything is working correctly" : "There is a problem"); 
		
		/**
		* Check that getError() method must return NO_ERROR if and only if hasError() returns false
		* @Test
		*/
		Object testObject6 = "thisIsAnotherTest";
		ReturnObject myTestRO6 = new ReturnObjectImpl(testObject6);
		System.out.println("Test 6");
		System.out.println(testObject6);
		System.out.println("getError() should return NO_ERROR if and only if hasError() returns false");
		System.out.println(myTestRO6.hasError() == false && myTestRO6.getError() == ErrorMessage.NO_ERROR? "Everything is working correctly" : "There is a problem"); 	
		
		
		/**
		 * getReturnValue() should return the object for a valid test object
		 * @Test
		 */
		Object testObject7 = 70000000;
		ReturnObject myTestRO7 = new ReturnObjectImpl(testObject7);
		System.out.println("Test 7");
		System.out.println(testObject7);
		System.out.println("getReturnValue() should return the test object if a valid object is passed");
		System.out.println(myTestRO7.getReturnValue() == testObject7? "Everything is working correctly" : "There is a problem"); 	
		
		
		/**
		 * getReturnValue() should return the object for a valid test object when hasError() is false
		 * @Test
		 */
		Object testObject8 = 800000000;
		ReturnObject myTestRO8 = new ReturnObjectImpl(testObject8);
		System.out.println("Test 8");
		System.out.println(testObject8);
		System.out.println("getReturnValue() should return the object if hasError() returns false i.e. if there is no error");
		System.out.println(myTestRO8.hasError() == false && myTestRO8.getReturnValue() == testObject8? "Everything is working correctly" : "There is a problem"); 	
		
		// test a null input object (specified as Object myObject)
		
		/**
		 * TO DO
		 */
		
		/**
		 * getReturnValue() should return null for a valid null test object when hasError() is false
		 */
		Object testObject9 = null;
		ReturnObject myTestRO9 = new ReturnObjectImpl(testObject9);
		System.out.println("Test 9");
		System.out.println(testObject9);
		System.out.println("getReturnValue() should return null when a valid null object is passed and there is no error in the test object i.e. hasError() returns false");
		System.out.println(myTestRO9.hasError() == false && myTestRO9.getReturnValue() == null? "Everything is working correctly" : "There is a problem"); 	
		
		/**
		 * getReturnValue() should return null when the test object is null, but hasError() returns true as test object is NOT valid
		 */
		ReturnObject myTestRO10 = new ReturnObjectImpl(null);
		System.out.println("Test 10");
		System.out.println("null");
		System.out.println("getReturnValue() should return null when a null object is passed which is an error, i.e. hasError() returns true");
		System.out.println("The test object is null and should be " + "null");
		System.out.println(myTestRO10.hasError() == true && myTestRO10.getReturnValue() == null? "Everything is working correctly" : "There is a problem"); 	
		
		// Scenarios 9 and 10 don't seem to make sense when taken together as they return different results for a null input object
		
		// Now testing on error messages
		
		/**
		 * hasError() should return true when called on EMPTY STRUCTURE 
		 */
		ReturnObject myTestRO11 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		System.out.println("Test 11");
		System.out.println("EMPTY_STRUCTURE");
		System.out.println("hasError() should return true when called on an error message EMPTY_STRUCTURE");
		System.out.println(myTestRO11.hasError() == true? "Everything is working correctly" : "There is a problem"); 
		
		/**
		 * getError() should return EMPTY_STRUCTURE when called on EMPTY STRUCTURE 
		 */
		System.out.println("Test 12");
		System.out.println("getError() should return EMPTY_STRUCTURE when called on an error message EMPTY_STRUCTURE");
		System.out.println(myTestRO11.getError() == ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem"); 	
		
		/**
		 * getReturnValue() should return null when called on EMPTY STRUCTURE 
		 */
		System.out.println("Test 13");
		System.out.println("getReturnValue() should return null when called on an error message EMPTY_STRUCTURE");
		System.out.println(myTestRO11.getReturnValue() == null? "Everything is working correctly" : "There is a problem"); 
		
		/**
		 * hasError() should return true when called on INDEX_OUT_OF_BOUNDS 
		 */
		ReturnObject myTestRO14 = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		System.out.println("Test 14");
		System.out.println("INDEX_OUT_OF_BOUNDS");
		System.out.println("hasError() should return true when called on an error message INDEX_OUT_OF_BOUNDS");
		System.out.println(myTestRO14.hasError() == true? "Everything is working correctly" : "There is a problem"); 
		
		/**
		 * getError() should return INDEX_OUT_OF_BOUNDS  when called on INDEX_OUT_OF_BOUNDS  
		 */
		System.out.println("Test 15");
		System.out.println("getError() should return INDEX_OUT_OF_BOUNDS  when called on an error message INDEX_OUT_OF_BOUNDS ");
		System.out.println(myTestRO14.getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS? "Everything is working correctly" : "There is a problem"); 	
		
		/**
		 * getReturnValue() should return null when called on INDEX_OUT_OF_BOUNDS  
		 */
		System.out.println("Test 16");
		System.out.println("getReturnValue() should return null when called on an error message INDEX_OUT_OF_BOUNDS");
		System.out.println(myTestRO14.getReturnValue() == null? "Everything is working correctly" : "There is a problem"); 
		
		
		/**
		 * hasError() should return true when called on INVALID_ARGUMENT 
		 */
		ReturnObject myTestRO17 = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		System.out.println("Test 17");
		System.out.println("INVALID_ARGUMENT");
		System.out.println("hasError() should return true when called on an error message INVALID_ARGUMENT");
		System.out.println(myTestRO17.hasError() == true? "Everything is working correctly" : "There is a problem"); 
		
		/**
		 * getError() should return INVALID_ARGUMENT when called on error message INVALID_ARGUMENT  
		 */
		System.out.println("Test 18");
		System.out.println("getError() should return INVALID_ARGUMENT when called on an error message INVALID_ARGUMENT");
		System.out.println(myTestRO17.getError() == ErrorMessage.INVALID_ARGUMENT? "Everything is working correctly" : "There is a problem"); 	
		
		/**
		 * getReturnValue() should return null when called on INVALID_ARGUMENT  
		 */
		System.out.println("Test 19");
		System.out.println("getReturnValue() should return null when called on an error message INVALID_ARGUMENT");
		System.out.println(myTestRO17.getReturnValue() == null? "Everything is working correctly" : "There is a problem"); 
		
		/**
		 * hasError() should return false when called on error message NO_ERROR
		 */
		// This test doesn't make sense. hasError should return false when the object is ErrorMessage.NO_ERROR
		ReturnObject myTestRO20 = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		System.out.println("Test 20");
		System.out.println("NO_ERROR");
		System.out.println("hasError() should return false when called on an error message NO_ERROR");
		System.out.println(myTestRO20.hasError() == false? "Everything is working correctly" : "There is a problem"); 
		
		/**
		 * getError() should return NO_ERROR when called on error message NO_ERROR 
		 */
		System.out.println("Test 21");
		System.out.println("getError() should return NO_ERROR when called on an error message NO_ERROR");
		System.out.println(myTestRO20.getError() == ErrorMessage.NO_ERROR? "Everything is working correctly" : "There is a problem"); 	
		
		/**
		 * getReturnValue() should return null when called on error message NO_ERROR
		 */
		System.out.println("Test 22");
		System.out.println("getReturnValue() should return null when called on an error message NO_ERROR");
		System.out.println(myTestRO20.getReturnValue() == null? "Everything is working correctly" : "There is a problem"); 
		
		
				
		System.out.println("END OF TEST FILE");
		
		
	} // end of psvm

} // end of class
