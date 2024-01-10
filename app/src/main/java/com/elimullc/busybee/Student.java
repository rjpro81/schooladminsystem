package com.elimullc.busybee;


/**
 *class Student creates a student object for the Student database
 */
 
public class Student extends Person{
    //instance variables
  private String studentID;
  private String grade;
  private String ethnicity;	
  private String gender;
  
 
  
  	
  public Student(final String firstName, final String lastName, String age, final String birthDate, String streetAddress, String city, String state, String zip, String phoneNumber, String grade, final String ethnicity, final String gender){
      super(firstName, lastName, age, birthDate, streetAddress, city, state, zip, phoneNumber);
      
      this.grade = grade;
      this.ethnicity = ethnicity;
      this.gender = gender;
  } 
  public Student(final String studentID, final String firstName, final String lastName, String age, final String birthDate, String streetAddress, String city, String state, String zip, String phoneNumber, String grade, final String ethnicity, final String gender){
      super(firstName, lastName, age, birthDate, streetAddress, city, state, zip, phoneNumber);
      this.studentID = studentID;
      this.grade = grade;
      this.ethnicity = ethnicity;
      this.gender = gender;
  }
 
  /**
   * gets studentID
   * @return 
   */
  public String getStudentID(){
    return studentID;  
  }
  
  /**
   * sets grade
   * @param grade 
   */
  public void setGrade(String grade){
	this.grade = grade;  
  }
  /**
   * gets grade
   * @return 
   */
  public String getGrade(){
	return grade;  
  }
  /**
   * sets ethnicity
   * @param ethnicity 
   */
  public void setEthnicity(final String ethnicity){
	this.ethnicity = ethnicity;
      
  }
  /**
   * gets ethnicity
   * @return 
   */
  public String getEthnicity(){
	return ethnicity;  
  }

  /**
   * sets gender
   * @param gender 
   */
  public void setGender(final String gender){
	this.gender = gender;
  }
 
  /**
   * gets gender
   * @return 
   */
  public String getGender(){
    return gender;
  }
}
