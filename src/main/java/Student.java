
/** Class used to record the details of a student resident 
 *  @author Hazemn
 *  @version 25 April 2026
 */
public class Student {

    private String studentId;
    private String course;
    private String year;
    private String firstName;
    private String lastName;

    /**
     * The constructor - used when user creates a new student via the form
     * @param studentId
     * @param course
     * @param year
     * @param firstName
     * @param lastName
     */
    public Student(String studentId, String course, String year, String firstName, String lastName) {
        this.studentId = studentId;
        this.course = course;
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @return the ID of the student
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     *
     * @param studentId it will set the number of the student ID. Implemented via the form
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return - it will return the course of the student.
     */
    public String getCourse() {
        return course;
    }

    /**
     *
     * @param course it will set the name of the course. Implemented via the form
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     *
     * @return it will return the year of the course 
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year - set the year of the course. Implemented via the form
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return 
     * @returnit will return the first name of the student 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName it will set the first name of the student. Implemented via the form.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return it will return the last name of the student 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName it will set the last name of the student. Implemented via the form
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return it will return student ID, first name, the last name, course name and year.
     */
    @Override
    public String toString() {
        return studentId + " - " + firstName + " " + lastName + 
               " | Course: " + course + " | Year: " + year;
    }
}