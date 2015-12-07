/**
* This file contains an implementation of interface List, described in file List.java
* @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
*
* all the text below here was copied from the List.java file to remind myself what I need to implement
* All the script file will need to see is the List.java file
* List.java is is the interface of LinkedList.java. LinkedList.java is the implementation of List.java
*/

public class LinkedList implements List {


		/**
	 	* @return true if the list is empty, false otherwise. 
	 	*/
		public boolean isEmpty();

		/**
	 	* @return the number of items currently in the list
	 	*/
		public int size();

	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index);

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index);

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(int index, Object item);

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item);
	
	private Object objectListStart ;
	
	public LinkedList (Person headPerson) { // constructor method PersonQueueImpl
		this.headPerson = headPerson; 
	}

	public void insert (Person anotherPerson) { // iterative method insert, inserts anotherPerson at the back of the queue
		if (headPerson == null) {
			headPerson = anotherPerson;
		} else if (headPerson.getNextPerson() == null) { 
			headPerson.setNextPerson(anotherPerson); 
		} else {
			// set the pointer of anotherPerson
			headPerson.setNextPerson(anotherPerson);  // link personHead to the nextPerson field of anotherPerson
			anotherPerson.setNextPerson(anotherPerson.getNextPerson()); //link the nextPerson field of anotherPerson to the nextPerson of the one behind, another anotherPerson
		}
		System.out.println("The person " + anotherPerson.getName() + "was added to the queue");
	}
}
