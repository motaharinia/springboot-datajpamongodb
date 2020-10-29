package com.motaharinia.persistence.orm.adminuser;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;


/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:12:23 <br>
 * Description: کلاس کالکشن ادمین
 */

@Document(collection = "admin_user")
public class AdminUser {
    /**
     * شناسه
     */
    @Id
    @Field(name = "id")
    private Integer id;

    /**
     * نام کاربری
     */
    @Field(name = "username")
    private String username;

    /**
     * رمز عبور
     */
    @Field(name = "password")
    private String password;

    /**
     * نام
     */
    @Field(name = "first_name")
    private String firstName;

    /**
     * نام خانوادگی
     */
    @Field(name = "last_name")
    private String lastName;


    /**
     *تاریخ تولد
     */
    @Field(name = "date_of_birth", targetType  = FieldType.DATE_TIME)
    private Date dateOfBirth;


    public AdminUser() {
    }

    public AdminUser(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }


    //getter-setter:

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
