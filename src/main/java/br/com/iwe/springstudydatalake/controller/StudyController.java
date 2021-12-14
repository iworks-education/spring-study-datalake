package br.com.iwe.springstudydatalake.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.iwe.springstudydatalake.model.Study;
import br.com.iwe.springstudydatalake.resource.StudyResource;
import br.com.iwe.springstudydatalake.service.StudyService;

@RestController
public class StudyController {

    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @PostMapping("/study")
    @ResponseStatus(HttpStatus.CREATED)
    public StudyResource create(@RequestBody final StudyResource studyResource) {

        final Study study = this.studyService.create(this.getStudyEntity(studyResource));

        return this.getStudyResource(study);
    }

    @GetMapping("/study/findByTopic")
    public List<StudyResource> getByTopic(@RequestParam("topic") final String topic) {

        final List<StudyResource> studiesResource = new ArrayList<>();

        final List<Study> studies = this.studyService.getStudiesByTopic(topic);
        for (Study study : studies) {
            studiesResource.add(this.getStudyResource(study));
        }

        return studiesResource;
    }

    private Study getStudyEntity(final StudyResource studyResource) {
        Study.Builder builder = new Study.Builder();
        builder.topic(studyResource.getTopic());
        builder.tag(studyResource.getTag());
        builder.consumed(studyResource.getConsumed());
        builder.description(studyResource.getDescription());
        builder.url(studyResource.getUrl());
        builder.dateTimeCreation(studyResource.getDateTimeCreation());
        return builder.build();
    }

    private StudyResource getStudyResource(final Study studyEntity) {
        StudyResource.Builder builder = new StudyResource.Builder();
        builder.tag(studyEntity.getTag());
        builder.topic(studyEntity.getTopic());
        builder.url(studyEntity.getUrl());
        builder.consumed(studyEntity.getConsumed());
        builder.description(studyEntity.getDescription());
        builder.dateTimeCreation(studyEntity.getDateTimeCreation());
        return builder.build();
    }
}
