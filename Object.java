/**
 * Definition of class Object to go in the List (list of objects is in file List.java)
 * Objects are books and therefore the list will be my library
 * @author Lburge01 BBK-PiJ-2015-75 (Lucie Burgess)
 */
 
 // any comments with a double slash are to be deleted before handing in
 
 public class Object {	// can I just call this Book?
	private String title;
	private String author;
	private int yearpublished;	
	private boolean copyrightstatus;  
	private Object nextObject;
	
	/**
	* constructor method creates a new complex Object that represents a book
	* @param title - the title of the book
	* @param author - the lead author of the book
	* @param yearpublished - the year of publication in the form XXXX i.e. year AD
	* @param copyrightstatus is true if in copyright, false if public domain or CC-0 licensed
	* @param nextObject - a pointer to the next Object following Object in the list
	*/
	public Object (String title, String author, int yearpublished, boolean copyrightstatus) {
		this.title = title;
		this.author = author;
		this.yearpublished = yearpublished;
		this.copyrightstatus = copyrightstatus;
		this.nextObject = null;  
	}

	public Object getNextObject() {		 
		return nextObject;				
	}
	
	/**
	* @return sets the nextObject of the instance of Object to be anotherObject
	*/
	public void setNextObject(Object anotherObject) { 
        nextObject = anotherObject;
    }
	
	/**
	* @return returns the parameter "title" in the form of a string
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	* @return returns the parameter "author" in the form of a string
	*/
	public String getAuthor() {
		return author;
	}
	
	/**
	* @return returns the parameter "yearpublished" in the form of an integer - should be in the format XXXX
	*/
	public int getYearPublished() {
		return yearpublished;
	}
	
	/**
	* @return returns the parameter "copyrightstatus" in the form of a boolean - true if in copyright, false if out-of-copyright
	*/
	public boolean getCopyrightStatus() {
		return copyrightstatus;
	}
	
	public void addObject (Object newObject) { 
		if (this.nextObject == null) { 
			this.nextObject = newObject;
		} else {
			this.nextObject.addObject(newObject); 
		}
	}
	
	public void printYourselfAndWhoeverComesAfter() {
		String str = "";
		str = "Title: /t" + this.title + "Author: /t" + this.author + "Year published: /t" + this.yearpublished + "Copyright status: /t" + this.copyrightstatus + "/n" ; 
		System.out.println(str);
		if (this.nextObject != null) {
			this.nextObject.printYourselfAndWhoeverComesAfter();
		}
	}	
 }		// end of class Object
 
 