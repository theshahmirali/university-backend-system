/**
 * Implements an Exam which inherits from the Assessment class.
 * @author shahmirali
 */
public class Exam extends Assessment {

    private int duration;

    /**
     * A constructor that creates an Exam with duration and weight, where duration is between 30 and 180
     * @throws Exception for when the duration of exam entered is less than 30 or greater than 180
     */
    public Exam(int weight, int duration) throws Exception {
        if (duration < 30){
            throw new Exception ("Exam duration is too short");
        }
        else if (duration > 180){
            throw new Exception ("Exam duration is too long");
        }
        this.setWeight(weight);
        this.duration = duration;
    }

    /**
     * return a string with weight and duration
     * @return string format with duration and weight
     */
    @Override
    public String description() { return String.format("Exam: duration %s minutes, weight %s%%", this.duration, this.getWeight()); }
}
