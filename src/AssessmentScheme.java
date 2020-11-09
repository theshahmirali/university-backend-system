import java.util.ArrayList;

/**
 * Implements AssessmentsScheme.
 * @author shahmirali
 */
public class AssessmentScheme {

    private ArrayList<Assessment> allAssessments = new ArrayList<>();

    /**
     * a method to add an assessment
     */
    public void addAssessment(Assessment anAssessment) {
        allAssessments.add(anAssessment);
    }

    /**
     * a method to check whether an assessment is completed or not
     * @throws Exception when the weight is more than 100
     */
    public void complete() throws Exception {
        int total = 0;
        for(Assessment temp: allAssessments) {
            total += temp.getWeight();
        }

        if (total > 100){
            throw new Exception("The sum of weights must not exceed 100");
        }
        else if (total < 100){
            throw new Exception("The sum of weights is less than 100");
        }
    }

    /** returns an array list of all assessments
     * @return an arrayList of assessments
     */
    public ArrayList<Assessment> getAssessment() { return new ArrayList<>(allAssessments); }
}
