/**
 * Implements Marks.
 * @author shahmirali
 */
public class Mark {

    private int marks;
    private String comment;

    /** a setter for marks between 1 and 100 */
    public void setMarks(int marks) throws Exception {
        if (marks < 0 | marks > 100){
            throw new Exception("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    /**
     * a getter for marks
     * @return marks
     */
    public int getMarks() { return marks; }

    /**
     * a setter for comments
     */
    public void setComment(String comment) { this.comment = comment; }

    /**
     * a getter for comments
     * @return comments
     */
    public String getComment() { return comment; }

}
