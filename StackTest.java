/**
 * StackTest.java is a class which tests interface Stack (implemented through Abstract Stack and StackImpl)
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 */

public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * @Test check the stack constructs when the underlying list is null, 
		 */
		Stack nullStack = new StackImpl(null);
		
		System.out.println("Test 1. Checking the stack is empty");
		System.out.println(nullStack.isEmpty()==true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 2. Checking the stack has size zero");
		System.out.println(nullStack.size()==0? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 3. Checking that a null stack returns EMPTY_STRUCTURE when top() is called");
		System.out.println(nullStack.top().getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 4. Checking that a null stack returns null when top().getReturnValue() is called");
		System.out.println(nullStack.top().getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 5. Checking that a null stack returns EMPTY_STRUCTURE when pop() is called");
		System.out.println(nullStack.pop().getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 6. Checking that a null stack returns null when pop().getReturnValue() is called");
		System.out.println(nullStack.pop().getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 7. Checking what happens to a null stack when push() is called");
		nullStack.push("oops");
		System.out.println("*****That line computed ok, but maybe should  return some kind of error?****");

			
		List emptyList = new ArrayList();
		
		Stack emptyStack = new StackImpl(emptyList);
		
		System.out.println("Test 8. Checking the stack is empty");
		System.out.println(emptyStack.isEmpty()==true? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 9. Checking the stack has size zero");
		System.out.println(emptyStack.size()==0? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 10. Checking that an empty stack returns EMPTY_STRUCTURE when top() is called");
		System.out.println(emptyStack.top().getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 11. Checking that an empty stack returns null when top().getReturnValue is called");
		System.out.println(emptyStack.top().getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 12. Checking that an empty stack returns EMPTY_STRUCTURE when pop() is called");
		System.out.println(emptyStack.pop().getError()==ErrorMessage.EMPTY_STRUCTURE? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 13. Checking that an empty stack returns null when pop().getReturnValue is called");
		System.out.println(emptyStack.pop().getReturnValue()==null? "Everything is working correctly" : "There is a problem");
		
		System.out.println("Test 14. Checking we can add to an empty Stack when push() is called");
		emptyStack.push("A very happy New Year");
		System.out.println("Everything is working correctly");
		System.out.println("The item added to the stack was " + emptyStack.top().getReturnValue().toString());
		
		System.out.println("Test 15. Checking nothing is added to the stack when push(null) is called");
		emptyStack.push(null);
		System.out.println("Everything is working correctly");
		System.out.println("The item on the top of the stack is " + emptyStack.top().getReturnValue().toString());
		
		// NB. we can do emptyList.add(null).getError here, but not emptyStack.push(null).getError(), because push() returns void
		
		List testList = new ArrayList();
		
		Stack testStack = new StackImpl(testList);
	
		int itemsToBePushed = 300000;
		System.out.println("Test 16. Pushing " +itemsToBePushed + " items to the stack: ");
		int k = 0;
		for (k=0; k< itemsToBePushed; k++) {
			testStack.push(k);
		}
		System.out.println("Finished adding items to the stack");
	
		System.out.println("Test 17. The item on the top of the stack is " + testStack.top().getReturnValue().toString());
		System.out.println("Test 18. The size of the stack is now " + testStack.size());
		
		int itemsToBePopped = 25000;
		System.out.println("Test 19. Popping " +itemsToBePopped + " items from the stack: ");
		int m = 0;
		for (m=0; m< itemsToBePopped; m++) {
			testStack.pop();
		}
		System.out.println("Finished popping items from the stack");
		
		System.out.println("Test 20. The item on the top of the stack is " + testStack.top().getReturnValue().toString());
		System.out.println("Test 21. The size of the stack is now " + testStack.size());
		
		System.out.println("END OF TEST");
		
	
	}
}
