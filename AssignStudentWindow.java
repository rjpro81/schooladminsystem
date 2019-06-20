
package studinfomgmtsys;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The purpose of this class is to assign students to teachers
 * @author Ralph Julsaint
 */
public class AssignStudentWindow extends javax.swing.JFrame {
    //instance variables
    private final String assignStudent = "INSERT INTO classroom (studentID, employeeID) VALUES (?, ?)";
    private final String getFacultyQuery = "SELECT employeeID, empFirstName, empLastName, empGrade FROM faculty";
    private final String getEmployeeIDQuery = "SELECT employeeID FROM faculty";
    private PreparedStatement assignStudentStatement;
    private PreparedStatement getFacultyStatement;
    private final String URL = "jdbc:derby://localhost:1527/schoolDB;create=false";
    private final String username = "julsaint";
    private final String password = "julsaint";
    List<Integer> facultyEmployeeID;
    List<String> facultyFirstName;
    List<String> facultyLastName;
    List<String> facultyGrade;

    /**
     * Creates new form AssignStudentWindow
     */
    public AssignStudentWindow() {
        super("Assign Student");
        initComponents();
        addToComboBox();
        setFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        studentIDLabel = new javax.swing.JLabel();
        gradeLabel = new javax.swing.JLabel();
        teacherAssignmentLabel = new javax.swing.JLabel();
        studentIDTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        gradeTextField = new javax.swing.JTextField();
        assignmentComboBox = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        studentIDLabel.setText("Student ID:");

        gradeLabel.setText("Grade: ");

        teacherAssignmentLabel.setText("Teacher Assignment:");

        assignmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(teacherAssignmentLabel)
                    .addComponent(gradeLabel)
                    .addComponent(lastNameLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(studentIDLabel)
                        .addComponent(firstNameLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(studentIDTextField)
                        .addComponent(firstNameTextField)
                        .addComponent(lastNameTextField)
                        .addComponent(gradeTextField)
                        .addComponent(assignmentComboBox, 0, 150, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel)
                    .addComponent(studentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeLabel)
                    .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherAssignmentLabel)
                    .addComponent(assignmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        assignStudent(evt);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void assignStudent(ActionEvent evt){
        //assigns student to teacher
        int result = 0;
        int employeeID = getAllEmployeeIDs(getComboBoxSelectedIndex() - 1);
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            assignStudentStatement = connection.prepareStatement(assignStudent);
            assignStudentStatement.setInt(1, Integer.parseInt(studentIDTextField.getText()));
            assignStudentStatement.setInt(2, employeeID);
            int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Assign Student", JOptionPane.YES_NO_OPTION);
            if (option == 0){
            result = assignStudentStatement.executeUpdate();
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Student assigned", "Student Assignment", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    /**
     * This method add items to combobox in assign the student to a specific teacher
     * whose name will be displayed in the combobox
     */
    private void addToComboBox(){
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            getFacultyStatement = connection.prepareStatement(getFacultyQuery);
            ResultSet resultSet = getFacultyStatement.executeQuery();
            
            facultyEmployeeID = new ArrayList<>();
            facultyFirstName = new ArrayList<>();
            facultyLastName = new ArrayList<>();
            facultyGrade = new ArrayList<>();
            
            String firstName = null;
            String lastName = null;
            String grade = null;
            
            
            
            while (resultSet.next()){
                facultyFirstName.add(resultSet.getString("empFirstName"));
                facultyLastName.add(resultSet.getString("empLastName"));
                facultyGrade.add(resultSet.getString("empGrade"));
            }
            for (int i = 0; i < facultyFirstName.size(); i++){
                firstName = facultyFirstName.get(i);
                lastName = facultyLastName.get(i);
                grade = facultyGrade.get(i);
                
                String faculty = String.format("%s %s-%s", firstName, lastName, grade);
                assignmentComboBox.addItem(faculty);
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    /**
     * This method retrieves all employeeIDs in the database in order to assign students
     * to the appropriate teacher based on their employee ID.
     * @return 
     */
    private List<Integer> getEmployeeID(){
        List<Integer> employeeIDs = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getEmployeeIDQuery);
            
            while (resultSet.next()){
                employeeIDs.add(resultSet.getInt("employeeID"));
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return employeeIDs;
    }
    /**
     * This method returns the value of the combo box index selected
     * @return 
     */
    int getComboBoxSelectedIndex(){
        int index = assignmentComboBox.getSelectedIndex();
        
        return index;
    }
    /**
     * This method retrieves a specific employeeID based on the combobox index selected
     * @param index
     * @return 
     */
    int getAllEmployeeIDs(int index){
        List<Integer> employeeIDs = new ArrayList<>();
        int employeeID = 0;
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getEmployeeIDQuery);
            
            while (resultSet.next()){
                employeeIDs.add(resultSet.getInt("employeeID")); 
            }
            
            employeeID = employeeIDs.get(index);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return employeeID;
    }
    /**
     * This method sets the size, visibility, and location of JFrame
     */
    private void setFrame(){
        this.setLocation(500, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> assignmentComboBox;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JTextField gradeTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JTextField studentIDTextField;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel teacherAssignmentLabel;
    // End of variables declaration//GEN-END:variables
}