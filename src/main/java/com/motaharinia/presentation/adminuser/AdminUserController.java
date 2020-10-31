package com.motaharinia.presentation.adminuser;

import com.motaharinia.business.adminuser.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:14:55 <br>
 * Description: کلاس کنترلر ادمین
 */

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @PostMapping("/adminUser")
    public ResponseEntity<AdminUserModel> create(@RequestBody AdminUserModel adminUserModel) {
        return new ResponseEntity<>(adminUserService.create(adminUserModel), HttpStatus.OK);
    }

    @GetMapping("/adminUser/{id}")
    public ResponseEntity<AdminUserModel> readById(@PathVariable("id") String id) throws Exception {
        System.out.println("Before Service................");
        AdminUserModel adminUserModel=adminUserService.readById(id);
        System.out.println("After Service................");
        return new ResponseEntity<>(adminUserModel, HttpStatus.OK);
    }

    @GetMapping("/adminUser/username/{username}")
    public ResponseEntity<List<AdminUserModel>> readByUsername(@PathVariable(required = false) String username) {
        return new ResponseEntity<>(adminUserService.readByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/adminUser/lastName/{lastName}")
    public ResponseEntity<List<AdminUserModel>> readByLastName(@PathVariable(required = false) String lastName) {
        return new ResponseEntity<>(adminUserService.readByLastName(lastName), HttpStatus.OK);
    }


    @PutMapping("/adminUser")
    public ResponseEntity<AdminUserModel> update(@RequestBody AdminUserModel adminUserModel) throws Exception {
        return new ResponseEntity<>(adminUserService.update(adminUserModel), HttpStatus.OK);
    }

    @DeleteMapping("/adminUser/{id}")
    public ResponseEntity<AdminUserModel> delete(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<>(adminUserService.delete(id), HttpStatus.OK);
    }


}
