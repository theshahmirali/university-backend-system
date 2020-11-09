import java.util.HashSet;

/**
 * Implements Units.
 * @author shahmirali
 */
public class Unit {

    private String unitCode;
    private String unitTitle;

    private HashSet<Integer> enrolledStudents = new HashSet<>();

    private AssessmentScheme allAssessments = new AssessmentScheme();

    /**
     * Constructor
     */
    public Unit(String unitCode, String unitTitle) {
        this.unitCode = unitCode;
        this.unitTitle = unitTitle;
    }

    /**
     * Method to enrol students without duplication
     */
    public void enrolStudent(int studentId, University enrolled) {
        if(enrolled.getDetails().containsKey(studentId)) {
            enrolledStudents.add(studentId);
        } else {
            System.out.println("This student does not exist, Please enrol: " + studentId);
        }
    }

    /**
     * Invokes the complete method when all assessments are complete
     */
    public void complete() throws Exception { allAssessments.complete(); }

    /**
     * Invokes the addAssessment method when adding new assessments
     */
    public void addAssessment(Assessment anAssessment){
        allAssessments.addAssessment(anAssessment); }

    /**
     * Checks if the student has completed assessments
     */
    public boolean completedAll(int studentID){
        for (Assessment temp : allAssessments.getAssessment()) {
            try {
                temp.getStudentMarks(studentID);
            }
            catch (NullPointerException e) {
                System.out.println("Student " + studentID + " has not completed all assessments");
            }
        }
        return true;
    }

    /**
     * Gets the student total for an assessment
     * @return the total of the students assessment
     */
    public double getStudentTotal(int studentID){
        double total = 0.0;
        for (Assessment temp : allAssessments.getAssessment()) {
            if (this.completedAll(studentID)){
                double one = temp.getWeight()/100.00 * temp.getStudentMarks(studentID);
                total += one;
            }
        }
        return total;
    }

    /**
     * returns a HashSet of enrolled students
     * @return the Hashset of enrolled students
     */
    public HashSet<Integer> getEnrolledStudents(){
        return new HashSet<>(enrolledStudents);
    }

    /**
     * Method to get unit descriptions units.
     */
    public void description() { System.out.println(unitCode + " " + unitTitle); }

}
