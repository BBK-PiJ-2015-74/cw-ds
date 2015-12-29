/**
 * Test file for interface SampleableList
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * @See#SampleableListImpl.java - implementation of interface
 * @See#SampleableList.java - interface
 * @See#LinkedList.java - interface
 * @See#List.java - interface
 */

public class SampleableListTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * @Test - check the list is empty, that it has zero size, returns EMPTY_STRUCTURE when get() is called
		 */
		SampleableList emptySL = new SampleableListImpl();
		
		System.out.println("Test 1. Checking the sampleable list is empty");
		System.out.println(emptySL.isEmpty()==true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 2. Checking the sampleable list has size zero");
		System.out.println(emptySL.size()==0? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 3. Checking it returns EMPTY_STRUCTURE when get(0) is called on the empty sampleable list");
		System.out.println(emptySL.get(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 4. Checking it returns null when get(0) is called on the empty sampleable list");
		System.out.println(emptySL.get(0).getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		/**
		 * @Test - check that objects can be added to the list
		 */
		
		SampleableList testSL = new SampleableListImpl();
		
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
		
		testSL.add(object0);
		testSL.add(object1);
		testSL.add(object2);
		testSL.add(object3);
		testSL.add(object4);
		testSL.add(object5);
		testSL.add(object6);
		testSL.add(object7);
		testSL.add(object8);
		testSL.add(object9);

		System.out.println("Test 8. Checking we can print the orginal sampleable list, i.e. to be sampled");
		System.out.println(printList(testSL));
		System.out.println("The size of the list is " + testSL.size() + "\n");
		
		/**
		 * @Test - return the sampled list
		 */
		System.out.println("Test 9. Checking the sampled list is returned when sample() is called");
		System.out.println(printList(testSL.sample()));


	} // end of psvm

	public static String printList(SampleableList testSL) { 
		if (testSL.isEmpty()) {
			return "The list is empty";
		} else {
			String s = "";
			for (int i=0; i <= testSL.size()-1; i++) {
				s = s + ("Element " + i + " is: " + testSL.get(i).getReturnValue().toString() +"\n");
			}
			return s;
		}
	}
	
	
} // end of class

