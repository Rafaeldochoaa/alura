package com.example.forohub.service;

import com.example.forohub.model.Topic;
import com.example.forohub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, Topic topicDetails) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic != null) {
            topic.setTitulo(topicDetails.getTitulo());
            topic.setMensaje(topicDetails.getMensaje());
            topic.setFechaCreacion(topicDetails.getFechaCreacion());
            topic.setStatus(topicDetails.getStatus());
            topic.setAutor(topicDetails.getAutor());
            topic.setCurso(topicDetails.getCurso());
            return topicRepository.save(topic);
        }
        return null;
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
