
package com.elimullc.busybee;

/**
 * The purpose of this class is to create user objects to keep track of session user
 * @author Ralph Julsaint
 */
public class User {
    //instance variables
    private static String username;
    private String password;
    /**
     * No argument constructor
     */
    public User(){
    
    }
    /**
     * Two argument constructor that initializes instance variables
     * @param username
     * @param password 
     */
    public User(final String username, final String password){
        this.username = username;
        this.password = password;
    }
    /**
     * Sets the value of username
     * @param username 
     */
    public void setUsername(String username){
        this.username = username;
    }
    /**
     * Sets the value of password
     * @param password 
     */
    public void setPassword(String password){
        this.password = password;
    }
    /**
     * Gets the value of username
     * @return 
     */
    public String getUsername(){
        return username;
    }
    /**
     * Gets the value of password;
     * @return 
     */
    public String getPassword(){
        return password;
    }
}
