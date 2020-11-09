import java.util.ArrayList;

public class Course {

    private String courseName;
    private int electiveNo;

    public Course(String courseName, int electiveNo){
        this.courseName = courseName;
        this.electiveNo = electiveNo;
    }

    private ArrayList<Unit> coreUnits = new ArrayList<>();
    private ArrayList<Unit> electiveUnits = new ArrayList<>();
    private ArrayList<Student> enrolledStudents = new ArrayList<>();
    private ArrayList<Student> graduates = new ArrayList<>();

    public void addCoreUnits(Unit core) {
        coreUnits.add(core);
    }

    public void addElectiveUnits(Unit elective) {
        electiveUnits.add(elective);
    }

    public ArrayList<Unit> getCoreUnits() {
        return new ArrayList<>(coreUnits);
    }

    public ArrayList<Unit> getElectiveUnits() {
        return new ArrayList<>(electiveUnits);
    }

    public void enrol(Student aStudent){
        enrolledStudents.add(aStudent);
    }

    public String description() {
        return courseName;
    }

    public void canGraduate() {
        meetsRequirements();
        System.out.println("Students who will graduate: ");
        for (Student temp : graduates) {
            System.out.println(temp.description());
        }
    }

    public void meetsRequirements(){
        for (Student temp : enrolledStudents) {
            boolean core = false;
            boolean elective = false;

            if (temp.getEnrolledUnits().containsAll(coreUnits)){
                core = true;
                for (Unit cr : coreUnits){
                    if (cr.getStudentTotal(temp.getStudentId()) < 50){
                        core = false;
                    }
                }
            }

            int passedElectives = 0;
            for (Unit el : electiveUnits){
                if (temp.getEnrolledUnits().contains(el)) {
                    if (el.getStudentTotal(temp.getStudentId()) > 50){
                        passedElectives += 1;

                        if (passedElectives >= electiveNo){
                            elective = true;
                        }
                    }
                }
            }
            if (core & elective){
                graduates.add(temp);
            }
        }
    }
}