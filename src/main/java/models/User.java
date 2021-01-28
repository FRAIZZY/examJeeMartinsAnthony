/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author HB
 */
public class User {
    private Integer id;
    private String login;
    private String password;
    private String role;
    private String lastname;
    private String firstname;
    private Date dateEntryCompany;
    private String phone;
    private String imageLink;
    
    public User(String login, String password, String role, String lastname, String firstname, Date dateEntryCompany, String phone, String imageLink) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.lastname = lastname;
        this.firstname = firstname;
        this.dateEntryCompany = dateEntryCompany;
        this.phone = phone;
        this.imageLink = imageLink;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getLogin() {
        return this.login;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public Date getDateEntryCompany() {
        return this.dateEntryCompany;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public String getImageLink() {
        return this.imageLink;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setDateEntryCompany(Date dateEntryCompany) {
        this.dateEntryCompany = dateEntryCompany;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
