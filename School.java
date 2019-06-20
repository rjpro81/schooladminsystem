package studinfomgmtsys;
/**
 * class School creates a school object that produces data about the school
 */
 
 public class School{
     //instance variables
   private static String schoolID;
   private static String schoolName;
   private String schoolPrincipal;
   private String schoolGradeLevel;
   private String schoolType;
   private String schoolDistrict;
   private String schoolAddress;
   private String schoolCity;
   private String schoolState;
   private static String schoolZip;
   private String schoolPhoneNumber;
   private String schoolEmail;
   
    /**
     * constructor that initializes instance variables
     * @param schoolName
     * @param schoolType
     * @param schoolGradeLevel
     * @param schoolDistrict
     * @param schoolAddress
     * @param schoolPrincipal
     * @param schoolCity
     * @param schoolState
     * @param schoolZip
     * @param schoolPhoneNumber
     * @param schoolEmail
     */
   public School(String schoolName, String schoolPrincipal, String schoolGradeLevel, String schoolType, String schoolDistrict, 
   String schoolAddress, String schoolCity, String schoolState, String schoolZip, String schoolPhoneNumber, String schoolEmail){
	  this.schoolName = schoolName;
	  this.schoolType = schoolType;
          this.schoolGradeLevel =  schoolGradeLevel;
	  this.schoolDistrict = schoolDistrict;
	  this.schoolAddress = schoolAddress;
	  this.schoolPrincipal = schoolPrincipal;  
          this.schoolCity = schoolCity;
          this.schoolState = schoolState;
          this.schoolZip = schoolZip;
          this.schoolPhoneNumber = schoolPhoneNumber;
          this.schoolEmail = schoolEmail;
   }
   public School(String schoolID, String schoolName, String schoolPrincipal, String schoolGradeLevel, String schoolType, String schoolDistrict, 
   String schoolAddress, String schoolCity, String schoolState, String schoolZip, String schoolPhoneNumber, String schoolEmail){
          this.schoolID = schoolID;
	  this.schoolName = schoolName;
	  this.schoolType = schoolType;
          this.schoolGradeLevel =  schoolGradeLevel;
	  this.schoolDistrict = schoolDistrict;
	  this.schoolAddress = schoolAddress;
	  this.schoolPrincipal = schoolPrincipal;  
          this.schoolCity = schoolCity;
          this.schoolState = schoolState;
          this.schoolZip = schoolZip;
          this.schoolPhoneNumber = schoolPhoneNumber;
          this.schoolEmail = schoolEmail;
   }
    public School(){
   
   }
   /**
    * sets school name
    * @param schoolName 
    */
   public void setSchoolName(String schoolName){
	 this.schoolName = schoolName;   
   }
   /**
    * gets school name
    * @return 
    */
   public String getSchoolName(){
	  return schoolName;   
   }
   /**
    * sets school type
    * @param schoolType 
    */
   public void setSchoolType(String schoolType){
	  this.schoolType = schoolType;   
   }
   /**
    * get school type
    * @return 
    */
   public String getSchoolType(){
	  return schoolType;   
   }
   public void setSchoolGradeLevel(String schoolGradeLevel){
       this.schoolGradeLevel = schoolGradeLevel;
   }
   public String getSchoolGradeLevel(){
       return schoolGradeLevel;
   }
   /**
    * set school district
    * @param schoolDistrict 
    */
   public void setSchoolDistrict(String schoolDistrict){
	  this.schoolDistrict = schoolDistrict;   
   }
   /**
    * get school district
    * @return 
    */
   public String getSchoolDistrict(){
	 return schoolDistrict;   
   }
   /**
    * set school address
    * @param schoolAddress 
    */
   public void setSchoolAddress(String schoolAddress){
	  this.schoolAddress = schoolAddress;   
   }
   /**
    * get school address
    * @return 
    */
   public String getSchoolAddress(){
	  return schoolAddress;   
   }
   /**
    * set school administrator 
     * @param schoolPrincipal
    */
   public void setSchoolPrincipal(String schoolPrincipal){
	  this.schoolPrincipal = schoolPrincipal;   
   }
   /**
    * get school administrator
    * @return 
    */
   public String getSchoolPrincipal(){
	  return schoolPrincipal;   
   } 
   public void setSchoolCity(String schoolCity){
       this.schoolCity = schoolCity;
   }
   public String getSchoolCity(){
       return schoolCity;
   }
   public void setSchoolState(String schoolState){
       this.schoolState = schoolState;
   }
   public String getSchoolState(){
       return schoolState;
   }
   public void setSchoolZip(String schoolZip){
       this.schoolZip = schoolZip;
   }
   public String getSchoolZip(){
       return schoolZip;
   }
   public void setPhoneNumber(String schoolPhoneNumber){
       this.schoolPhoneNumber = schoolPhoneNumber;
   }
   public String getPhoneNumber(){
       return schoolPhoneNumber;
   }

    /**
     *
     * @param schoolEmail
     */
    public void setEmail(String schoolEmail){
       this.schoolEmail = schoolEmail;
   }
    /**
     * Method that returns email value
     * @return 
     */
   public String getEmail(){
       return schoolEmail;
   }
   /**
    * 
    * @return returns the value of schoolID
    */
   public String getSchoolID(){
       return schoolID;
   }
   
 }
