package com.motaharinia.business.tutorial;


import com.motaharinia.presentation.controller.tutorial.TutorialModel;

import java.util.List;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:18:40 <br>
 * Description: کلاس اینترفیس سرویس راهنما
 */

public interface TutorialService {
    /**
     * این متد مدل ثبت را دریافت میکند و آن را ثبت میکند
     * @param tutorialModel مدل راهنما
     * @return خروجی: مدل راهنمای ثبت شده
     */
    TutorialModel create(TutorialModel tutorialModel);

    /**
     * این متد شناسه را دریافت میکند و مدل راهنما متناظر را خروجی میدهد
     * @param id شناسه
     * @return خروجی: مدل راهنمای جستجو شده متناظر
     */
    TutorialModel readById( Integer id) throws Exception;

    /**
     * این متد وضعیت انتشار راهنما را دریافت میکند و لیست مدلهای راهنمای متناظر را خروجی میدهد
     * @param published وضعیت انتشار راهنما
     * @return خروجی: مدل راهنماهای جستجو شده متناظر
     */
    List<TutorialModel> readByPublished(Boolean published);

    /**
     * این متد عنوان راهنما را دریافت میکند و لیست مدلهای راهنمای متناظر را خروجی میدهد
     * @param title عنوان
     * @return خروجی: مدل راهنماهای جستجو شده متناظر
     */
    List<TutorialModel> readByTitle(String title) ;

    /**
     * این متد مدل ویرایش را دریافت میکند و آن را ویرایش میکند
     * @param tutorialModel مدل ویرایش
     * @return خروجی: مدل راهنمای ویرایش شده
     */
    TutorialModel update(TutorialModel tutorialModel) throws Exception;

    /**
     * این متد شناسه را دریافت میکند و مدل آن را حذف میکند
     * @param id شناسه
     * @return خروجی: مدل راهنمای حذف شده
     */
    TutorialModel delete(Integer id) throws Exception;
}
