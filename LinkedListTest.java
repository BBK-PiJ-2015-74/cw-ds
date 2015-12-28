
/**
 * LinkedListTest is a test of interface list, in this case constructed to work with the LinkedList.java
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
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
	
	System.out.println("Test 3. Checking it returns EMPTY_STRUCTURE when get(0) is called");
	System.out.println(emptyList.get(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 4. Checking it returns null when get() is called");
	System.out.println(emptyList.get(0).getReturnValue()==null? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 5. Checking it returns EMPTY_STRUCTURE when remove() is called");
	System.out.println(emptyList.remove(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");

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

	System.out.println("Test 6. Checking we can print the list");
	System.out.println(printList(testList));
	
	System.out.println("Test 7. Checking we can print the list");
	System.out.println(printListWithCommas(testList));
	
	System.out.println("Test 8. Checking the size of the list - should have 10 elements");
	System.out.println(testList.size()==10? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 9. Checking the list is not empty");
	System.out.println(testList.isEmpty()!=true? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 10. Checking there is no error, ie. that an item retrieved is a valid ReturnObject");
	ReturnObject testRO = testList.get(0);
	System.out.println(testRO.hasError()==false? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 11. Returns a valid ReturnObject which is not null when ReturnValue is called");
	testRO = testList.get(0);
	System.out.println(testRO.getReturnValue()!=null? "Everything is working correctly" : "There is a problem");
	
	System.out.println("Test 12. Calling get(-2) should return error INDEX_OUT_OF_BOUNDS");
	testRO = testList.get(-2);
	System.out.println(testRO.getError() + " should be INDEX_OUT_OF_BOUNDS");
	
	System.out.println(printList(testList));
	
	System.out.println("Test 13. Can return the element of the list at index 0 by calling get(0)");
	testRO = testList.get(0);
	System.out.println(testRO.getReturnValue());
	
	System.out.println("Test 14. Can return the element of the list at index 1 by calling get(1)");
	testRO = testList.get(1);
	System.out.println(testRO.getReturnValue());
	
	System.out.println("Test 15. Can return the element of the list at index 3 by calling get(3)");
	testRO = testList.get(3);
	System.out.println(testRO.getReturnValue());
	
	System.out.println("Test 16. Can return the element of the list at index 9 by calling get(9)");
	testRO = testList.get(9);
	System.out.println(testRO.getReturnValue());

	/**
	 * @Test - check that objects can be added to the list at specific indices
	 */
	
	String object10 = "Merry Christmas";
	String object11 = "and a happy New Year";
	double object13 = 13.333;
	String object15 = "The rinky dink panther";
	
	System.out.println("Test 17. Add object 10 at position zero");
	testList.add(0,object10);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 'Merry Christmas' at index 0 of the list");
	System.out.println(testList.get(0).getReturnValue().toString());
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	System.out.println("Test 18. Add object 13 at position 4");
	testList.add(4,object13);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 13.300 at index 4 of the list");
	System.out.println(testList.get(4).getReturnValue().toString());
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	System.out.println("Test 19. Add object 15 at position 10");
	testList.add(10,object15);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 'The rinky dink panther' at index 10 of the list");
	System.out.println(testList.get(10).getReturnValue());
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	System.out.println("Test 20. Add object11 at the end of the list");
	testList.add(object11);
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	System.out.println(printList(testList));
	System.out.println("The last element in the list should be 'and a happy New Year' ");
	System.out.println(testList.get(testList.size()-1).getReturnValue() + "\n");
	
	/**
	 * @Test - test add (index, item) with errors
	 */
	
	/**
	 * Should return INDEX_OUT_OF_BOUNDS error
	 */
	testRO = testList.add(20, object15);
	System.out.println("Test 21. Expect INDEX_OUT_OF_BOUNDS error");
	System.out.println(testRO.hasError()==true ? testRO.getError() : testRO.getReturnValue());
	System.out.println("Test 22. The return value should be null: " + testRO.getReturnValue() + "\n");
	
	testRO = testList.add(-5, object15);
	System.out.println("Test 23. Expect INDEX_OUT_OF_BOUNDS error");
	System.out.println(testRO.hasError()==true ? testRO.getError() : testRO.getReturnValue());
	System.out.println("Test 24. The return value should be null: " + testRO.getReturnValue()+ "\n");
	
	/**
	 * Should return INVALID_ARGUMENT error
	 */
	testRO = testList.add(3, null);
	System.out.println("Test 25. Expect INVALID_ARGUMENT error");
	System.out.println(testRO.hasError()==true ? testRO.getError() : testRO.getReturnValue());
	System.out.println("Test 26. The return value should be null: " + testRO.getReturnValue()+ "\n");
	
	System.out.println(printList(testList));
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	/**
	 * @Test - test remove (index) without errors
	 */
	System.out.println("Test 27. Removing object at position zero");
	testList.remove(0);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return '1' at index 0 of the list");
	System.out.println(testList.get(0).getReturnValue());
	System.out.println("The size of the list is now " + testList.size()+ "\n");

	System.out.println("Test 28. Removing object at position 4");
	testList.remove(4);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 'c' at index 4 of the list");
	System.out.println(testList.get(4).getReturnValue());
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	System.out.println("Test 29. Removing object at position 7");
	testList.remove(7);
	System.out.println(printListWithCommas(testList));
	System.out.println("This test should return 'The rinky dink panther' at index 7 of the list");
	System.out.println(testList.get(7).getReturnValue());
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	System.out.println(printListWithCommas(testList));
	System.out.println("Test 30. Removing the final object in the list");
	testList.remove(testList.size()-1);
	System.out.println("This test should return '-25' at the end of the list");
	System.out.println(testList.get((testList.size()-1)).getReturnValue());
	System.out.println("The size of the list is now " + testList.size()+ "\n");
	
	System.out.println("Test 31. Checking the error message is NO_ERROR");
	System.out.println(testList.get((testList.size()-1)).getError() + "\n");
	
	/**
	 * @Test - test remove (index) with errors
	 * Expect INDEX_OUT_OF_BOUNDS error
	 */
	
	System.out.println("Test 32. Removing object at index > size of list. Expect INDEX_OUT_OF_BOUNDS error");
	testRO = testList.remove(testList.size()+3);
	System.out.println(testRO.hasError()==true ? testRO.getError() : testRO.getReturnValue());
	System.out.println("Test 33. The return value should be null: " + testRO.getReturnValue()+ "\n");
	
	
	System.out.println("Test 34. Removing object at index < 0. Expect INDEX_OUT_OF_BOUNDS error");
	testRO = testList.remove(-3);
	System.out.println(testRO.hasError()==true ? testRO.getError() : testRO.getReturnValue());
	System.out.println("Test 35. The return value should be null: " + testRO.getReturnValue()+ "\n");
	
	
	
	
	
	
	} // end of psvm
	
	/**
	 * These methods are used to print the list
	 * @return the list
	 * @param the list to be printed
	 */
	
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


