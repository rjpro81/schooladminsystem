
package com.elimullc.busybee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

/**
 * The purpose of this class is to create grade objects for reports
 * @author Ralph Julsaint
 */
public class Grades {
    //instance variables
  private double readingAverage;
  private double mathAverage;
  private double scienceAverage;
  private double socialStudiesAverage;
  
  /**
   * No argument constructor
   */
  public Grades(){
  
  }
  /**
   * Constructor that initializes all instance variables
   * @param readingAverage
   * @param mathAverage
   * @param scienceAverage
   * @param socialStudiesAverage 
   */
  public Grades(double readingAverage, double mathAverage, double scienceAverage, double socialStudiesAverage){
      this.readingAverage = readingAverage;
      this.mathAverage = mathAverage;
      this.scienceAverage = scienceAverage;
      this.socialStudiesAverage = socialStudiesAverage;
  }
  /**
   * This method sets reading average
   * @param readingAverage 
   */
  void setReadingAverage(double readingAverage){
      this.readingAverage = readingAverage;
  }
  /**
   * This method sets the math average
   * @param mathAverage 
   */
  void setMathAverage(double mathAverage){
      this.mathAverage = mathAverage;
  }
  /**
   * This method sets the science average
   * @param scienceAverage 
   */
  void setScienceAverage(double scienceAverage){
      this.scienceAverage = scienceAverage;
  }
  /**
   * This method sets the social studies average
   * @param socialStudiesAverage 
   */
  void setSocialStudiesAverage(double socialStudiesAverage){
      this.socialStudiesAverage = socialStudiesAverage;
  }
  /**
   * This method retrieves the reading average
   * @return 
   */
  double getReadingAverage(){
      return readingAverage;
  }
  /**
   * This method retrieves the math average
   * @return 
   */
  double getMathAverage(){
      return mathAverage;
  }
  /**
   * This method retrieves the science average
   * @return 
   */
  double getScienceAverage(){
      return scienceAverage;
  }
  /**
   * This method retrieves the social studies average
   * @return 
   */
  double getSocialStudiesAverage(){
      return socialStudiesAverage;
  }
  /**
   * This overloaded method retrieves an array of grades and calculates an average
   * @param grades
   * @return 
   */
  double calculateAverage(double[] grades){
       DoubleStream stream = DoubleStream.of(grades);
       OptionalDouble optionalDouble = stream.average();
    
        return optionalDouble.getAsDouble();
  }
  /**
   * This overloaded method retrieves a list collection of grades and calculates an average
   * @param grades
   * @return 
   */
  double calculateAverage(List<Double> grades){
      double sum = 0.0;
      sum = grades.stream().map((average) -> average).reduce(sum, (accumulator, _item) -> accumulator + _item);
      
      double average = sum / grades.size();
      
      return average; 
  }
  
}
