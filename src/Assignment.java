/**
 * Implements Assignments.
 * @author shahmirali
 */
public class Assignment extends Assessment {

    private String title;

    /** A constructor that creates an Assignment with title and weight
     * @throws Exception weight will be integer between 1 and 100
     */
    public Assignment(String title, int weight) throws Exception {
        this.title = title;
        this.setWeight(weight);
    }

    /**
     * return a string with title and weight
     * @return returns a string format of title and weight
     */
    @Override
    public String description() { return String.format("Assignment: %s, weight %s%%", this.title, this.getWeight()); }
}
