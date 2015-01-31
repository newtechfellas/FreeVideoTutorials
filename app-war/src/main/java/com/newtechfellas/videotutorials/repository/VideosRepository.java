package com.newtechfellas.videotutorials.repository;

import com.newtechfellas.videotutorials.data.VideoEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 10:48 PM
 */
public interface VideosRepository {
    List<VideoEntity> getVideosForCategory(String category);
    List<VideoEntity> getVideosForTechnology(String technology);
    List<VideoEntity> getVideosForCategoryAndTechnology(String category, String technology);
    List<Long> save(List<VideoEntity> videoEntities);
    void delete(Long id);
}
