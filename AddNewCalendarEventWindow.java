
package studinfomgmtsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * The purpose of this class is to provide users with the ability to add
 * events to the school calendar.
 * @author Ralph Julsaint
 */
public class AddNewCalendarEventWindow extends javax.swing.JFrame {
    //instance variables
    private final String URL = "jdbc:derby://localhost:1527/schoolDB;create=false";
    private final String username = "julsaint";
    private final String password = "julsaint";
    private final String addEvent = "INSERT INTO calendar (event, eventDate) VALUES (?, ?)";
    private PreparedStatement addEventStatement;
   
    /**
     * Creates new form AddNewCalendarEventWindow
     */
    public AddNewCalendarEventWindow() {
        super("Add Event");
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

        eventLabel = new javax.swing.JLabel();
        eventTextField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eventLabel.setText("Event:");

        dateLabel.setText("Date:");

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
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateLabel)
                            .addComponent(eventLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eventTextField)
                            .addComponent(dateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventLabel)
                    .addComponent(eventTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Add the new calendar event after submission
     * @param evt 
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        int result = 0;
        //insert calendar events into database
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            addEventStatement = connection.prepareStatement(addEvent);
            addEventStatement.setString(1, eventTextField.getText());
            addEventStatement.setString(2, dateTextField.getText());
            int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Add Event", JOptionPane.YES_NO_OPTION);
            if (option == 0){
                result = addEventStatement.executeUpdate();
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Event submitted");
                    String event = String.format("%s: %s%n%n", dateTextField.getText(), eventTextField.getText());
                    BusyBeeMainApplicationWindow.getCalendarTextArea().append(event);
                    this.dispose();
                }
            }            
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_submitButtonActionPerformed
    /**
     * This method sets the location, size, and close operation of the JFrame
     */
    private void setFrame(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JTextField eventTextField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
