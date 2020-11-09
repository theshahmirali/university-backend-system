# Markdown for Week 4 Tasks 4 (i)

In the mark class I added two private variables the marks and the comments.
Next I had a setter, a getter for comments and marks. For marks the setter
raises an exception for marks being in the range 0 to 100.

Next in the Assessment class, I created a method and in that method we can
easily add marks and comments using the setters. The studentID and mark are 
stored inside a HashMap where studentId is the key and Mark object is the value.

For the case where the comments not being passed a method override is written.
The setters and getters for marks and comments are created as well when a 
Student ID is being passed. Moreover, there is a method to return new HashMap
containing the studentIDs and mark objects