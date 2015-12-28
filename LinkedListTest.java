
/**
 * LinkedListTest is a test of interface list, in this case constructed to work with the LinkedList.java
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
	List emptyList = new LinkedList();
	
	System.out.println("Test 1. Checking the list is empty");
	System.out.println(emptyList.isEmpty()==true? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 2. Checking the list has size zero");
	System.out.println(emptyList.size()==0? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 3. Checking it returns EMPTY_STRUCTURE when get() is called");
	System.out.println(emptyList.get(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 4. Checking it returns null when get() is called");
	System.out.println(emptyList.get(0).getReturnValue()==null? "Everything is working correctly" : "There is a problem");
	
//	System.out.println("Test 5. Checking it returns EMPTY_STRUCTURE when remove() is called");
//	System.out.println(emptyList.remove(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");

	/**
	 * @Test - check that objects can be added to the list
	 */
	
	List testList = new LinkedList();
	
	int object0 = 1;
	double object1 = -1000.876;
	double object2 = 3.142;
	String object3 = "This is a test";
	char object4 = 'c';
	double object5 = 99.99999;
	long object6 = (long) Math.pow(10, 15);
	boolean object7 = false;
	String object8 = "Christmas is coming and the goose is getting fat";
	int object9 = -25;
	
	testList.add(object0);
	testList.add(object1);
	testList.add(object2);
	testList.add(object3);
	testList.add(object4);
	testList.add(object5);
	testList.add(object6);
	testList.add(object7);
	testList.add(object8);
	testList.add(object9);
	
	ReturnObject testRO = testList.get(0);
	ReturnObject testRO1 = testList.get(1);
	ReturnObject testRO2 = testList.get(2);
	ReturnObject testRO3 = testList.get(3);
	ReturnObject testRO4 = testList.get(4);
	ReturnObject testRO5 = testList.get(5);
	ReturnObject testRO6 = testList.get(6);
	ReturnObject testRO7 = testList.get(7);
	ReturnObject testRO8 = testList.get(8);
	ReturnObject testRO9 = testList.get(9);

	System.out.println("Test 6. Checking we can print the list");
	System.out.println(printList(testList));
	
	System.out.println("Test 7. Checking we can print the list");
	System.out.println(printListWithCommas(testList));
	
	System.out.println("Test 8. Checking the size of the list - should have 10 elements");
	System.out.println(testList.size()==10? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 9. Checking the list is not empty");
	System.out.println(testList.isEmpty()!=true? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 10. Checking there is no error, ie. that an item retrieved is a valid ReturnObject");
	System.out.println(testRO.hasError()==false? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 11. Returns a valid ReturnObject which is not null when ReturnValue is called");
	System.out.println(testRO.getReturnValue()!=null? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 12. Calling get(-2) should return error INDEX_OUT_OF_BOUNDS");
	System.out.println(testRO.getError() + " should be INDEX_OUT_OF_BOUNDS");
	
	System.out.println("Test 13. Can return the element of the list at index 0 by calling get(0)");
	System.out.println(testRO.getReturnValue());
	
	System.out.println("Test 14. Can return the element of the list at index 1 by calling get(1)");
	System.out.println(testRO1.getReturnValue());
	
	System.out.println("Test 15. Can return the element of the list at index 3 by calling get(3)");
	System.out.println(testRO3.getReturnValue());
	
	System.out.println("Test 16. Can return the element of the list at index 9 by calling get(9)");
	System.out.println(testRO9.getReturnValue());

	/**
	 * @Test - check that objects can be added to the list at specific indices
	 */
	
	String object10 = "Merry Christmas";
	String object11 = "and a happy New Year";
	int object12 = 12;
	double object13 = 13.333;
	boolean object14 = true;
	String object15 = "I am a list, a very long list";
	
	System.out.println("Test 17. Add object 10 at position zero");
	testList.add(0,object10);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 'Merry Christmas' at index 0 of the list");
	System.out.println(testList.get(0).getReturnValue().toString());

	System.out.println("Test 18. Add object 13 at position 4");
	testList.add(4,object13);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 13.300 at index 4 of the list");
	System.out.println(testList.get(4).getReturnValue().toString());
	
	System.out.println("Test 19. Add object 15 at position 15");
	testList.add(15,object15);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 'I am a list, a very long list' at index 14 which should be the end of the list");
	System.out.println(testList.get(14).getReturnValue().toString());
	
	
	} // end of psvm
	
	
	public static String printList(List testList) { 
		if (testList.isEmpty()) {
			return "The list is empty";
		} else {
			String s = "";
			for (int i=0; i <= testList.size()-1; i++) {
				s = s + ("Element " + i + " is: " + testList.get(i).getReturnValue().toString() +"\n");
			}
			return s;
		}
	}
	
	public static String printListWithCommas(List testList) { 
		if (testList.isEmpty()) {
			return "The list is empty";
		} else {
			String s = "";
			for (int i=0; i <= testList.size()-1; i++) {
				if (i == testList.size()-1) {
					s = s + (testList.get(i).getReturnValue().toString() +"");
				} else { 
					s = s + (testList.get(i).getReturnValue().toString() +", ");
				}
			}
			return s;
		}
	}
	
	
	
} // end of class


