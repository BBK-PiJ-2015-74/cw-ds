# cw-ds

This is the repository for Assignment 2 coursework for the Birkbeck Programming in Java course 
Created in week 10 of the course 3 December 2015
@author Lburge01 BBK-PiJ-2015-74


Files provided in the src-repo directory, already included as part of the coursework:
ReturnObject.java - interface, implemented through ReturnObjectImpl
ErrorMessage.java - Enum file containing specifications of Error Messages
List.java - interface, implemented through LinkedList.java and ArrayList.java
FunctionalList.java - interface which extends list - implemented through FunctionalLinkedList and FunctionalArrayList
SampleableList.java - interface for Sameplable list, implemented through SampleableListImpl.java
Stack.java - interface for stack
AbstractStack.java - abstract class which implements interface Stack
ImprovedStack.java - interface for Stack which extends Stack


Files I have created 
Ex 1. ReturnObjectImpl.java is a class that implements interface ReturnObject, and is just a way of handling errors
@See ReturnObjectTest.java

Ex 2. ArrayList.java implements interface List using Arrays
@see ArrayListTest.java

Ex 3. LinkedList.java implements interface List using linked lists
@See LinkedListTest.java 
 
Ex 4. FunctionalArrayList implements interface FunctionalList and extendsArrayList
@See FunctionalListTest (this file can be easily modified to work for the linked list version)

Ex 5. FunctionalLinkedList implements interface FunctionalList and extendsLinkedList
The same file FunctionalListTest can be used with a small change of ArrayList in the test file to LinkedList.

Ex 6. SampleableListImpl is an implementation of the interface SampleableList using linked list as a base.
@See SampleableListTest

Ex 7. StackImpl extends class AbstrackStrack (which implements interface Stack) using ArrayList as a base.
@See StackTest

Ex 8. ImprovedStackImpl implements interface ImprovedStack
@See ImprovedStackTest




