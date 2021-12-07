package br.com.iwe.springstudydatalake.service;

import br.com.iwe.springstudydatalake.model.Study;
import br.com.iwe.springstudydatalake.repository.StudyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyService {

    private final StudyRepository repository;

    public StudyService(StudyRepository repository) {
        this.repository = repository;
    }

    public Study create (final Study study) {
        return this.repository.save(study);
    }

    public List<Study> getStudiesByTopic(final String topic) {
        return this.repository.findByTopic(topic);
    }
}
