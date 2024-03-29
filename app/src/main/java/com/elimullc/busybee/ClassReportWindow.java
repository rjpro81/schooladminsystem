

package com.elimullc.busybee;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * The purpose of this class is to display classroom report data
 * @author Ralph Julsaint
 */
public class ClassReportWindow extends javax.swing.JFrame {
    /**
     * Creates new form ClassReportWindow
     */
    public ClassReportWindow() {
        super("Class Reports");
        initComponents();
        displayArea.setText(displayClassReport().toString());
        setFrame();     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        displayArea = new javax.swing.JTextArea();
        javax.swing.JButton printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayArea.setEditable(false);
        displayArea.setColumns(20);
        displayArea.setRows(5);
        jScrollPane1.setViewportView(displayArea);

        printButton.setText("Print");
        printButton.addActionListener(this::printButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(printButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method allows the user to print a classroom report
     */
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        try{
            displayArea.print();
        }
        catch(PrinterException e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_printButtonActionPerformed
    /**
     * This method sets the size, location, and visibility of the JFrame
     */
    private void setFrame(){
       this.setLocationRelativeTo(null);
       this.setVisible(true);
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private StringBuilder displayClassReport(){
        StringBuilder stringBuilder = new StringBuilder();
   
        for (Report classReport : getClassReports()){
            stringBuilder.append(classReport.classReportToString());   
        }
        return stringBuilder;
    }
    
    List<Report> getClassReports(){
        List<Report> list = new ArrayList<>();
        String URL = "jdbc:derby:schoolDB;create=false";
        String username = "julsaint";
        String password = "julsaint";
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            String classReportQuery = "SELECT faculty.empFirstName, faculty.empLastName, students.studentFirstName, students.studentLastName, readingAverage, mathAverage, scienceAverage, socialStudiesAverage, students.studentID, faculty.employeeID FROM grades INNER JOIN classroom ON grades.studentID = classroom.studentID INNER JOIN faculty ON classroom.employeeID = faculty.employeeID INNER JOIN students ON students.studentID = grades.studentID ORDER BY faculty.employeeID ASC";
            PreparedStatement classReportStatement = connection.prepareStatement(classReportQuery);
            ResultSet resultSet = classReportStatement.executeQuery();
            
            //database query to retrieve student grades
            while (resultSet.next()){
                list.add(new Report(
                resultSet.getString("empFirstName"),
                resultSet.getString("empLastName"),
                resultSet.getString("studentFirstName"),
                resultSet.getString("studentLastName"),
                resultSet.getDouble("readingAverage"),
                resultSet.getDouble("mathAverage"),
                resultSet.getDouble("scienceAverage"),
                resultSet.getDouble("socialStudiesAverage"),
                resultSet.getString("studentID"),
                resultSet.getString("employeeID")));
            }   
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea displayArea;
    // End of variables declaration//GEN-END:variables
}
