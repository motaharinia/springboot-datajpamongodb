package com.motaharinia.presentation.controller.tutorial;

import com.motaharinia.persistence.orm.tutorial.Tutorial;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:19:34 <br>
 * Description: <br>
 */
public class TutorialModel extends Tutorial {
    public TutorialModel(Integer id,String title, String description, boolean published) {
        super(title, description, published);
        this.setId(id);
    }

    public TutorialModel() {
    }
}
