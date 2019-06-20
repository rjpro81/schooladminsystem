
package studinfomgmtsys;

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
 *
 * @author ralph
 */
public class DeleteTaskWindow extends javax.swing.JFrame {
    private final String URL = "jdbc:derby://localhost:1527/schoolDB;create=false";
    private final String username = "julsaint";
    private final String password = "julsaint";
    /**
     * Creates new form DeleteTaskWindow
     */
    public DeleteTaskWindow() {
        super("Delete Task");
        initComponents();
        setFrame();
        addToComboBox(getAllTasks());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        taskComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taskLabel.setText("Task:");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        taskComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(taskLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskComboBox, 0, 235, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method allows the user to delete a task from the database
     * @param evt 
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int index = taskComboBox.getSelectedIndex();
        int option = JOptionPane.showConfirmDialog(null, "Are you sure", "Delete Task", JOptionPane.YES_NO_OPTION);
        if (option == 0){
           
            try(Connection connection = DriverManager.getConnection(URL, username, password)){
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks");
              
                while (resultSet.next()){
                    if (resultSet.absolute(index))
                        resultSet.deleteRow();
                }
            }
            catch(SQLException e){
                System.err.println(e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Task deleted");
            BusyBeeMainApplicationWindow.getToDoListTextArea().setText(getToDos().toString());
            this.dispose();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    /**
     * This method retrieves all tasks from database
     * @return 
     */
    private List<ToDo> getAllTasks(){
        List<ToDo> list = new ArrayList<>();
        Date date = new Date();
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            PreparedStatement getTasksStatement = connection.prepareStatement("SELECT * FROM tasks");
            ResultSet resultSet = getTasksStatement.executeQuery();
            
            while (resultSet.next()){
                list.add(new ToDo(resultSet.getString("taskName"),
                date.dateFromString(resultSet.getString("taskDate")),
                resultSet.getString("taskTime")));    
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }
    /**
     * This method sets all values to combobox for user selection
     * @param list 
     */
    private void addToComboBox(List<ToDo> list){
        for (ToDo task : list)
            taskComboBox.addItem(task.toString());
    }
    /**
     * This method formats tasks for display in text area
     * @return 
     */
    private StringBuilder getToDos(){
        List<ToDo> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        try(Connection connection = DriverManager.getConnection(URL, username, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks");
            Date date = new Date();
            while (resultSet.next()){
                list.add(new ToDo(resultSet.getString("taskName"),
                date.dateFromString(resultSet.getString("taskDate")), 
                resultSet.getString("taskTime")));
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        for (ToDo toDo : list)
            str.append(toDo);
        
        return str;
    }
    /**
     * This method sets the size, location, and visibility of JFrame
     */
    private void setFrame(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> taskComboBox;
    private javax.swing.JLabel taskLabel;
    // End of variables declaration//GEN-END:variables
}
