
package com.elimullc.busybee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ralph Julsaint
 */
public class AddUserWindow extends JFrame {
    /**
     * Creates new form AddUserFrame
     */
    private User user;
    public AddUserWindow() {
        super("New User");
        initComponents();
        setFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabel firstNameLabel = new JLabel();
        firstNameTextField = new JTextField();
        JLabel lastNameLabel = new JLabel();
        lastNameTextField = new JTextField();
        JLabel userNameLabel = new JLabel();
        usernameTextField = new JTextField();
        JLabel passwordLabel = new JLabel();
        passwordTextField = new JTextField();
        JLabel confirmPasswordLabel = new JLabel();
        JTextField confirmPasswordTextField = new JTextField();
        JButton submitButton = new JButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        userNameLabel.setText("Username:");

        passwordLabel.setText("Password:");

        confirmPasswordLabel.setText("Confirm Password:");

        submitButton.setText("Submit");
        submitButton.addActionListener(this::submitButtonActionPerformed);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmPasswordLabel)
                    .addComponent(passwordLabel)
                    .addComponent(userNameLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(firstNameLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(usernameTextField)
                    .addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(confirmPasswordTextField)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(userNameLabel)
                            .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmPasswordLabel)
                            .addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton)
                            .addComponent(cancelButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        //creates a new user and login information
        int result;
        //instance variables
        String URL = "jdbc:derby:/ext/derby-10.17.1.0.jar;create=true";
        String username = "julsaint";
        String password = "julsaint";
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            String addUser = "INSERT INTO users (username, password, firstName, lastName) VALUES (?, ?, ?, ?)";
            PreparedStatement addUserStatement = connection.prepareStatement(addUser);
            addUserStatement.setString(1, usernameTextField.getText());
            addUserStatement.setString(2, passwordTextField.getText());
            addUserStatement.setString(3, firstNameTextField.getText());
            addUserStatement.setString(4, lastNameTextField.getText());
            int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Add User", JOptionPane.YES_NO_OPTION);
            if (option == 0){
            result = addUserStatement.executeUpdate();
                if (result > 0){
                    user.setUsername(usernameTextField.getText());
                    JOptionPane.showMessageDialog(null, "New user added", "New User", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new AddSchoolWindow();
                }
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * This method cancels the new user registration and closes the window
     */
    private void cancelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * This method sets the size, location, and visibility of the JFrame
     */
    private void setFrame(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField passwordTextField;
    private JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
