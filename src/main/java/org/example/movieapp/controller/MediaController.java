package org.example.movieapp.controller;

import jakarta.validation.Valid;
import org.example.movieapp.factory.MediaFactory;
import org.example.movieapp.model.Media;
import org.example.movieapp.repository.MediaRepository;
import org.example.movieapp.service.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private MediaRepository mediaRepository;

    final private MediaFactory mediaFactory = new MediaFactory();
    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);

    @GetMapping("/media")
    @ResponseBody
    public List<Media> showMediaList() {
        List<Media> mediaList = mediaService.getAllMedia();
//        movies.forEach(media -> System.out.println(media));
        return mediaList;
    }

    @GetMapping("/media/{id}")
    @ResponseBody
    public Media showMediaById(@PathVariable(name = "id") Long mediaId) {
        Media mediaContentById = mediaService.getMediaById(mediaId);
        return mediaContentById;
    }

    @PostMapping("/create/media")
    public ResponseEntity<?> addMedia(@Valid @RequestBody Media media) {
        try {
            Media savedMedia = mediaRepository.save(media);

            return new ResponseEntity<>(savedMedia.getTitle() + " successfully saved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while saving: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
