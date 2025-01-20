package com.alura.ForoHub.controller.topic;

import com.alura.ForoHub.domain.topic.Topic;
import com.alura.ForoHub.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicService.getTopicById(id);
        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@Valid @RequestBody Topic topic) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicService.createTopic(topic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @Valid @RequestBody Topic topic) {
        Topic updatedTopic = topicService.updateTopic(id, topic);
        return updatedTopic != null ? ResponseEntity.ok(updatedTopic) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/curso/{cursoId}")
    public List<Topic> getTopicsByCurso(@PathVariable Long cursoId) {
        return topicService.getTopicsByCurso(cursoId);
    }

    @GetMapping("/user/{userId}")
    public List<Topic> getTopicsByUser(@PathVariable Long userId) {
        return topicService.getTopicsByUser(userId);
    }
}
