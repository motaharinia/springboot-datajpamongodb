package com.motaharinia.presentation.controller.adminuser;

import com.motaharinia.persistence.orm.adminuser.AdminUser;

import java.util.Date;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:19:34 <br>
 * Description: <br>
 */
public class AdminUserModel extends AdminUser {

    public AdminUserModel(Integer id, String username, String password, String firstName, String lastName, Date dateOfBirth) {
        super(username, password, firstName, lastName, dateOfBirth);
        this.setId(id);
    }

    public AdminUserModel() {
    }
}
