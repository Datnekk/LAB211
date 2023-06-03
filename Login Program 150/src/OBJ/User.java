/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJ;

import java.util.Date;

/**
 *
 * @author quang
 */
public class User {
    private String Username;
    private String Password;
    private String Name;
    private String Phone;
    private String EmailAddress;
    private String DOB;

    public User() {
    }

    public User(String Username, String Password, String Name, String Phone, String EmailAddress, String DOB) {
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Phone = Phone;
        this.EmailAddress = EmailAddress;
        this.DOB = DOB;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return String.format("%10s %-10s %10s %-15s %20s %20s",Username,Password,Name,Phone,EmailAddress,DOB);
    }
    
    
}
