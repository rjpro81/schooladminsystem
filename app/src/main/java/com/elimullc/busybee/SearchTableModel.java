
package com.elimullc.busybee;

import javax.swing.table.DefaultTableModel;

/**
 * The purpose of this class is to create a Table Model for the use of the search algorithm in the main application window
 * @author Ralph Julsaint
 */
public class SearchTableModel extends DefaultTableModel{
    //instance variables
    private String[] columnNames;
    private Object[] data;
    /**
     * Two argument constructor that retrieves an array for column names and an array for row data
     * @param columnNames
     * @param data 
     */
    public SearchTableModel(String[] columnNames, Object[] data){
        for (String columnName : columnNames)
            addColumn(columnName);
        addRow(data);//add a row of data to the table
    }
    /**
     * get method that returns the array of column names
     * @return 
     */
    String[] getColumnNames(){
        return columnNames;
    }
    /**
     * get method that returns the array of data
     * @return 
     */
    Object[] getData(){
        return data;
    }
}
