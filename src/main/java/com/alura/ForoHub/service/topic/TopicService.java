package com.alura.ForoHub.service.topic;

import com.alura.ForoHub.domain.topic.Topic;
import com.alura.ForoHub.repository.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    // Obtener todos los topics
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    // Obtener topic por ID
    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    // Crear topic
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    // Actualizar topic
    public Topic updateTopic(Long id, Topic topicDetails) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            Topic existingTopic = topic.get();
            existingTopic.setTitle(topicDetails.getTitle());
            existingTopic.setMessage(topicDetails.getMessage());
            existingTopic.setStatus(topicDetails.getStatus());
            return topicRepository.save(existingTopic);
        }
        return null;
    }

    // Eliminar topic
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    // Obtener topics por curso
    public List<Topic> getTopicsByCurso(Long cursoId) {
        return topicRepository.findByCursoId(cursoId);
    }

    // Obtener topics por usuario
    public List<Topic> getTopicsByUser(Long userId) {
        return topicRepository.findByUserId(userId);
    }
}
