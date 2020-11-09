import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implements University the main class.
 * @author shahmirali
 */
public class University {

    ArrayList<Unit> unitsArray = new ArrayList<>();
    private HashMap<Integer, Student> students = new HashMap<>();
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * HashMap to get student details.
     * @return HAsmap of students
     */
    public HashMap<Integer, Student> getDetails(){
        return new HashMap<>(this.students);
    }

    /**
     * @return array of courses
     */
    public ArrayList<Course> getCourses(){
        return new ArrayList<>(courses);
    }

    /**
     * Method to add students.
     */
    public void admitStudent(Student freshman) { students.put(freshman.getStudentId(), freshman); }

    /**
     * Method to create units and add students.
     */
    public void createUnits() throws Exception {

        /*
        // Create student objects to add in units

        Student studentFirst;
        String admit = readString("Do you want to add Students (yes/no)? : ");

        while (admit.equals("yes")) {
            studentFirst = new Student(Integer.parseInt(readString("Enter the Student ID: ")),
                    readString("Enter the Given Name: "), readString("Enter the Family Name: "));

            students.put(studentFirst.getStudentId(), studentFirst);
            unitOne.enrolStudent(studentFirst.getStudentId(), this);
            unitTwo.enrolStudent(studentFirst.getStudentId(), this);
            unitThree.enrolStudent(studentFirst.getStudentId(), this);
            studentFirst.enrolIn(unitOne);
            studentFirst.enrolIn(unitTwo);
            studentFirst.enrolIn(unitThree);

            admit = readString("Do you want to add more Students (yes/no)? : ");
            System.out.println("\n");

        }
        */

        // Create Unit objects
        Unit unitOne = new Unit("FIT2099","Objected Oriented Design");
        Unit unitTwo = new Unit("FIT3179","Data Visualisation");
        Unit unitThree = new Unit("FIT3143","Parallel Computing");

        // Add units to the unit array
        unitsArray.add(unitOne);
        unitsArray.add(unitTwo);
        unitsArray.add(unitThree);

        // Create Courses
        Course compSci = new Course("Computer Science", 1);
        compSci.addCoreUnits(unitOne);
        compSci.addCoreUnits(unitTwo);
        compSci.addElectiveUnits(unitThree);

        Course software = new Course("Software Engineering", 2);
        software.addCoreUnits(unitOne);
        software.addElectiveUnits(unitTwo);
        software.addElectiveUnits(unitThree);

        // Add Courses
        courses.add(compSci);
        courses.add(software);

        // Create Student objects
        Student studentFirst = new Student(12345678, "Victor", "Chang");
        Student studentSecond = new Student(12345679, "Fred", "Nurke");
        Student studentThird = new Student(12345680, "Indira", "Naidu");

        //Enrol the students in University
        this.admitStudent(studentFirst);
        this.admitStudent(studentSecond);
        this.admitStudent(studentThird);

        //Enrol students to Units, then for each student update the units
        unitOne.enrolStudent(studentFirst.getStudentId(), this);
        studentFirst.enrolIn(unitOne);

        unitOne.enrolStudent(studentSecond.getStudentId(), this);
        studentSecond.enrolIn(unitOne);

        unitTwo.enrolStudent(studentThird.getStudentId(), this);
        studentThird.enrolIn(unitTwo);

        unitThree.enrolStudent(studentSecond.getStudentId(), this);
        studentSecond.enrolIn(unitThree);

        //Create an exam and assignment
        Exam ood = new Exam(40, 90);
        Assignment a1 = new Assignment("Grand Project", 60);

        //Add the assessments and mark them complete
        unitOne.addAssessment(ood);
        unitOne.addAssessment(a1);
        unitOne.complete();

        // Adding marks and comments to exam
        ood.addStudentMarks(studentFirst.getStudentId(),80,"Nice Work", unitOne);
        ood.addStudentMarks(studentSecond.getStudentId(), 75, "Satisfactory", unitOne);

        // Adding marks and comments to assignments
        a1.addStudentMarks(studentFirst.getStudentId(),50,"Excellent", unitOne);
        a1.addStudentMarks(studentSecond.getStudentId(),40, unitOne); //Using method override

        Exam viz = new Exam(50, 120);
        Assignment dashboard = new Assignment("Dashboard", 50);

        //Add the assessments and mark them complete
        unitTwo.addAssessment(viz);
        unitTwo.addAssessment(dashboard);

        // Adding marks and comments to exam
        viz.addStudentMarks(studentThird.getStudentId(),80,"Nice Work", unitTwo);

        // Adding marks and comments to assignments
        dashboard.addStudentMarks(studentThird.getStudentId(),50,"Excellent", unitTwo);

        Exam pc = new Exam(50, 120);
        Assignment parallel = new Assignment("Parallel Computing", 50);

        //Add the assessments and mark them complete
        unitThree.addAssessment(pc);
        unitThree.addAssessment(parallel);

        // Adding marks and comments to exam
        pc.addStudentMarks(studentSecond.getStudentId(),70,"Nice Work", unitThree);

        // Adding marks and comments to assignments
        parallel.addStudentMarks(studentSecond.getStudentId(),60,"Excellent", unitThree);

        //compSci.canGraduate();
        //software.canGraduate();
        //secondUnit.displayCourses(this);

    }
        /*
        private String readString(String prompt) {
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)
        );
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    */

    /**
     * Method to display units.
     */
    public void displayUnits() {
        for (Unit unit : unitsArray) {
            unit.description();
            System.out.println("Enrolled Students:\n");
            for (Integer id: unit.getEnrolledStudents()) {
                //System.out.println(this.students.get(id).description());
                System.out.println(this.students.get(id).description() + "\nTotal marks=" + unit.getStudentTotal(id));
            }
            System.out.println("\n");
        }
    }

    /**
     * Method to print the status to user.
     */
    public void printStatus() throws Exception {
        System.out.println("Welcome to Java University \n");

        createUnits();
        displayUnits();

        System.out.println("Thank you for using Java University \n");
    }
}