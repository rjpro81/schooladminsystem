
package com.elimullc.busybee;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
/**
 * The purpose of this class is to create a table model that serve our JTable in the main 
 * application window
 * @author Ralph Julsaint
 */
public class BusyBeeTableModel extends AbstractTableModel{
    private boolean connectedToDatabase = false;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metadata;
    private int numberOfRows;
    private String URL;
    private String username;
    private String password;
    private String query;
    /**
     *
     * @param URL
     * @param username
     * @param password
     * @param query
     * @throws java.sql.SQLException
     */
    public BusyBeeTableModel(String URL, String username, String password, String query) throws SQLException{
        connection = DriverManager.getConnection(URL, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        connectedToDatabase = true;
        setQuery(query);
       
    }
    /**
   * This method allows the ability to get column class of Table Model
   * @param column
   * @return
   * @throws IllegalStateException 
   */
  @Override
  public Class getColumnClass(int column) throws IllegalStateException{
    if (!connectedToDatabase)
        throw new IllegalStateException("Not Connected to Database");
    
    try{
      String className = metadata.getColumnClassName(column + 1);
      
      return Class.forName(className);
    }
    catch(ClassNotFoundException | SQLException e){
      System.err.println(e.getMessage());
    }
      return Object.class;
  }
  /**
   * This method allows the ability to get total column count
   * @return
   * @throws IllegalStateException 
   */
  @Override
  public int getColumnCount() throws IllegalStateException{
    
    if (!connectedToDatabase)
        throw new IllegalStateException("Not Connected to Database");
    
    try{
      return metadata.getColumnCount();
    }
    catch(SQLException e){
      System.err.println(e.getMessage());
    }
    return 0;
  }
  /**
   * This method that provides the ability to obtain the column name
   * @param column
   * @return
   * @throws IllegalStateException 
   */
  @Override
  public String getColumnName(int column) throws IllegalStateException{
    if (!connectedToDatabase)
        throw new IllegalStateException("Not Connected to Database");
    
    try{
      return metadata.getColumnName(column + 1);
    }
    catch(SQLException e){
      System.err.println(e.getMessage());
    }
    return "";
  }
  /**
   * This method provides the ability to get row count
   * @return
   * @throws IllegalStateException 
   */
  @Override
  public int getRowCount() throws IllegalStateException{
    
    if (!connectedToDatabase)
        throw new IllegalStateException("Not Connected to Database");
    
    return numberOfRows;
  }
  /**
   * This method provides the ability to get retrieve the value at a specific row and column in table
   * @param row
   * @param column
   * @return
   * @throws IllegalStateException 
   */
  @Override
  public Object getValueAt(int row, int column) throws IllegalStateException{
    
      if (! connectedToDatabase)
          throw new IllegalStateException("Not Connected to Database");
      
      try{
        resultSet.absolute(row + 1);
        return resultSet.getObject(column + 1);
      }
      catch (SQLException e){
        System.err.println(e.getMessage());
      }
      return "";
  }
  /**
   * This method sets the query that that the Table will display
   * @param query
   * @throws SQLException
   * @throws IllegalStateException 
   */
  public void setQuery(String query) throws SQLException, IllegalStateException{
      if(!connectedToDatabase)
          throw new IllegalStateException("Not Connected to Database");
      
    resultSet = statement.executeQuery(query); 
    metadata = resultSet.getMetaData();
    resultSet.last();
    numberOfRows = resultSet.getRow();
    
    fireTableStructureChanged();
  }
  /**
   * This method provides the ability to disconnect from the database
   */
  public void disconnectFromDatabase(){
    if (connectedToDatabase){
      try{
        resultSet.close();
        statement.close();
        connection.close();
      }
      catch(SQLException e){
        System.err.println(e.getMessage());
      }
      finally{
        connectedToDatabase = false;
      }
    }
  }
}
