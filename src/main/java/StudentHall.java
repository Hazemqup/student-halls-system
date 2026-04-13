import java.util.ArrayList;

/**
 *
 * @author Hazem
 * 
 */
public class StudentHall {

    private final ArrayList<Student> residents;

    /**
     *
     */
    public final int MAX;// max people allowed in the hall

    /**
     * The constructor - creates a list of a residents 
     * @param maxIn - max number of student hall
     */
    public StudentHall(int maxIn) {
        residents = new ArrayList<>();
        MAX = maxIn;
    }

    /**
     * adding a student to the hall
     * @param theStudent - the student to be added
     * @return - boolean representing whether the student was successfully entered or not.
     */
    public boolean addStudent(Student theStudent) {
        if (!isFull()) {
            residents.add(theStudent);
            return true;
        } else {
            return false;
        }
    }

    /**
     *checks wether is it empty or not 
     * @return
     */
    public boolean isEmpty() {
        return residents.isEmpty();
    }

    /**
     *checks if its full or not
     * @return
     */
    public boolean isFull() {
        return residents.size() == MAX;
    }

    /**
     *it gets the total number of the student in the hall
     * @return
     */
    public int getTotal() {
        return residents.size();
    }

    /**
     * finds a particular student based on position - could be room number
     * @param positionIn - the position of student in the list
     * @return
     */
    public Student getStudent(int positionIn) {
        if (positionIn < 0 || positionIn >= getTotal()) {
            return null;
        } else {
            return residents.get(positionIn);
        }
    }

    /**
     * Displays a complete list of students in the hall
     * @return - a concatenated list of students in the hall.
     */
    public String displayResidents() {
        String output = "\n";

        for (int counter = 0; counter < residents.size(); counter++) {
            Student currentStudent = residents.get(counter);

            output += currentStudent.getFirstName() + "\t" + currentStudent.getLastName();
            output += "\n" + currentStudent.getStudentId() + "\t" + currentStudent.getCourse() + "\t" + currentStudent.getYear();
            output += "\n\n";
        }

        return output;
    }
}