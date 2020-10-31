package com.motaharinia.presentation.adminuser;



import com.motaharinia.msutility.customfield.CustomDate;

import java.io.Serializable;


/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-06-12<br>
 * Time: 01:05:58<br>
 * Description:<br>
 *  کلاس مدل ادمین
 */
public class AdminUserModel implements Serializable {
    /**
     * شناسه
     */
    private String id;

    /**
     * نام کاربری
     */
    private String username;

    /**
     * رمز عبور
     */
    private String password;

    /**
     * نام
     */
    private String firstName;

    /**
     * نام خانوادگی
     */
    private String lastName;

    /**
     * تاریخ تولد
     */
    private CustomDate dateOfBirth;


    public AdminUserModel() {
    }

    public AdminUserModel(String id,String username, String password, String firstName, String lastName, CustomDate dateOfBirth) {
        this.setId(id);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "AdminUserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }


    //getter-setter:

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public CustomDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(CustomDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
