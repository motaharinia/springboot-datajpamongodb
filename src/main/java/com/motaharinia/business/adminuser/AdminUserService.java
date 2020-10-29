package com.motaharinia.business.adminuser;


import com.motaharinia.presentation.controller.adminuser.AdminUserModel;

import java.util.List;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:18:40 <br>
 * Description: کلاس اینترفیس سرویس ادمین
 */

public interface AdminUserService {
    /**
     * این متد مدل ثبت را دریافت میکند و آن را ثبت میکند
     * @param adminUserModel مدل ادمین
     * @return خروجی: مدل ادمین ثبت شده
     */
    AdminUserModel create(AdminUserModel adminUserModel);

    /**
     * این متد شناسه را دریافت میکند و مدل ادمین متناظر را خروجی میدهد
     * @param id شناسه
     * @return خروجی: مدل ادمین جستجو شده متناظر
     */
    AdminUserModel readById(Integer id) throws Exception;

    /**
     * این متد وضعیت انتشار ادمین را دریافت میکند و لیست مدلهای ادمین متناظر را خروجی میدهد
     * @param published وضعیت انتشار ادمین
     * @return خروجی: مدل ادمینهای جستجو شده متناظر
     */
    List<AdminUserModel> readByPublished(Boolean published);

    /**
     * این متد عنوان ادمین را دریافت میکند و لیست مدلهای ادمین متناظر را خروجی میدهد
     * @param title عنوان
     * @return خروجی: مدل ادمینهای جستجو شده متناظر
     */
    List<AdminUserModel> readByTitle(String title) ;

    /**
     * این متد مدل ویرایش را دریافت میکند و آن را ویرایش میکند
     * @param adminUserModel مدل ویرایش
     * @return خروجی: مدل ادمین ویرایش شده
     */
    AdminUserModel update(AdminUserModel adminUserModel) throws Exception;

    /**
     * این متد شناسه را دریافت میکند و مدل آن را حذف میکند
     * @param id شناسه
     * @return خروجی: مدل ادمین حذف شده
     */
    AdminUserModel delete(Integer id) throws Exception;
}
