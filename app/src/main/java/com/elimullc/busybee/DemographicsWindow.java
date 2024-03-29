
package com.elimullc.busybee;

import java.awt.print.PrinterException;
import javax.swing.JFrame;

/**
 * The purpose of this class is to display demographics information 
 * @author Ralph Julsaint
 */
public class DemographicsWindow extends javax.swing.JFrame {
    private SchoolDemographics demographics = new SchoolDemographics();//school demographics object 
    /**
     * Creates new form DemographicsWindow
     */
    public DemographicsWindow() {
        super("Demographics");
        initComponents();
        displayArea.setText(demographics.toString());//displays demographics info
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

        jScrollPane1 = new javax.swing.JScrollPane();
        displayArea = new javax.swing.JTextArea();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayArea.setColumns(20);
        displayArea.setRows(5);
        jScrollPane1.setViewportView(displayArea);

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(printButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method allows the user to print the demographics information
     * @param evt 
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
     * This method sets the size, location, and visibility of JFrame
     */
    public void setFrame(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea displayArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
}
