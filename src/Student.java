import java.util.ArrayList;

/**
 * Implements Students.
 * @author shahmirali
 */
public class Student {

    private int studentID;
    private String givenName;
    private String familyName;

    private ArrayList<Unit> enrolledUnits = new ArrayList<>();

    /**
     * Constructor
     * @throws Exception if student id is not equal to 8 digits
     */
    public Student(int newStudentId) throws Exception{
        String temp = String.valueOf(newStudentId);
        if (temp.length() != 8) {
            throw new Exception("StudentID must be 8 digits long");
        }
        this.studentID = newStudentId;
    }

    /**
     * Constructor
     * @throws Exception if student id is not equal to 8 digits
     */
    public Student(int newStudentId, String newGivenName, String newFamilyName) throws Exception {
        String temp = String.valueOf(newStudentId);
        if (temp.length() != 8 ^ temp.length() > 8) {
            throw new Exception("StudentID must be 8 digits long");
        }
        this.studentID = newStudentId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    /**
     * Setter to setGivenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * Setter to setFamilyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * Getter to getStudentId
     */
    public int getStudentId() { return studentID; }

    /**
     * Method to enrol students into a Unit
     */
    public void enrolIn(Unit aUnit){ enrolledUnits.add(aUnit); }

    /**
     * @return array of enrolled units
     */
    public ArrayList<Unit> getEnrolledUnits(){
        return new ArrayList<>(enrolledUnits);
    }

    /**
     * Method to get description of a Unit
     */
    public String description() { return studentID + " " + givenName + " " + familyName; }

}
