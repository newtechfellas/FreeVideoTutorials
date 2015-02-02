package com.newtechfellas.videotutorials.repository;

import com.newtechfellas.videotutorials.data.VideoCourseEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 10:48 PM
 */
public interface VideosRepository {
    long getTotalVideosCount();
    List<VideoCourseEntity> searchVideos(List<String> searchStrings);
    List<VideoCourseEntity> getVideosForCategory(String category);
    List<VideoCourseEntity> getVideosForTechnology(String technology);
    List<VideoCourseEntity> getVideosForCategoryAndTechnology(String category, String technology);
    List<Long> save(List<VideoCourseEntity> videoEntities);
    void delete(Long id);
}
