
/**
 * LinkedListTest is a test of interface list, in this case constructed to work with the LinkedListImpl
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * THIS STILL NEEDS ALOT OF WORK & IS NOT WORKING CORRECTLY
 *
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * @Test - check the list is empty, that it has zero size, returns EMPTY_STRUCTURE when get() is called
		 */
		List emptyList = new LinkedListImpl();
		
		System.out.println("Test 1. Checking the list is empty");
		System.out.println(emptyList.isEmpty()==true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 2. Checking the list has size zero");
		System.out.println(emptyList.size()==0? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 3. Checking it returns EMPTY_STRUCTURE when get() is called");
		System.out.println(emptyList.get(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 4. Checking it returns null when get() is called");
		System.out.println(emptyList.get(0).getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		//System.out.println("Test 5. Checking it returns INDEX_OUT_OF_BOUNDS when remove() is called");
		//System.out.println(emptyList.remove(0).getError();
	
		/**
		 * @Test - check that objects can be added to the list
		 */
		
		List testList = new LinkedListImpl();
		
		int object1 = 1;
		double object2 = 3.142;
		String object3 = "This is a test";
		String object4 = "Jingle bells"; // was char 'c'
		double object5 = 99.99999;
		long object6 = 2*(10^60);
		String object7 = "false";
		String object8 = "Christmas is coming and the goose is getting fat";
		int object9 = -25;
		double object10 = -1000.876;
		
		testList.add(object1);
		testList.add(object2);
		testList.add(object3);
		testList.add(object4);
		testList.add(object5);
		testList.add(object6);
		testList.add(object7);
		testList.add(object8);
		testList.add(object9);
		testList.add(object10);
		ReturnObject testRO = testList.get(0);
		ReturnObject testRO3 = testList.get(3);
		ReturnObject testRO1 = testList.get(1);
		
		System.out.println("Test 5. Checking the size of the list - should have 10 elements");
		System.out.println(testList.size());
		
		System.out.println("Test 6. Checking the list is not empty");
		System.out.println(testList.isEmpty()!=true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 7. Checking the list has 10 elements");
		System.out.println(testList.size()==10? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 8. Checking there is no error, ie. that the list is a valid ReturnObject");
		System.out.println(testRO.hasError()==false? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 9. Returns a valid ReturnObject which is not null when ReturnValue is called");
		System.out.println(testRO.getReturnValue()!=null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 10. Calling get(0) should return error INDEX_OUT_OF_BOUNDS");
		System.out.println(testRO.getReturnValue());
		
		System.out.println("Test 11. Can return the element of the list at position 1 by calling get(1)");
		System.out.println(testRO.getReturnValue());
		
		System.out.println("Test 12. Can return the element of the list at position 3 by calling get(3)");
		System.out.println(testRO3.getReturnValue());
		
			
		
		
	
	}	// End of psvm	

} // End of class

