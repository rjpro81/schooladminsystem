package com.elimullc.busybee;
/**
 *class Date creates a Date object for the class Calendar
 */
 
 public class Date{
  //instance variables
  private int month;
  private int day;
  private int year;
  private String date;
  
  private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 
		  30, 31, 30, 31};//this is an array of days per month 
  
  /**
   * This is a no argument constructor
   */
  public Date(){
	
  }
  /**
   * This one argument constructor takes a string argument 
   * @param date 
   */
  public Date(String date){
      this.date = date;
  }
  /**
   * constructor that validates date arguments 
   * @param month
   * @param day
   * @param year 
   */
  public Date(int month, int day, int year){
	if (month <= 0 || month > 12)
		throw new IllegalArgumentException("month (" + month + ") must be 1-12");
	if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
      throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
	
	if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
      
	this.month = month;
	this.day = day;
	this.year = year;  
  }	 
  /**
   * sets month and validates arguments
   * @param month 
   */
  public void setMonth(int month){
	  if (month <= 0 || month > 12)
		throw new IllegalArgumentException("month (" + month + ") must be 1-12");//month is between 1-12
	  if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
	    throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");//checks if month is February 
		
	  if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");//checks for leap year
	  
	  this.month = month;  
  }
  /**
   * gets month
   * @return 
   */
  public int getMonth(){
	return month;  
  }
  /**
   * sets day
   * @param day 
   */
  public void setDay(int day){
	this.day = day;  
  }
  /**
   * sets day
   * @return 
   */
  public int getDay(){
	return day;  
  }
  /**
   * sets year
   * @param year 
   */
  public void setYear(int year){
	this.year = year;  
  }
  /**
   * gets year
   * @return 
   */
  public int getYear(){
	return year;  
  } 
  /**
   * This method extracts a Date object from a String
   * @return 
   */
  Date dateFromString(String date){
      this.month = Integer.parseInt(date.substring(0, 2));
      this.day = Integer.parseInt(date.substring(3, 5));
      this.year = Integer.parseInt(date.substring(6, 10));
      
      return new Date(month, day, year);
  }
 
 
  /**
   * This method overrides the Object method to create a formatted date object
   * @return 
   */
  @Override
  public String toString(){
    return String.format("%02d/%02d/%4d", getMonth(), getDay(), getYear());
  }
}
 
 
