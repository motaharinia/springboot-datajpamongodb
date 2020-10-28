package com.motaharinia.presentation.controller.tutorial;

import com.motaharinia.business.tutorial.TutorialService;
import com.motaharinia.persistence.orm.tutorial.Tutorial;
import com.motaharinia.persistence.orm.tutorial.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:14:55 <br>
 * Description: کلاس کنترلر راهنما
 */

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @PostMapping("/tutorial")
    public ResponseEntity<TutorialModel> create(@RequestBody TutorialModel tutorialModel) {
        return new ResponseEntity<>(tutorialService.create(tutorialModel), HttpStatus.CREATED);
    }

    @GetMapping("/tutorial/{id}")
    public ResponseEntity<TutorialModel> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(tutorialService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/tutorial/published")
    public ResponseEntity<List<TutorialModel>> readByPublished() {
        return new ResponseEntity<>(tutorialService.readByPublished(true), HttpStatus.OK);
    }

    @GetMapping("/tutorial/title/{title}")
    public ResponseEntity<List<TutorialModel>> readByTitle(@PathVariable(required = false) String title) {
        return new ResponseEntity<>(tutorialService.readByTitle(title), HttpStatus.OK);
    }


    @PutMapping("/tutorial")
    public ResponseEntity<TutorialModel> update(@RequestBody TutorialModel tutorialModel) throws Exception {
        return new ResponseEntity<>(tutorialService.update(tutorialModel), HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<TutorialModel> delete(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(tutorialService.delete(id), HttpStatus.OK);
    }


}
