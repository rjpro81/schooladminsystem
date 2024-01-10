
package com.elimullc.busybee;

/**
 *  The purpose of this abstract class is to serve as a template for any 
 *  "person" classes in the package.
 * @author Ralph Julsaint
 */
public abstract class Person {
     private String firstName;
     private String lastName;
     private String age;
     private String birthDate;
     private String streetAddress;
     private String city;
     private String state;
     private String zip;
     private String phoneNumber;
     
     public Person(String firstName, String lastName, String age, String birthDate,
             String streetAddress, String city, String state, String zip, String phoneNumber){
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
         this.birthDate = birthDate;
         this.streetAddress = streetAddress;
         this.city = city;
         this.state = state;
         this.zip = zip;
         this.phoneNumber = phoneNumber;
     }
     /**
      * Getter and Setter methods to set and return Person or subclass values
      * @param firstName 
      */
     
     public void setFirstName(String firstName){
         this.firstName = firstName;
     }
     public void setLastName(String lastName){
         this.lastName = lastName;
     }
     public void setAge(String age){
         this.age = age;
     }
     public void setBirthDate(String birthDate){
         this.birthDate = birthDate;
     }
     public void setStreetAddress(String streetAddress){
         this.streetAddress = streetAddress;
     }
     public void setCity(String city){
         this.city = city;
     }
     public void setState(String state){
         this.state = state;
     }
     public void setZip(String zip){
         this.zip = zip;
     }
     public void setPhoneNumber(String phoneNumber){
         this.phoneNumber = phoneNumber;
     }
     public String getFirstName(){
         return firstName;
     }
     public String getLastName(){
         return lastName;
     }
     public String getAge(){
         return age;
     }
     public String getBirthDate(){
         return birthDate;
     }
     public String getStreetAddress(){
         return streetAddress;
     }
     public String getCity(){
         return city;
     }
     public String getState(){
         return state;
     }
     public String getZip(){
         return zip;
     }
     public String getPhoneNumber(){
         return phoneNumber;
     }
}
