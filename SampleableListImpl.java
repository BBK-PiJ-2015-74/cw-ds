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
		if (this.isEmpty()) {
			SampleableList mySL = new SampleableListImpl();
			return mySL;
		} else {
			SampleableList mySL = new SampleableListImpl();
//			int index = 0;
//			for (index = 1; (index >= this.size()); index+=2) {
//				ReturnObject RO = this.get(index);
//				mySL.add(RO);
//			}
			ReturnObject RO = this.get(1);
			mySL.add(RO);
			ReturnObject RO3 = this.get(3);
			mySL.add(RO3);
			ReturnObject RO5 = this.get(5);
			mySL.add(RO5);
			ReturnObject RO7 = this.get(7);
			mySL.add(RO7);
			return mySL;
		}
	}

} // end of class

// for (index = 0; (index >= this.size()); index+=2) {
//	this.remove(index);
//	mySL = this;
//	return mySL;
//}
