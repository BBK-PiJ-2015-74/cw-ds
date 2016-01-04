/**
 * Implementation of interface SampleableList
 * @author Lburge01 BBK-PiJ-2015-74 (Lucie Burgess)
 * @see SampleableList.java
 * @see LinkedList.java
 * @see List.java
 */


public class SampleableListImpl extends LinkedList implements SampleableList {

	/**
	 * @see SampleableList#sample()
	 * @return a list containing the first, third, fifth... items of this list, or an empty list if the list is empty
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

} 

// the following code also works with removing elements 0, 1, 2, 3, 4 ... in succession from the original list (the indices are updated as the loop progresses)
// hence it doesn't remove them all, but in fact just elements 1,3,5,7 ... from the original list
// but changes the original list. In this question it's not stated whether or not it matters if the underlying list changes
// from line 21:
// } else {
// 		for (int index = 0; index < this.size(); index++) {
// 			FunctionalList myFL = new FunctionalLinkedList();
//			this.remove(index);
//			myFL = this;
//			return myFL;
// 		}
// }
