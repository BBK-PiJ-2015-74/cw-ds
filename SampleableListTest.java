/**
 * Test file for interface SampleableList
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 * @see SampleableListImpl.java - implementation of interface
 * @see SampleableList.java - interface
 * @see LinkedList.java - interface
 * @see List.java - interface
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
		
		SampleableList listToBeSampled = new SampleableListImpl();
		
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
		
		listToBeSampled.add(object0);
		listToBeSampled.add(object1);
		listToBeSampled.add(object2);
		listToBeSampled.add(object3);
		listToBeSampled.add(object4);
		listToBeSampled.add(object5);
		listToBeSampled.add(object6);
		listToBeSampled.add(object7);
		listToBeSampled.add(object8);
		listToBeSampled.add(object9);

		System.out.println("Test 8. Checking we can print the orginal sampleable list, i.e. to be sampled");
		System.out.println(printList(listToBeSampled));
		System.out.println("The size of the list is " + listToBeSampled.size() + "\n");
		
		/**
		 * @Test - return the sampled list
		 */
		System.out.println("Test 9. Checking the sampled list is returned when sample() is called");
		System.out.println(printList(listToBeSampled.sample()));
	
		
		SampleableList anotherlistToBeSampled = new SampleableListImpl();
		
		anotherlistToBeSampled.add("zero");
		anotherlistToBeSampled.add("one");
		anotherlistToBeSampled.add("two");
		anotherlistToBeSampled.add("three");
		anotherlistToBeSampled.add("four");
		anotherlistToBeSampled.add("five");
		anotherlistToBeSampled.add("six");
		anotherlistToBeSampled.add("seven");
		anotherlistToBeSampled.add("eight");
		anotherlistToBeSampled.add("nine");
		anotherlistToBeSampled.add("ten");
		anotherlistToBeSampled.add("eleven");
		anotherlistToBeSampled.add("twelve");
		anotherlistToBeSampled.add("thirteen");
		anotherlistToBeSampled.add("fourteen");
		anotherlistToBeSampled.add("fifteen");
		
		System.out.println("Test 10. Checking we can print the orginal sampleable list, i.e. to be sampled");
		System.out.println(printList(anotherlistToBeSampled));
		System.out.println("The size of the list is " + anotherlistToBeSampled.size() + "\n");
		
		/**
		 * @Test - return the sampled list
		 */
		System.out.println("Test 11. Checking the sampled list is returned when sample() is called");
		System.out.println(printList(anotherlistToBeSampled.sample()));
	
	} 

	public static String printList(SampleableList listToBeSampled) { 
		if (listToBeSampled.isEmpty()) {
			return "The list is empty";
		} else {
			String s = "";
			for (int i=0; i <= listToBeSampled.size()-1; i++) {
				s = s + ("Element " + i + " is: " + listToBeSampled.get(i).getReturnValue().toString() +"\n");
			}
			return s;
		}
	}
} 

