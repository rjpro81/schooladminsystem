

package com.elimullc.busybee;

/**
 * The purpose of this class is to create task objects that can be added to 
 * to do list
 * @author Ralph Julsaint
 */
public class ToDo {
    //instance variables
    private String taskName;
    private Date date;
    private String time;
    
    /**
     * No argument constructor 
     */
    public ToDo(){
    
    }
    /**
     * Constructor that initializes three instance variables
     * @param taskName
     * @param date
     * @param time 
     */
    public ToDo(String taskName, Date date, String time){
        this.taskName = taskName;
        this.date = date;
        this.time = time;
    }
    /**
     * Getter and setter methods that return or set values
     * @param taskName 
     */
    void setTaskName(String taskName){
        this.taskName = taskName;
    }
    void setDate(Date date){
        this.date = date;
    }
    void setTime(String time){
        this.time = time;
    }
    String getTaskName(){
        return taskName;
    }
    Date getDate(){
        return date;
    }
    String getTime(){
        return time;
    }
    /**
     * Overides the Object method that formats a String for the ToDo object
     * @return 
     */
    @Override
    public String toString(){
        return String.format("%s %s %s%n%n", getTaskName(), getDate(), getTime());
    }
}
