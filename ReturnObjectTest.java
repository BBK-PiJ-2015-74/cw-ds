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
		* Test the return object implementation for the case where there is no error
		* This operation should return the ErrorMessage NO_ERROR
		* @test 
		*/ 
		
		ReturnObject myTestRO1 = new ReturnObjectImpl();
		obj = String("Lucie");
		
		if (myTestRO1.hasError() == false) {
			System.out.println("There is no error and the ErrorMessage should read NO_ERROR");
			System.out.println(myTestRO.getError());
			System.out.println(myTestRO.getReturnObject());
		} else {
			System.out.println("There is an error, but there should not be, because we have entered a valid object");
			System.out.println("Therefore something is wrong with the ReturnObjectImplementation");
		}
		
		
		/** 
		* Test the return object implementation for the case where the programmer tries to retrieve an element from an empty data structure
		* This operation should return the ErrorMessage EMPTY_STRUCTURE
		* @test 
		*/ 
	
		ReturnObject myTestRO2 = new ReturnObjectImpl();
		obj = null; 
		if (myTestRO2.hasError() == false) {
			System.out.println("There is something wrong with the ReturnObjectImplementation, because there should be an error");
		} else {
			System.out.println(myTestRO2.getError());
		}
	
	}
}		
			
		
	
		
		
