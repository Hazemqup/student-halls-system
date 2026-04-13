
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
     *
     * @param maxIn - max number of student hall
     */
    public StudentHall(int maxIn) {
        residents = new ArrayList<>();
        MAX = maxIn;
    }

    /**
     * adding a student to the hall
     *
     * @param theStudent - the student to be added
     * @return - boolean representing whether the student was successfully
     * entered or not.
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
     * checks wether is it empty or not
     *
     * @return
     */
    public boolean isEmpty() {
        return residents.isEmpty();
    }

    /**
     * checks if its full or not
     *
     * @return
     */
    public boolean isFull() {
        return residents.size() == MAX;
    }

    /**
     * it gets the total number of the student in the hall
     *
     * @return
     */
    public int getTotal() {
        return residents.size();
    }

    /**
     * finds a particular student based on position - could be room number
     *
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
     *
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

    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Student s : residents) {
                writer.write(
                        s.getStudentId() + ","
                        + s.getFirstName() + ","
                        + s.getLastName() + ","
                        + s.getCourse() + ","
                        + s.getYear() + "\n"
                );
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {
                    Student student = new Student(
                            data[0], // id
                            data[3], // course
                            data[4], // year
                            data[1], // first name
                            data[2] // last name
                    );

                    residents.add(student);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("No file found yet.");
        }
    }
}
