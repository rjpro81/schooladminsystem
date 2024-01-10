/**
 * 
 */
package com.elimullc.busybee;


/**
 * @author Ralph Julsaint
 *Class Faculty creates a Faculty object from class FacultyMember
 */

public class Faculty {
    //instance variable
    private FacultyMember[] facultyMembers;
    /**
     * constructor that accepts FacultyMember array object
     * @param facultyMembers 
     */
    public Faculty (FacultyMember[] facultyMembers) {
	this.facultyMembers = facultyMembers;		
    }
    /**
     * sets FacultyMember array
     * @param facultyMembers 
     */
    public void setFaculty(FacultyMember[] facultyMembers) {
	this.facultyMembers = facultyMembers;
    }
    /**
     * gets FacultyMember array
     * @return 
     */
    public FacultyMember[] getFaculty(){
        return facultyMembers;
    }

}
