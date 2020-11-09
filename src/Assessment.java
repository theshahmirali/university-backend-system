import java.util.HashMap;

/**
 * Implements Assessments of a Unit which stores various attributes such as weight, title comments.
 * @author shahmirali
 */
public abstract class Assessment {

    private int weight;

    private HashMap<Integer, Mark> marksOfStudents = new HashMap<>();

    /**
     * Stores Student ID for a student. Storing comments are optional refer to the overload method.
     * The studentID and mark are stored inside a HashMap where studentId is the key and Mark object is the value.
     * The current unit os passed for the marks of that unit to be stored.
     * @param studentID each student is assigned a unique id
     * @param marks the marks which are recorded for a specific assessment
     * @param comments comments on the assessment
     * @param currentUnit the unit to which the assessment belongs to
     * @throws Exception when the marks of student input are less than 0 or greater than 100
     */
    public void addStudentMarks(int studentID, int marks, String comments, Unit currentUnit) throws Exception {
        if (currentUnit.getEnrolledStudents().contains(studentID)) {
            Mark studentMarks = new Mark();
            studentMarks.setMarks(marks);
            studentMarks.setComment(comments);
            marksOfStudents.put(studentID, studentMarks);
        }
        else {
            System.out.println("Student does not exist");
        }
    }

    // An overload method if there are no comments being added
    public void addStudentMarks(int studentID, int marks, Unit currentUnit) throws Exception {
        if (currentUnit.getEnrolledStudents().contains(studentID)) {
            addStudentMarks(studentID, marks, "no comments", currentUnit);
            Mark studentMarks = new Mark();
            studentMarks.setMarks(marks);
            studentMarks.setComment("no comment");
            marksOfStudents.put(studentID, studentMarks);
        }
        else {
            System.out.println("Student does not exist " + studentID);
        }
    }

    /**
     * returns a student's marks given the studentId
     * @return student marks given the studentId
     */
    public int getStudentMarks(int studentId){
        return marksOfStudents.get(studentId).getMarks();
    }

    /**
     * returns a student's comment for the assessment given the studentId
     * @return students comment for that Id
     */
    public String getStudentComments(int studentId){
        return marksOfStudents.get(studentId).getComment();
    }

    /** returns a new HashMap containing the studentIDs and mark objects
     * @return Hashmap containing studentID and mark objects
     */
    public HashMap<Integer, Mark> getMarksOfStudents(){ return new HashMap<>(marksOfStudents); }

    /** a setter for weight between 1 and 100
     * @throws Exception when weight is less than 1 and more than 100
     */
    public void setWeight(int weight) throws Exception {
        if (weight < 1 | weight > 100){
            throw new Exception("Incorrect weight entered");
        }
        this.weight = weight;
    }

    /**
     * a getter for weight
     */
    public int getWeight() { return weight; }

    /**
     * an abstract method which must return some details about the assessment
     */
    public abstract String description();
}
