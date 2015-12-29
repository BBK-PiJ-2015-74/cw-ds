/**
 * Test file for interface FunctionalList
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * @See#FunctionalLinkedList.java - implementation of interface
 * @See#FunctionalList.java - interface
 * @See#List.java - interface
 */

public class FunctionalListTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * @Test - check the list is empty, that it has zero size, returns EMPTY_STRUCTURE when get() is called
		 */
		FunctionalList emptyFL = new FunctionalLinkedList();
		
		System.out.println("Test 1. Checking the functional list is empty");
		System.out.println(emptyFL.isEmpty()==true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 2. Checking the functional list has size zero");
		System.out.println(emptyFL.size()==0? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 3. Checking it returns EMPTY_STRUCTURE when get(0) is called on the empty functional list");
		System.out.println(emptyFL.get(0).getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 4. Checking it returns null when get(0) is called on the empty functional list");
		System.out.println(emptyFL.get(0).getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		/**
		 * @Test - check that EMPTY_STRUCTURE is returned when we call head()
		 */
		System.out.println("Test 5. Checking error message EMPTY_STRUCTURE is returned when head() is called on the empty functional list");
		System.out.println(emptyFL.head().getError() == ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		/**
		 * @Test - check that an empty list is returned when we call rest() on an empty list
		 */
		System.out.println("Test 6. Check that an empty list is returned when rest() is called on the empty functional list");
		System.out.println(emptyFL.rest().isEmpty() ? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 7. Check that the size of the returned list is zero when rest() is called on the empty list");
		System.out.println(emptyFL.rest().size() == 0 ? "Everything is working correctly" : "There is a problem");
		
		/**
		 * @Test - check that objects can be added to the list
		 */
		
		FunctionalList originalFL = new FunctionalLinkedList();
		
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
		
		originalFL.add(object0);
		originalFL.add(object1);
		originalFL.add(object2);
		originalFL.add(object3);
		originalFL.add(object4);
		originalFL.add(object5);
		originalFL.add(object6);
		originalFL.add(object7);
		originalFL.add(object8);
		originalFL.add(object9);
		int sizeOfOriginalList = originalFL.size();

		System.out.println("Test 8. Checking we can print the full functional list with all " + sizeOfOriginalList + " elements");
		System.out.println(printList(originalFL));
		System.out.println("The size of the list is " + originalFL.size() + "\n");
	
		FunctionalList inputFL = new FunctionalLinkedList();	
		inputFL = originalFL;
		FunctionalList outputFL = new FunctionalLinkedList();
		
		for (int count = 0; count <= sizeOfOriginalList; count++) { 

			int testnumber = 9;
			System.out.println("*************Test " + (testnumber+count) + "****************" +"\n");
			
			System.out.println("Checking the head of the list is returned when head() is called");
			System.out.println(inputFL.head().getReturnValue());
			System.out.println("Checking the appropriate error message or NO_ERROR is returned");
			System.out.println(inputFL.head().getError());
			System.out.println("Checking the list is returned without the first element when rest() is called");
			outputFL = inputFL.rest();
			System.out.println(printList(outputFL));
			System.out.println("The size of the output list is now " + outputFL.size());
			System.out.println("The size of the original list is still " + originalFL.size()+ "\n");
			inputFL = outputFL;	
		}
	
		System.out.println("To prove the original list is still unchanged, here it is:");
		System.out.println(printList(originalFL));

	} // end of psvm

	public static String printList(FunctionalList testFL) { 
		if (testFL.isEmpty()) {
			return "The list is empty";
		} else {
			String s = "";
			for (int i=0; i <= testFL.size()-1; i++) {
				s = s + ("Element " + i + " is: " + testFL.get(i).getReturnValue().toString() +"\n");
			}
			return s;
		}
	}
	
	
} // end of class
