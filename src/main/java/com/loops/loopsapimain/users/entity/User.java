package com.loops.loopsapimain.users.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_email")
    @NotEmpty
    private String userEmail;

    @Column(name = "user_password")
    @Size(min = 6)
    @NotEmpty
    private String userPassword;

    @Column(name = "user_name")
    @NotEmpty
    private String userName;

    @Column(name = "user_phonenum")
    @NotEmpty
    private String userPhoneNum;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_province")
    private String userPovince;

    @Column(name = "user_city")
    private String userCity;

    @Column(name = "user_postcode")
    private String userPostCode;

    @Column(name = "user_country")
    private String userCountry;

    @Column(name = "user_gender")
    @NotEmpty
    private String userGender;

    @Column(name = "user_balance")
    private Long userBalance = Long.valueOf(0);


    //AN EMPTY CONSTRUCTOR OF THE CLASS

    public User() {
    }

    //ALL OF THE CONSTRUCTOR

    public User(Long userId, String userEmail, String userPassword, String userName, String userPhoneNum, String userAddress, String userPovince, String userCity, String userPostCode, String userCountry, String userGender, Long userBalance) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhoneNum = userPhoneNum;
        this.userAddress = userAddress;
        this.userPovince = userPovince;
        this.userCity = userCity;
        this.userPostCode = userPostCode;
        this.userCountry = userCountry;
        this.userGender = userGender;
        this.userBalance = userBalance;
    }

    //ALL THE GETTER AND SETTER ARE BELOW

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPovince() {
        return userPovince;
    }

    public void setUserPovince(String userPovince) {
        this.userPovince = userPovince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPostCode() {
        return userPostCode;
    }

    public void setUserPostCode(String userPostCode) {
        this.userPostCode = userPostCode;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Long getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Long userBalance) {
        this.userBalance = userBalance;
    }


}
