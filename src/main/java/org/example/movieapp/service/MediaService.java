package org.example.movieapp.service;

import org.example.movieapp.model.Media;
import org.example.movieapp.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {
    @Autowired
    private MediaRepository mediaRepository;


    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Media getMediaById(Long id) {
        return mediaRepository.findById(id).orElse(null);
    }

    public void addNewMedia(Media media) {
        mediaRepository.save(media);
    }

    public void updateMedia(Media media) {
        mediaRepository.save(media);
    }

    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }

}

