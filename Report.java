
package studinfomgmtsys;

/**
 * The purpose of this class is to create report objects that will allow the application to display reports
 * @author Ralph Julsaint
 */
public class Report {
    //instance variables
    private String teacherFirstName;
    private String teacherLastName;
    private String studentFirstName;
    private String studentLastName;
    private String schoolName;
    private double readingAverages;
    private double mathAverages;
    private double scienceAverages;
    private double socialStudiesAverages;
    private String studentID;
    private String employeeID;
    
    private final String schoolReportQuery = "SELECT readingAverage, mathAverage, scienceAverage, socialStudiesAverage FROM grades";
    
   
    public Report(){
            
    }
    public Report(String teacherFirstName, String teacherLastName, String studentFirstName, String studentLastName, double readingAverages, double mathAverages, double scienceAverages, double socialStudiesAverages, String studentID, String employeeID){
        this.readingAverages = readingAverages;
        this.mathAverages = mathAverages;
        this.scienceAverages = scienceAverages;
        this.socialStudiesAverages = socialStudiesAverages;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentID = studentID;
        this.employeeID = employeeID;
    }
    public Report (String schoolName, double readingAverages, double mathAverages, double scienceAverages, double socialStudiesAverages){
        this.schoolName = schoolName;
        this.readingAverages = readingAverages;
        this.mathAverages = mathAverages;
        this.scienceAverages = scienceAverages;
        this.socialStudiesAverages = socialStudiesAverages;
    }
    /**
     * This method returns a String of the report data retrieved from the database
     * @param readingAverages 
     */
    void setReadingAverages(double readingAverages){
        this.readingAverages = readingAverages;
    }
    void setMathAverages(double mathAverages){
        this.mathAverages = mathAverages;
    }
    void setScienceAverages(double scienceAverages){
        this.scienceAverages = scienceAverages;
    }
    void setSocialStudiesAverages(double socialStudiesAverages){
        this.socialStudiesAverages = socialStudiesAverages;
    }
    double getReadingAverages(){
        return readingAverages;
    }
    
    double getMathAverages(){
        return mathAverages;
    }
    
    double getScienceAverages(){
        return scienceAverages;
    }
    
    double getSocialStudiesAverages(){
        return socialStudiesAverages;
    }
    void setTeacherFirstName(String teacherFirstName){
        this.teacherFirstName = teacherFirstName;
    }
    void setTeacherLastName(String teacherLastName){
        this.teacherLastName = teacherLastName;
    }
    void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    String getTeacherFirstName(){
        return teacherFirstName;
    }
    String getTeacherLastName(){
        return teacherLastName;
    }
    void setStudentFirstName(String studentFirstName){
        this.studentFirstName = studentFirstName;
    }
    void setStudentLastName(String studentLastName){
        this.studentLastName = studentLastName;
    }
    String getStudentFirstName(){
        return studentFirstName;
    }
    String getStudentLastName(){
        return studentLastName;
    }
    String getSchoolName(){
        return schoolName;
    }
    String getStudentID(){
        return studentID;
    }
    String getEmployeeID(){
        return employeeID;
    }
    String classReportToString(){
        return String.format("Teacher: %s %s%nStudent: %s %s%nReading Average: %.2f%nMath Average: %.2f%nScience Average: %.2f%nSocial Studies Average: %.2f%n%n", getTeacherFirstName(), getTeacherLastName(), getStudentFirstName(), getStudentLastName(), getReadingAverages(), getMathAverages(), getScienceAverages(), getSocialStudiesAverages());
    } 
    String schoolReportToString(){
        return String.format("School Year: 2018-2019%n%nSchool: %s%nReading: %.2f%nMath: %.2f%nScience: %.2f%nSocial Studies: %.2f%n", getSchoolName(), getReadingAverages(), getMathAverages(), getScienceAverages(), getSocialStudiesAverages());
    }
}
