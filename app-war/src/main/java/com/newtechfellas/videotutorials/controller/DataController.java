package com.newtechfellas.videotutorials.controller;

import com.newtechfellas.videotutorials.data.VideoCourseEntity;
import com.newtechfellas.videotutorials.repository.VideosRepository;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 2/5/15.
 * Time: 1:46 PM
 */

// This controller is created for temporary needs to expose Rest APIs around the data layer so that we could
// modify the data as needed. We would need to have a dedicated Admin UI to offer this service. For now due to lack of
// time, will use Chrome's POSTMAN app to invoke Rest APIs to feed the data

@RestController
@RequestMapping("/data")
public class DataController {

    //TODO: Should use service
    private VideosRepository videoRepository;

    @RequestMapping(value = "allvideos", produces = "application/json", method = GET)
    public
    @ResponseBody
    List<VideoCourseEntity> getAllVideos() {
        return videoRepository.getAllVideos();
    }

    @RequestMapping(value = "courseVideo", consumes = "application/json", method = POST)
    public
    @ResponseBody
    ResponseEntity createVideo(@RequestBody VideoCourseEntity videoCourseEntity) {
        List<Long> ids = videoRepository.save(Arrays.asList(videoCourseEntity));
        return new ResponseEntity<List<Long>>(ids, HttpStatus.OK);
    }

    @RequestMapping(value = "courseVideo/{id}", method = DELETE)
    public
    @ResponseBody
    ResponseEntity deleteVideo(@PathVariable("id") Long id) {
        videoRepository.delete(id);
        return new ResponseEntity<String>("Successfully deleted video with id " + id, HttpStatus.OK);
    }

    @RequestMapping(value = "courseVideo/category/{category}", produces = "application/json", method = GET)
    public
    @ResponseBody
    List<VideoCourseEntity> getVideosForCategory(@PathVariable("category") @NotEmpty String category) {
        return videoRepository.getVideosForCategory(category);
    }

    @RequestMapping(value = "courseVideo/technology/{technology}", produces = "application/json", method = GET)
    public
    @ResponseBody
    List<VideoCourseEntity> getVideosForTechnology(@PathVariable("technology") @NotEmpty String technology) {
        return videoRepository.getVideosForTechnology(technology);
    }

    @RequestMapping(value = "courseVideo/category/{category}/technology/{technology}", produces = "application/json", method = GET)
    public
    @ResponseBody
    List<VideoCourseEntity> getVideosForCategoryAndTechnology(@PathVariable("category") @NotEmpty String category,
                                                              @PathVariable("technology") @NotEmpty String technology) {
        return videoRepository.getVideosForCategoryAndTechnology(category, technology);
    }

    public VideosRepository getVideoRepository() {
        return videoRepository;
    }

    public void setVideoRepository(VideosRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
}