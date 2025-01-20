package com.alura.ForoHub.repository.topic;

import com.alura.ForoHub.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByCursoId(Long cursoId);

    List<Topic> findByUserId(Long userId);

    List<Topic> findByStatus(String status);
}
