package br.com.iwe.springstudydatalake.repository;

import br.com.iwe.springstudydatalake.model.Study;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRepository extends CrudRepository<Study, Long> {

    List<Study> findByTopic(String topic);
}
