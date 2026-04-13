
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hhhaz
 */
public class HasamStudentHalls {

    /**
     * The GUI for the application
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        StudentHall hallList = new StudentHall(20);

        JFrame frame = new JFrame("Student Halls System");
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea displayStudents = new JTextArea();
        displayStudents.setLineWrap(true);
        displayStudents.setWrapStyleWord(true);
        displayStudents.setEditable(false);

        frame.add(new JScrollPane(displayStudents), BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.green);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Book a Student for a Residence");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(10));

        JPanel studentPanel = new JPanel();
        studentPanel.setBackground(Color.green);
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        JLabel givenNameLabel = new JLabel("First Name:");
        JTextField givenNameField = new JTextField(20);
        studentPanel.add(givenNameLabel);
        studentPanel.add(givenNameField);

        JLabel surnameLabel = new JLabel("Last Name:");
        JTextField surnameField = new JTextField(20);
        studentPanel.add(surnameLabel);
        studentPanel.add(surnameField);

        topPanel.add(studentPanel);
        topPanel.add(Box.createVerticalStrut(10));

        JPanel coursePanel = new JPanel();
        coursePanel.setBackground(Color.green);
        coursePanel.setBorder(BorderFactory.createTitledBorder("Course Details"));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField(20);
        coursePanel.add(studentIdLabel);
        coursePanel.add(studentIdField);

        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField(20);
        coursePanel.add(courseLabel);
        coursePanel.add(courseField);

        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField(20);
        coursePanel.add(yearLabel);
        coursePanel.add(yearField);

        topPanel.add(coursePanel);

        JScrollPane scrollPane = new JScrollPane(topPanel);
        frame.add(scrollPane, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.black);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton submitBtn = new JButton("Enter student details");
        JButton saveBtn = new JButton("Save residents");

        submitBtn.addActionListener(e -> {
            Student student = new Student(
                    studentIdField.getText().trim(),
                    courseField.getText().trim(),
                    yearField.getText().trim(),
                    givenNameField.getText().trim(),
                    surnameField.getText().trim()
            );

            JOptionPane.showMessageDialog(null, student.getCourse() + " is created!");
            hallList.addStudent(student);
            JOptionPane.showMessageDialog(null, "There are " + hallList.getTotal() + " students in the hall");
            displayStudents.setText(hallList.displayResidents());

            // 🔽 CLEAR INPUT FIELDS (put it HERE)
            givenNameField.setText("");
            surnameField.setText("");
            studentIdField.setText("");
            courseField.setText("");
            yearField.setText("");
        });
        submitBtn.addActionListener(e -> {
            Student student = new Student(
                    studentIdField.getText().trim(),
                    courseField.getText().trim(),
                    yearField.getText().trim(),
                    givenNameField.getText().trim(),
                    surnameField.getText().trim()
            );

            JOptionPane.showMessageDialog(null, student.getCourse() + " is created!");
            hallList.addStudent(student);
            JOptionPane.showMessageDialog(null, "There are " + hallList.getTotal() + " students in the hall");
            displayStudents.setText(hallList.displayResidents());

            // CLEAR INPUT FIELDS AFTER ADDING STUDENT
            givenNameField.setText("");
            surnameField.setText("");
            studentIdField.setText("");
            courseField.setText("");
            yearField.setText("");
        });

        saveBtn.addActionListener(e -> {
            hallList.saveToFile("students.txt");
            JOptionPane.showMessageDialog(null, "Students saved successfully!");
        });

        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(submitBtn);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(saveBtn);

        frame.add(leftPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
