
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
        hallList.loadFromFile("students.txt");

        JFrame frame = new JFrame("Student Halls System");
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ================= DISPLAY AREA =================
        JTextArea displayStudents = new JTextArea();
        displayStudents.setLineWrap(true);
        displayStudents.setWrapStyleWord(true);
        displayStudents.setEditable(false);
        displayStudents.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
        displayStudents.setBorder(BorderFactory.createTitledBorder("Student List"));

        frame.add(new JScrollPane(displayStudents), BorderLayout.CENTER);
        displayStudents.setText(hallList.displayResidents());

        // ================= TOP PANEL =================
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(144, 238, 144)); // light green
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Book a Student for a Residence");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(15));

        // Student Details
        JPanel studentPanel = new JPanel();
        studentPanel.setBackground(new Color(144, 238, 144));
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

        // Course Details
        JPanel coursePanel = new JPanel();
        coursePanel.setBackground(new Color(144, 238, 144));
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
        frame.add(new JScrollPane(topPanel), BorderLayout.NORTH);

        // ================= LEFT PANEL =================
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.black);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new java.awt.Dimension(200, 0));

        JButton submitBtn = new JButton("Enter student details");
        JButton saveBtn = new JButton("Save residents");

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JTextField deleteField = new JTextField(15);
        JButton deleteBtn = new JButton("Delete");

        // ================= BUTTON LOGIC =================
        submitBtn.addActionListener(e -> {
            if (studentIdField.getText().trim().isEmpty()
                    || courseField.getText().trim().isEmpty()
                    || yearField.getText().trim().isEmpty()
                    || givenNameField.getText().trim().isEmpty()
                    || surnameField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                return;
            }

            Student student = new Student(
                    studentIdField.getText().trim(),
                    courseField.getText().trim(),
                    yearField.getText().trim(),
                    givenNameField.getText().trim(),
                    surnameField.getText().trim()
            );

            hallList.addStudent(student);
            displayStudents.setText(hallList.displayResidents());

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

        searchBtn.addActionListener(e -> {
            String name = searchField.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a name to search!");
                return;
            }

            displayStudents.setText(hallList.searchStudent(name));
        });

        deleteBtn.addActionListener(e -> {
            String id = deleteField.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter Student ID!");
                return;
            }

            //  CONFIRMATION POPUP
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this student?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                boolean removed = hallList.deleteStudent(id);

                if (removed) {
                    displayStudents.setText(hallList.displayResidents());
                    hallList.saveToFile("students.txt");
                    JOptionPane.showMessageDialog(null, "Student deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Delete cancelled.");
            }
        });

        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(submitBtn);

        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(saveBtn);

        // Search Section
        JLabel searchLabel = new JLabel("Search by name:");
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchField.setMaximumSize(searchField.getPreferredSize());
        searchField.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(searchLabel);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(searchField);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(searchBtn);

        // Delete Section
        JLabel deleteLabel = new JLabel("Delete by ID:");
        deleteLabel.setForeground(Color.WHITE);
        deleteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        deleteField.setMaximumSize(deleteField.getPreferredSize());
        deleteField.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(deleteLabel);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(deleteField);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(deleteBtn);

        frame.add(leftPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
