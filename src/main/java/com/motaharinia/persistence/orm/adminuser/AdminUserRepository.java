package com.motaharinia.persistence.orm.adminuser;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:12:23 <br>
 * Description: کلاس ریپازیتوری ادمین
 */
public interface AdminUserRepository extends MongoRepository<AdminUser, String> {

    //Now we can use MongoRepository’s methods: save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.
    //We also define custom finder methods:
    //– findByTitleContaining(): returns all Tutorials which title contains input title.
    //– findByPublished(): returns all Tutorials with published having value as input published.


    List<AdminUser> findByUsernameLike(String username);
    List<AdminUser> findByLastNameLike(String lastName);
}
