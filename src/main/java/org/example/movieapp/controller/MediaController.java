package org.example.movieapp.controller;

import jakarta.validation.Valid;
import org.example.movieapp.factory.MediaFactory;
import org.example.movieapp.model.Media;
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
    public Media showMediaById(@PathVariable(name = "id") String mediaId) {
        Long mediaIdLong = Long.parseLong(mediaId);
        Media mediaContentById = mediaService.getMediaById(mediaIdLong);
        return mediaContentById;
    }

    @PostMapping("/create/media")
    public ResponseEntity<?> addMedia(@Valid @RequestBody Media media) {
        try {
            mediaService.addNewMedia(media);

            return new ResponseEntity<>(media.getTitle() + " successfully saved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while saving: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete/media")
    public ResponseEntity<?> removeMedia(@RequestBody String mediaId) {
        Long mediaIdLong = Long.parseLong(mediaId);
        try {
            mediaService.deleteMedia(mediaIdLong);

            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while deleting: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update/media/{id}")
    public ResponseEntity<?> updateMedia(@PathVariable("id") String mediaId, @Valid @RequestBody Media media) {
        Long mediaIdLong = Long.parseLong(mediaId);
        try {
            mediaService.updateMedia(mediaIdLong, media);

            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while updating: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
