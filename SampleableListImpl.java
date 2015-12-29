/**
 * Implementation of interface SampleableList
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 * @See#SampleableList.java
 * @See#List.java
 */


public class SampleableListImpl extends LinkedList implements SampleableList {

	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	@Override
	public SampleableList sample() {
		
		SampleableList mySL = new SampleableListImpl();
		if (this.isEmpty()) {	
			return mySL;
		} else {
			int index = 0;
			for (index = 1; (index < this.size()); index+=2) {
				Object obj = this.get(index).getReturnValue();
				mySL.add(obj);
			}
			return mySL;
		}
	}

} // end of class

// the following code also works with removing elements 0, 1, 2, 3, 4 ... in succession from the original list (the indices are updated as the loop progresses)
// hence it doesn't remove them all, but in fact just elements 1,3,5,7 ... from the original list
// but changes the original list. In this question it's not stated whether or not it matters if the underlying list changes
// from line 23 in the else statement:
// } else {
// 		for (int index = 0; (index < this.size(); index++) {
// 			FunctionalList myFL = new FunctionalLinkedList();
//			this.remove(index);
//			myFL = this;
//			return myFL;
// 		}
// }
