package com.example.forohub.controller;

import com.example.forohub.model.Topic;
import com.example.forohub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        if (topic != null) {
            return ResponseEntity.ok(topic);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        Topic updatedTopic = topicService.updateTopic(id, topicDetails);
        if (updatedTopic != null) {
            return ResponseEntity.ok(updatedTopic);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
