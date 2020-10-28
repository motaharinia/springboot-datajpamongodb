package com.motaharinia.business.tutorial;

import com.motaharinia.persistence.orm.tutorial.Tutorial;
import com.motaharinia.persistence.orm.tutorial.TutorialRepository;
import com.motaharinia.presentation.controller.tutorial.TutorialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:26:11 <br>
 * Description: کلاس پیاده سازی سرویس راهنما
 */

@Service
public class TutorialServiceImpl implements TutorialService {


    @Autowired
    TutorialRepository tutorialRepository;


    /**
     * این متد مدل ثبت را دریافت میکند و آن را ثبت میکند
     *
     * @param tutorialModel مدل راهنما
     * @return خروجی: مدل راهنمای ثبت شده
     */
    @Override
    public TutorialModel create(TutorialModel tutorialModel) {
        Tutorial tutorial = tutorialRepository.save(new Tutorial(tutorialModel.getTitle(), tutorialModel.getDescription(), tutorialModel.getPublished()));
        tutorialModel.setId(tutorial.getId());
        return tutorialModel;
    }

    /**
     * این متد شناسه را دریافت میکند و مدل راهنما متناظر را خروجی میدهد
     *
     * @param id شناسه
     * @return خروجی: مدل راهنمای جستجو شده متناظر
     */
    @Override
    public TutorialModel readById(Integer id) throws Exception {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id.toString());
        if (tutorialOptional.isEmpty()) {
            throw new Exception("id is not existed");
        }
        TutorialModel tutorialModel = new TutorialModel(tutorialOptional.get().getId(),tutorialOptional.get().getTitle(),tutorialOptional.get().getDescription(),tutorialOptional.get().getPublished());
        return tutorialModel;
    }

    /**
     * این متد وضعیت انتشار راهنما را دریافت میکند و لیست مدلهای راهنمای متناظر را خروجی میدهد
     *
     * @param published وضعیت انتشار راهنما
     * @return خروجی: مدل راهنماهای جستجو شده متناظر
     */
    @Override
    public List<TutorialModel> readByPublished(Boolean published) {
        List<TutorialModel> tutorialModelList = new ArrayList<>();
        List<Tutorial> tutorialList = tutorialRepository.findByPublished(published);
        tutorialList.forEach(tutorial->tutorialModelList.add(new TutorialModel(tutorial.getId(),tutorial.getTitle(),tutorial.getDescription(),tutorial.getPublished())));
        return tutorialModelList;
    }

    /**
     * این متد عنوان راهنما را دریافت میکند و لیست مدلهای راهنمای متناظر را خروجی میدهد
     *
     * @param title عنوان
     * @return خروجی: مدل راهنماهای جستجو شده متناظر
     */
    @Override
    public List<TutorialModel> readByTitle(String title) {
        List<TutorialModel> tutorialModelList = new ArrayList<>();

        if (ObjectUtils.isEmpty(title) )
            tutorialRepository.findAll().forEach(tutorial->tutorialModelList.add(new TutorialModel(tutorial.getId(),tutorial.getTitle(),tutorial.getDescription(),tutorial.getPublished())));
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorial->tutorialModelList.add(new TutorialModel(tutorial.getId(),tutorial.getTitle(),tutorial.getDescription(),tutorial.getPublished())));

        return tutorialModelList;
    }

    /**
     * این متد مدل ویرایش را دریافت میکند و آن را ویرایش میکند
     *
     * @param tutorialModel مدل ویرایش
     * @return خروجی: مدل راهنمای ویرایش شده
     */
    @Override
    public TutorialModel update(TutorialModel tutorialModel) throws Exception {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(tutorialModel.getId().toString());
        if (tutorialOptional.isEmpty()) {
            throw new Exception("id is not existed");
        }

        Tutorial tutorial = tutorialOptional.get();
        tutorial.setTitle(tutorialModel.getTitle());
        tutorial.setDescription(tutorialModel.getDescription());
        tutorial.setPublished(tutorialModel.getPublished());

        return tutorialModel;
    }

    /**
     * این متد شناسه را دریافت میکند و مدل آن را حذف میکند
     *
     * @param id شناسه
     * @return خروجی: مدل راهنمای حذف شده
     */
    @Override
    public TutorialModel delete(Integer id) throws Exception {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id.toString());
        if (tutorialOptional.isEmpty()) {
            throw new Exception("id is not existed");
        }
        tutorialRepository.deleteById(id.toString());
        TutorialModel tutorialModel = new TutorialModel(tutorialOptional.get().getId(),tutorialOptional.get().getTitle(),tutorialOptional.get().getDescription(),tutorialOptional.get().getPublished());
        return tutorialModel;
    }
}
