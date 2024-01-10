package com.elimullc.busybee;

import java.util.Arrays;
/**
 * Class calendar allows the user to format and add events to calendar
 */
 

 
 public class Calendar{
   //days and holidays for the school calendar  
   private String day;
   private String holiday;
     
   /**
    * calendar constructor 
    */
   public Calendar() {
	
   }
   public Calendar(String day, String holiday){
       this.day = day;
       this.holiday = holiday;
   }
     
   void setDay(String day){
       this.day = day;
   }
   
   void setHoliday(String holiday){
       this.holiday = holiday;
   }
   
   String getDay(){
       return day;
   }
   
   String getHoliday(){
       return holiday;
   }
    
   /**
    * string representation of calendar object
    * @return 
    */
   @Override
   public String toString(){
       return String.format("%s: %s%n%n", getDay(), getHoliday());
   }
   	 
 }
