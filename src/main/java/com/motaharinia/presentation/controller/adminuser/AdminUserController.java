package com.motaharinia.presentation.controller.adminuser;

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
    public ResponseEntity<AdminUserModel> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(adminUserService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/adminUser/published")
    public ResponseEntity<List<AdminUserModel>> readByPublished() {
        return new ResponseEntity<>(adminUserService.readByPublished(true), HttpStatus.OK);
    }

    @GetMapping("/adminUser/title/{title}")
    public ResponseEntity<List<AdminUserModel>> readByTitle(@PathVariable(required = false) String title) {
        return new ResponseEntity<>(adminUserService.readByTitle(title), HttpStatus.OK);
    }


    @PutMapping("/adminUser")
    public ResponseEntity<AdminUserModel> update(@RequestBody AdminUserModel adminUserModel) throws Exception {
        return new ResponseEntity<>(adminUserService.update(adminUserModel), HttpStatus.OK);
    }

    @DeleteMapping("/adminUsers/{id}")
    public ResponseEntity<AdminUserModel> delete(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(adminUserService.delete(id), HttpStatus.OK);
    }


}
