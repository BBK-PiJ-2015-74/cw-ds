/**
* This file contains a test script for implementation of interface ReturnObject and implementation ReturnObjectImpl
* @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
*/

public class ReturnObjectTest {

	/** 
	* @param args
	*/
	public static void main(String[] args) {
		
		/**  
		* Test what happens with a null object
		* Test for the case that hasError() should return true when called on a null object
		* In this case the ErrorMessage should be EMPTY_STRUCTURE
		* @Test
		*/	
		ReturnObject myTestRO1 = new ReturnObjectImpl(null);
		System.out.println("Test 1");
		System.out.println("hasError() should return true when called on a null object");
		if ((myTestRO1.hasError()) != true) {
			System.out.println("There is a problem");
		} else { 
			System.out.println("Everything is workly correctly");
		}
		
		/**
		 * Test for what happens with a null object
		 * Test for the case that getReturnValue() should return null on a null object 
		 * @Test
		 */
		ReturnObject myTestRO2 = new ReturnObjectImpl(null);
		System.out.println("Test 2");
		System.out.println("getReturnValue() should return null when called on a null object");
		if ((myTestRO2.getReturnValue()) != null) {
			System.out.println("There is a problem");
		} else { 
			System.out.println("Everything is workly correctly");
		}
		
		/**
		 * Test for what happens with a null object
		 * Test for the case that getError() should return EMPTY_STRUCTURE when called on a null object 
		 * @Test
		 */
		ReturnObject myTestRO3 = new ReturnObjectImpl(null);
		System.out.println("Test 3");
		System.out.println("getError() should return EMPTY_STRUCTURE when called on a null object");
		if ((myTestRO3.getError()) != ErrorMessage.EMPTY_STRUCTURE) {
			System.out.println("There is a problem");
		} else { 
			System.out.println("Everything is workly correctly");
		}
		

		/**
		* Check that getError() method returns NO_ERROR if and only if hasError() returns false.
		* @Test
		*/
		Object testObject4 = "thisIsATest";
		ReturnObject myTestRO4 = new ReturnObjectImpl(testObject4);
		System.out.println("Test 4");
		System.out.println("getError() should return NO_ERROR if and only if hasError() returns false");
		if ((myTestRO4.hasError()) == false) {
			if ((myTestRO4.getError()) != (ErrorMessage.NO_ERROR)) {
			System.out.println("There is a problem");
			} else { 
			System.out.println("Everything is workly correctly");
			}
		}
		
		/**
		* Check that getError() method returns NO_ERROR if a valid object is passed.
		* @Test
		*/
		Object testObject5 = "thisIsAnotherTest";
		ReturnObject myTestRO5 = new ReturnObjectImpl(testObject5);
		System.out.println("Test 5");
		System.out.println("getError() should return NO_ERROR if a valid object is passed");
		if ((myTestRO5.getError()) != (ErrorMessage.NO_ERROR)) {
			System.out.println("There is a problem");
		} else { 
			System.out.println("Everything is workly correctly");
		}
		
		
		/**
		 * Test that the appropriate ReturnObject is returned if there is no error, or null if there has been an error
		 * @Test
		 */
		Object testObject6 = "thisIsYetAnotherTest";
		ReturnObject myTestRO6 = new ReturnObjectImpl(testObject6);
		System.out.println("Test 6");
		System.out.println("getReturnValue() should return ReturnObject if a valid object is passed");
		if (myTestRO6.getReturnValue() != testObject6) {
			System.out.println("There is a problem");
		} else { 
			System.out.println("Everything is workly correctly");	
		}
		
		Object testObject7 = "thisIsAnExtraTest";
		ReturnObject myTestRO7 = new ReturnObjectImpl(testObject7);
		System.out.println("Test 7");
		System.out.println("getReturnValue() should return ReturnObject if hasError() returns false i.e. if there is no error");
		if (myTestRO7.hasError() == false) {
			if (myTestRO7.getReturnValue() != testObject7) {
				System.out.println("There is a problem");
			} else { 
				System.out.println("Everything is workly correctly");	
			}
		}
		
		Object testObject8 = null;
		ReturnObject myTestRO8 = new ReturnObjectImpl(testObject8);
		System.out.println("Test 8");
		System.out.println("getReturnValue() should return null if hasError() returns true i.e. if there is an error");
		System.out.println("The test object is null and should be " + testObject8);
		if (myTestRO8.hasError() != true) {
			System.out.println("Something has gone wrong");
		}
		if (myTestRO8.hasError() == true) {
			if (myTestRO8.getReturnValue() != null) {
				System.out.println("There is a problem");
			} else { 
				System.out.println("Everything is workly correctly");
			}
		}
		
		System.out.println("End of test file");

		
	} // end of psvm

} // end of class

		
		
