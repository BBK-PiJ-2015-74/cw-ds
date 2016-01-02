/**
 * ImprovedStackTest.java is a class which tests interfaces ImprovedStack (an extension of Stack) and Stack
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 * 
 */

public class ImprovedStackTest {

	public static void main(String[] args) {

		
		List emptyList = new ArrayList();
		
		ImprovedStack emptyImprovedStack = new ImprovedStackImpl(emptyList);
		
		System.out.println("Test 1. Checking the stack is empty");
		System.out.println(emptyImprovedStack.isEmpty()==true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 2. Checking the stack has size zero");
		System.out.println(emptyImprovedStack.size()==0? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 3. Checking that an empty stack returns EMPTY_STRUCTURE when top() is called");
		System.out.println(emptyImprovedStack.top().getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 4. Checking that an empty stack returns null when top().getReturnValue is called");
		System.out.println(emptyImprovedStack.top().getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 5. Checking that an empty stack returns EMPTY_STRUCTURE when pop() is called");
		System.out.println(emptyImprovedStack.pop().getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 6. Checking that an empty stack returns null when pop().getReturnValue is called");
		System.out.println(emptyImprovedStack.pop().getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 7. Checking we can add to an empty Stack when push() is called");
		emptyImprovedStack.push("A very happy New Year");
		System.out.println("Everything is working correctly");
		System.out.println("The item added to the stack was " + emptyImprovedStack.top().getReturnValue().toString());
		
		System.out.println("Test 8. Checking nothing is added to the stack when push(null) is called");
		emptyImprovedStack.push(null);
		System.out.println("Everything is working correctly");
		System.out.println("The item on the top of the stack is " + emptyImprovedStack.top().getReturnValue().toString());
	
		
		List testList = new ArrayList();
		
		ImprovedStack testStack = new ImprovedStackImpl(testList);
	
		int itemsToBePushed = 100;
		System.out.println("Test 9. Pushing " +itemsToBePushed + " items to the stack: ");
		int k = 0;
		for (k=0; k< itemsToBePushed; k++) {
			testStack.push(k);
		}
		System.out.println("Finished adding items to the stack");
		System.out.println("Test 10. The item on the top of the stack is " + testStack.top().getReturnValue().toString());
		System.out.println("Test 11. The size of the stack is now " + testStack.size());
		
		int itemsToBePopped = 99;
		System.out.println("Test 12. Popping " +itemsToBePopped + " items from the stack: ");
		int m = 0;
		for (m=0; m< itemsToBePopped; m++) {
			testStack.pop();
		}
		System.out.println("Finished popping items from the stack");
		System.out.println("Test 13. The item on the top of the stack is " + testStack.top().getReturnValue().toString());
		System.out.println("Test 14. The size of the stack is now " + testStack.size());

		
		/**
		 * Testing reverse() and remove()
		 */
		
		System.out.println("Test 15. Creating a new stack and testing reverse()");
				
		List anotherList = new ArrayList();
		ImprovedStack anotherStack = new ImprovedStackImpl(anotherList);
		
		String object0 = "I am the BOTTOM of the stack";
		double object1 = -1000.876;
		double object2 = 3.142;
		String object3 = "This is a test";
		char object4 = 'c';
		double object5 = 99.99999;
		long object6 = (long) Math.pow(10, 15);
		boolean object7 = false;
		String object8 = "Christmas is coming and the goose is getting fat";
		String object9 = "I am the TOP of the stack";
		
		anotherStack.push(object0);
		anotherStack.push(object1);
		anotherStack.push(object2);
		anotherStack.push(object3);
		anotherStack.push(object4);
		anotherStack.push(object5);
		anotherStack.push(object6);
		anotherStack.push(object7);
		anotherStack.push(object8);
		anotherStack.push(object9);
		
		System.out.println("The top of the stack is " + anotherStack.top().getReturnValue().toString());
		System.out.println("The size of the stack is " + anotherStack.size());

		System.out.println("Reversing the stack");
		ImprovedStack reversedStack = anotherStack.reverse();
		System.out.println("The top of the reversed stack is now " + reversedStack.top().getReturnValue().toString());
		System.out.println("Popping the top off the reversed stack");
		
		reversedStack.pop();
		System.out.println("The top of the stack should be now -1000.876 and is " + reversedStack.top().getReturnValue().toString() + "\n");
		
		
		System.out.println("Pushing the same objects onto the test stack a second time");
		anotherStack.push(object0);
		anotherStack.push(object1);
		anotherStack.push(object2);
		anotherStack.push(object3);
		anotherStack.push(object4);
		anotherStack.push(object5);
		anotherStack.push(object6);
		anotherStack.push(object7);
		anotherStack.push(object8);
		anotherStack.push(object9);
		System.out.println("The size of the stack is now " + anotherStack.size());
		
		System.out.println("Removing some duplicate objects from the test stack");
		System.out.println("Removing object 2 which is 3.142 from the stack");
		anotherStack.remove(object2);
		System.out.println("The size of the stack is " + anotherStack.size());
		System.out.println("The top of the stack is " + anotherStack.top().getReturnValue().toString() + "\n");
		
		
		System.out.println("Removing 'Christmas is coming and the goose is getting fat' from the stack");
		anotherStack.remove(object8);
		System.out.println("The top of the stack is " + anotherStack.top().getReturnValue().toString());
		System.out.println("The size of the stack is " + anotherStack.size() + "\n");
		
		System.out.println("Removing 99.9999 from the stack");
		anotherStack.remove(object5);
		System.out.println("The top of the stack is " + anotherStack.top().getReturnValue().toString());
		System.out.println("The size of the stack is " + anotherStack.size() + "\n");
		
		System.out.println("Removing I am the TOP of the stack, object 9 from the stack");
		anotherStack.remove(object9);
		System.out.println("The top of the stack is " + anotherStack.top().getReturnValue().toString());
		System.out.println("The size of the stack is " + anotherStack.size() + "\n");
		
		
		System.out.println("END OF TEST");
		
	
	} // end of psvm
	
} // end of class
