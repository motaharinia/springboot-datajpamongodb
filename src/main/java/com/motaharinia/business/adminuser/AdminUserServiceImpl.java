package com.motaharinia.business.adminuser;


import com.motaharinia.msutility.calendar.CalendarTools;
import com.motaharinia.msutility.customfield.CustomDate;
import com.motaharinia.persistence.orm.adminuser.AdminUser;
import com.motaharinia.persistence.orm.adminuser.AdminUserRepository;
import com.motaharinia.presentation.adminuser.AdminUserModel;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:26:11 <br>
 * Description: کلاس پیاده سازی سرویس ادمین
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {


    @Autowired
    AdminUserRepository adminUserRepository;


    /**
     * این متد مدل ثبت را دریافت میکند و آن را ثبت میکند
     *
     * @param adminUserModel مدل ادمین
     * @return خروجی: مدل ادمین ثبت شده
     */
    @Override
    public AdminUserModel create(AdminUserModel adminUserModel) {
        AdminUser adminUser = adminUserRepository.save(new AdminUser(adminUserModel.getUsername(), adminUserModel.getPassword(), adminUserModel.getFirstName(), adminUserModel.getLastName(), CalendarTools.getDateFromCustomDate(adminUserModel.getDateOfBirth())));
        adminUserModel.setId(adminUser.getId());
        return adminUserModel;
    }

    /**
     * این متد شناسه را دریافت میکند و مدل ادمین متناظر را خروجی میدهد
     *
     * @param id شناسه
     * @return خروجی: مدل ادمین جستجو شده متناظر
     */
    @Override
    public AdminUserModel readById(String id) throws Exception {
        Optional<AdminUser> adminUserOptional = adminUserRepository.findById(id);
        System.out.println("id:"+id);
        if (adminUserOptional.isEmpty()) {
            throw new Exception("id is not existed");
        }
        AdminUserModel adminUserModel = new AdminUserModel(adminUserOptional.get().getId(), adminUserOptional.get().getUsername(), adminUserOptional.get().getPassword(), adminUserOptional.get().getFirstName(), adminUserOptional.get().getLastName(),new CustomDate(adminUserOptional.get().getDateOfBirth()) );
        return adminUserModel;
    }

    /**
     * این متد وضعیت انتشار ادمین را دریافت میکند و لیست مدلهای ادمین متناظر را خروجی میدهد
     *
     * @param username وضعیت انتشار ادمین
     * @return خروجی: مدل ادمینهای جستجو شده متناظر
     */
    @Override
    public List<AdminUserModel> readByUsername(String username) {
        List<AdminUserModel> adminUserModelList = new ArrayList<>();
        List<AdminUser> adminUserList = adminUserRepository.findByUsernameLike(username);
        adminUserList.forEach(adminUser -> adminUserModelList.add(new AdminUserModel(adminUser.getId(), adminUser.getUsername(), adminUser.getPassword(), adminUser.getFirstName(), adminUser.getLastName(), new CustomDate(adminUser.getDateOfBirth()))));
        return adminUserModelList;
    }

    /**
     * این متد عنوان ادمین را دریافت میکند و لیست مدلهای ادمین متناظر را خروجی میدهد
     *
     * @param lastName عنوان
     * @return خروجی: مدل ادمینهای جستجو شده متناظر
     */
    @Override
    public List<AdminUserModel> readByLastName(String lastName) {
        List<AdminUserModel> adminUserModelList = new ArrayList<>();
        if (ObjectUtils.isEmpty(lastName)) {
            adminUserRepository.findAll().forEach(adminUser -> adminUserModelList.add(new AdminUserModel(adminUser.getId(), adminUser.getUsername(), adminUser.getPassword(), adminUser.getFirstName(), adminUser.getLastName(), new CustomDate(adminUser.getDateOfBirth()) )));
        } else {
            adminUserRepository.findByLastNameLike(lastName).forEach(adminUser -> adminUserModelList.add(new AdminUserModel(adminUser.getId(), adminUser.getUsername(), adminUser.getPassword(), adminUser.getFirstName(), adminUser.getLastName(), new CustomDate(adminUser.getDateOfBirth()))));
        }
        return adminUserModelList;
    }

    /**
     * این متد مدل ویرایش را دریافت میکند و آن را ویرایش میکند
     *
     * @param adminUserModel مدل ویرایش
     * @return خروجی: مدل ادمین ویرایش شده
     */
    @Override
    public AdminUserModel update(AdminUserModel adminUserModel) throws Exception {
        Optional<AdminUser> adminUserOptional = adminUserRepository.findById(adminUserModel.getId().toString());
        if (adminUserOptional.isEmpty()) {
            throw new Exception("id is not existed");
        }

        AdminUser adminUser = adminUserOptional.get();
        adminUser.setUsername(adminUserModel.getUsername());
        adminUser.setPassword(adminUserModel.getPassword());
        adminUser.setFirstName(adminUserModel.getFirstName());
        adminUser.setLastName(adminUserModel.getLastName());
        adminUser.setDateOfBirth(CalendarTools.getDateFromCustomDate(adminUserModel.getDateOfBirth()));

        return adminUserModel;
    }

    /**
     * این متد شناسه را دریافت میکند و مدل آن را حذف میکند
     *
     * @param id شناسه
     * @return خروجی: مدل ادمین حذف شده
     */
    @Override
    public AdminUserModel delete(String id) throws Exception {
        Optional<AdminUser> adminUserOptional = adminUserRepository.findById(id);
        if (adminUserOptional.isEmpty()) {
            throw new Exception("id is not existed");
        }
        adminUserRepository.deleteById(id.toString());
        AdminUserModel adminUserModel = new AdminUserModel(adminUserOptional.get().getId(), adminUserOptional.get().getUsername(), adminUserOptional.get().getPassword(), adminUserOptional.get().getFirstName(), adminUserOptional.get().getLastName(), new CustomDate(adminUserOptional.get().getDateOfBirth()));
        return adminUserModel;
    }
}
