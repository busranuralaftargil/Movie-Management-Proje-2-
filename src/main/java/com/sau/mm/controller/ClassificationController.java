package com.sau.mm.controller;

import com.sau.mm.dto.ClassificationDTO;
import com.sau.mm.model.Classification;
import com.sau.mm.service.ClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {

    private final static Logger logger = LoggerFactory.getLogger(ClassificationController.class);
    private final ClassificationService classificationService;

    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassificationDTO>> getAllClassifications() {
        return new ResponseEntity<>(classificationService.getAllClassifications(), HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClassificationDTO> addClassification(@RequestBody Classification classification) {
        logger.info("New classification added to the system.");
        return new ResponseEntity<>(classificationService.createClassification(classification), HttpStatus.CREATED);
    }

    // İŞTE POSTMAN'DE ÇALIŞMAYAN KISMIN ÇÖZÜMÜ:
    @GetMapping("/get/{id}")
    public ResponseEntity<ClassificationDTO> getClassificationById(@PathVariable("id") long id) {
        return new ResponseEntity<>(classificationService.getClassificationById(id), HttpStatus.OK);
    }

    // Hocanın örnek projesindeki gibi Update metodu:
    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClassificationDTO> updateClassification(@PathVariable("id") long id, @RequestBody Classification classification) {
        logger.info("Classification updated. ID: " + id);
        return new ResponseEntity<>(classificationService.updateClassification(id, classification), HttpStatus.OK);
    }

    // Hocanın örnek projesindeki gibi Delete metodu:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClassification(@PathVariable("id") long id) {
        logger.info("Classification deleted. ID: " + id);
        classificationService.deleteClassification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}