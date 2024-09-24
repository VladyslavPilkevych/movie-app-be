package org.example.movieapp.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.movieapp.model.Media;
import org.example.movieapp.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateMedia(Long id, Media media) {
        Optional<Media> existingMediaOptional = mediaRepository.findById(id);

        if (existingMediaOptional.isPresent()) {
            Media existingMedia = existingMediaOptional.get();

            existingMedia.setTitle(media.getTitle());
            existingMedia.setDescription(media.getDescription());
            existingMedia.setPopularity(media.getPopularity());
            existingMedia.setYear(media.getYear());
            existingMedia.setDuration(media.getDuration());
            existingMedia.setContentType(media.getContentType());
            existingMedia.setGenre(media.getGenre());
            existingMedia.setAdult(media.isAdult());
            existingMedia.setReleaseDate(media.getReleaseDate());
            existingMedia.setImagePath(media.getImagePath());
            existingMedia.setPosterPath(media.getPosterPath());

            mediaRepository.save(existingMedia);
        } else {
            throw new EntityNotFoundException("Media with ID " + id + " not found.");
        }
    }

    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }

}

