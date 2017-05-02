package com.my.pack;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUDI = 1L;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isSubscribedToNewsLetter() {
        return subscribedToNewsLetter;
    }

    public void setSubscribedToNewsLetter(boolean subscribedToNewsLetter) {
        this.subscribedToNewsLetter = subscribedToNewsLetter;
    }

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Date birthDate;
    private boolean subscribedToNewsLetter;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
