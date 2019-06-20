package studinfomgmtsys;
/**
 * Class FacultyMember provides data about faculty member and will be used
 * to assign students to a teacher
 */
 
 public class FacultyMember extends Person{
   //instance variables
   private String employeeID;
   private String credentials;
   private String gradeLevel;
   
   /**
    * constructor that initializes instance variables
     * @param firstName
     * @param lastName
     * @param age
     * @param birthDate
     * @param streetAddress
     * @param city
     * @param state
     * @param zip
     * @param phoneNumber
     * @param credentials
    * @param gradeLevel 
    */
   public FacultyMember(final String firstName, final String lastName, String age, final String birthDate, String streetAddress, String city,
           String state, String zip, String phoneNumber, String credentials, String gradeLevel){
     super(firstName, lastName, age, birthDate, streetAddress, city, state, zip, phoneNumber);
     this.credentials = credentials;
     this.gradeLevel = gradeLevel;
   }
   
   public FacultyMember(final String employeeID, final String firstName, final String lastName, String age, String birthDate, String streetAddress, String city,
           String state, String zip, String phoneNumber, String credentials, String gradeLevel){
     super(firstName, lastName, age, birthDate, streetAddress, city, state, zip, phoneNumber);
     this.credentials = credentials;
     this.gradeLevel = gradeLevel;
     this.employeeID = employeeID;
   }
   

   /**
    * This getter method returns the value of an employeeID
    * @return 
    */
   public String getEmployeeID(){
       return employeeID;
   }
   
   /**
    * sets credentials
    * @param credentials 
    */
   public void setCredentials(String credentials){
     this.credentials = credentials;   
   }
   /**
    * gets credentials
    * @return 
    */
   public String getCredentials(){
	 return credentials;   
   }
   /**
    * sets grade level
    * @param gradeLevel 
    */
   public void setGradeLevel(String gradeLevel){
	  this.gradeLevel = gradeLevel;   
   }
   /**
    * gets grade level
    * @return 
    */
   public String getGradeLevel(){
	  return gradeLevel;   
   }
 }
