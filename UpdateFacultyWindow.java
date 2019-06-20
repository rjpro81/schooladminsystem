
package studinfomgmtsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The purpose of this class is to allow the user to update or delete a faculty from the database
 * @author Ralph Julsaint
 */
public class UpdateFacultyWindow extends javax.swing.JFrame {
    //instance variables
    private final String URL = "jdbc:derby://localhost:1527/schoolDB;create=false";
    private final String username = "julsaint";
    private final String password = "julsaint";
    private int currentIndex = 0;
    private int numberOfEntries;
    private FacultyMember currentEntry;
    /**
     * Creates new form UpdateFacultyWindow
     */
    public UpdateFacultyWindow() {
        super("Update/Delete");
        initComponents();
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

        employeeIDLabel = new javax.swing.JLabel();
        employeeIDTextField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        stateTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        zipTextField = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        birthDateLabel = new javax.swing.JLabel();
        birthDateTextField = new javax.swing.JTextField();
        credentialLabel = new javax.swing.JLabel();
        credentialsTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        gradeLabel = new javax.swing.JLabel();
        gradeTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        employeeIDLabel.setText("Employee ID:");

        employeeIDTextField.setEditable(false);

        cityLabel.setText("City:");

        firstNameLabel.setText("First Name:");

        stateLabel.setText("State:");

        lastNameLabel.setText("Last Name:");

        zipLabel.setText("Zip:");

        ageLabel.setText("Age:");

        phoneLabel.setText("Phone:");

        birthDateLabel.setText("Birth Date:");

        credentialLabel.setText("Credential:");

        addressLabel.setText("Address:");

        gradeLabel.setText("Grade:");

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        forwardButton.setText(">");
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addressLabel)
                    .addComponent(birthDateLabel)
                    .addComponent(ageLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(firstNameLabel)
                    .addComponent(employeeIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(firstNameTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(ageTextField)
                    .addComponent(birthDateTextField)
                    .addComponent(addressTextField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cityLabel)
                    .addComponent(stateLabel)
                    .addComponent(zipLabel)
                    .addComponent(phoneLabel)
                    .addComponent(credentialLabel)
                    .addComponent(gradeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cityTextField)
                    .addComponent(zipTextField)
                    .addComponent(credentialsTextField)
                    .addComponent(gradeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(phoneTextField)
                    .addComponent(stateTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(18, 18, 18)
                        .addComponent(forwardButton)
                        .addGap(206, 206, 206))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIDLabel)
                    .addComponent(employeeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateLabel)
                    .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipLabel)
                    .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneLabel)
                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(credentialsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(birthDateLabel)
                        .addComponent(birthDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(credentialLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeLabel)
                    .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(forwardButton))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method allows the user to scroll forward through the list of faculty members
     * @param evt 
     */
    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        // TODO add your handling code here:
        displayEntries();
        currentIndex++;
        if(currentIndex >= numberOfEntries){
            currentIndex = 0;
        }
    }//GEN-LAST:event_forwardButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        displayEntries();
        currentIndex--;
        if (currentIndex < 0)
            currentIndex = numberOfEntries - 1;
    }//GEN-LAST:event_backButtonActionPerformed
    /**
     * This method allows the user to delete a faculty member from the database
     * @param evt 
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Faculty", JOptionPane.YES_NO_OPTION);
        if (option == 0){
            int result = 0;
            try(Connection connection = DriverManager.getConnection(URL, username, password)){
                PreparedStatement deleteStudentStatement = connection.prepareStatement("DELETE FROM faculty WHERE employeeID=?");
                deleteStudentStatement.setInt(1, Integer.parseInt(employeeIDTextField.getText()));
       
                result = deleteStudentStatement.executeUpdate();
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Faculty member deleted");
                    this.dispose();
                }
            }
            catch(SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    /**
     * This method allows the user to update or edit the faculty member record
     * @param evt 
     */
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Faculty Update", JOptionPane.YES_NO_OPTION);
        if (option == 0){
            int result = 0;
            try(Connection connection = DriverManager.getConnection(URL, username, password)){
                String updateQuery = "UPDATE faculty SET empFirstName=?, empLastName=?, empAge=?, empBirthDate=?, empAddress=?, empCity=?, empState=?, empZip=?, empPhoneNumber=?, credentials=?, empGrade=? WHERE employeeID=?";
                PreparedStatement updateFacultyStatement = connection.prepareStatement(updateQuery);
                updateFacultyStatement.setString(1, firstNameTextField.getText());
                updateFacultyStatement.setString(2, lastNameTextField.getText());
                updateFacultyStatement.setString(3, ageTextField.getText());
                updateFacultyStatement.setString(4, birthDateTextField.getText());
                updateFacultyStatement.setString(5, addressTextField.getText());
                updateFacultyStatement.setString(6, cityTextField.getText());
                updateFacultyStatement.setString(7, stateTextField.getText());
                updateFacultyStatement.setString(8, zipTextField.getText());
                updateFacultyStatement.setString(9, phoneTextField.getText());
                updateFacultyStatement.setString(10, credentialsTextField.getText());
                updateFacultyStatement.setString(11, gradeTextField.getText());
                updateFacultyStatement.setInt(12, Integer.parseInt(employeeIDTextField.getText()));
                result = updateFacultyStatement.executeUpdate();
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Faculty record updated", "Faculty Update", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }
            catch(SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    /**
     * This method obtains all faculty member data from the database
     * @return 
     */
    private List<FacultyMember> getAllFaculty(){
        List<FacultyMember> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            PreparedStatement getStudentStatement = connection.prepareStatement("SELECT * FROM faculty");
            ResultSet resultSet = getStudentStatement.executeQuery();
                    
            while (resultSet.next()){
                list.add(new FacultyMember(
                resultSet.getString("employeeID"),
                resultSet.getString("empFirstName"),
                resultSet.getString("empLastName"),
                resultSet.getString("empAge"),
                resultSet.getString("empBirthDate"),
                resultSet.getString("empAddress"),
                resultSet.getString("empCity"),
                resultSet.getString("empState"),
                resultSet.getString("empZip"),
                resultSet.getString("empPhoneNumber"),
                resultSet.getString("credentials"),
                resultSet.getString("empGrade")));
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }
    /**
     * This method displays entries to the application window
     */
    private void displayEntries(){
       numberOfEntries = getAllFaculty().size();
       if (numberOfEntries != 0){
           currentEntry = getAllFaculty().get(currentIndex);
           employeeIDTextField.setText(currentEntry.getEmployeeID());
           firstNameTextField.setText(currentEntry.getFirstName());
           lastNameTextField.setText(currentEntry.getLastName());
           ageTextField.setText(currentEntry.getAge());
           birthDateTextField.setText(currentEntry.getBirthDate());
           addressTextField.setText(currentEntry.getStreetAddress());
           cityTextField.setText(currentEntry.getCity());
           stateTextField.setText(currentEntry.getState());
           zipTextField.setText(currentEntry.getZip());
           phoneTextField.setText(currentEntry.getPhoneNumber());
           gradeTextField.setText(currentEntry.getGradeLevel());
           credentialsTextField.setText(currentEntry.getCredentials());
           forwardButton.setEnabled(true);
       }
    }
    /**
     * This method sets the size, location, visibility, and closing procedure of the JFrame
     */
    private void setFrame(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JTextField birthDateTextField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel credentialLabel;
    private javax.swing.JTextField credentialsTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel employeeIDLabel;
    private javax.swing.JTextField employeeIDTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JButton forwardButton;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JTextField gradeTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel zipLabel;
    private javax.swing.JTextField zipTextField;
    // End of variables declaration//GEN-END:variables
}
