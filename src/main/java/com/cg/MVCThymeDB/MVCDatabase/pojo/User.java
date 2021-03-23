package com.cg.MVCThymeDB.MVCDatabase.pojo;

import java.util.Objects;
import javax.persistence.*;

// Entity annotation marks class as an entity that will be used in the database.
// Table entity tells Spring to generate the table called "users" in the database if one doesn't already exist.
// If it exists, because we're using the create-drop property, the database will be re-created and erased upon
// completion.
@Entity
@Table(name="users")
public class User {

    // The id variable will be used as a PK
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Fields
    @Column(name="First_Name")
    private String firstName;
    @Column(name="Last_Name")
    private String lastName;
    @Column(name="Email_Address")
    private String emailAddress;
    @Column(name="Phone_Number")
    private String phoneNumber;

    // Class needs the default contructor, which doesn't exist if there is already another constructor (which in this case, it does).
    public User(){}

    public User(String firstName, String lastName, String emailAddress, String phoneNumber){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;

    }

    // Getters and Setters, equals, hashcode, toString

    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public int getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof User)) return false;

        User user = (User) o;
        return id==user.id && 
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, emailAddress, phoneNumber);
    }

    @Override
    public String toString(){
        return "User{" + 
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName +  '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            ", phoneNumber=" + phoneNumber + '\'' +
            "}";
    }

    
    
}
