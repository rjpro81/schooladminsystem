package com.elimullc.busybee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Demographics provides demographic data to class school
 */
 
 public class SchoolDemographics{
    private int totalEnrollment;
   private int maleCount;
   private int femaleCount;
   private int caucasianCount;
   private int africanAmericanCount;
   private int otherCount;
   
  
   List<Student> getStudentList(){
       //instance variables
       List<Student> studentList = new ArrayList<>();
       String URL = "jdbc:derby:schoolDB;create=false";
       String username = "julsaint";
       String password = "julsaint";
       try(Connection connection = DriverManager.getConnection(URL, username, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()){
                studentList.add(new Student(resultSet.getString("studentID"),
                resultSet.getString("studentFirstName"), resultSet.getString("studentLastName"),
                resultSet.getString("studentAge"), resultSet.getString("studentBirthDate"),
                resultSet.getString("studentAddress"), resultSet.getString("studentCity"),
                resultSet.getString("studentState"), resultSet.getString("studentZip"),
                resultSet.getString("studentPhoneNumber"), resultSet.getString("studentGrade"),
                resultSet.getString("ethnicity"), resultSet.getString("gender")));   
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return studentList;
    }
   int getTotalEnrollment(){
      for (int i = 0; i <= getStudentList().size(); i++) {
          totalEnrollment = i;
      }
      return totalEnrollment;
   }
   int getMaleCount(){
      for (Student student : getStudentList())
          if (student.getGender().equals("Male"))
              ++maleCount;
      return maleCount;
   }
   int getFemaleCount(){
      for (Student student : getStudentList())
          if (student.getGender().equals("Female"))
              ++femaleCount;
      return femaleCount;
   }
   int getCaucasianCount(){
      for (Student student : getStudentList())
          if (student.getEthnicity().equals("Caucasian"))
              ++caucasianCount;
      return caucasianCount;
   }
   int getAfricanAmericanCount(){
      for (Student student : getStudentList())
          if (student.getEthnicity().equals("African American"))
              ++africanAmericanCount;
      return africanAmericanCount;
   }
   int getOtherCount(){
      for (Student student : getStudentList())
          if (!student.getEthnicity().equals("Caucasian") && !student.getEthnicity().equals("African American"))
              ++otherCount;
      return otherCount;
   }
   @Override
   public String toString(){
       return String.format("School Year: 2018-2019%n%nTotal Enrollment: %d%nMale: %d%nFemale: %d%nAfrican American: %d%nCaucasian: %d%nOther: %d%n", getTotalEnrollment(), getMaleCount(), getFemaleCount(), getAfricanAmericanCount(), getCaucasianCount(), getOtherCount());
   }
 }
