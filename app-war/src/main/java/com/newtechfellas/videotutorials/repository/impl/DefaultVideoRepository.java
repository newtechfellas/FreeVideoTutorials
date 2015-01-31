package com.newtechfellas.videotutorials.repository.impl;

import com.googlecode.objectify.Key;
import com.newtechfellas.videotutorials.data.VideoEntity;
import com.newtechfellas.videotutorials.repository.VideosRepository;

import java.util.*;

import static com.newtechfellas.videotutorials.data.OfyService.ofy;
import static com.newtechfellas.videotutorials.repository.impl.RepositoryUtil.findEntitiesWithFilters;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 11:31 PM
 */
public class DefaultVideoRepository implements VideosRepository {
    @Override
    public List<VideoEntity> getVideosForCategory(final String category) {
        Map filters = new HashMap<>();
        filters.put("category", category);
        return findEntitiesWithFilters(VideoEntity.class, filters);
    }

    @Override
    public List<VideoEntity> getVideosForTechnology(String technology) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("technology", technology);
        return findEntitiesWithFilters(VideoEntity.class, filters);
    }

    @Override
    public List<VideoEntity> getVideosForCategoryAndTechnology(String category, String technology) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("category", category);
        filters.put("technology", technology);
        return findEntitiesWithFilters(VideoEntity.class, filters);
    }

    @Override
    public List<Long> save(List<VideoEntity> videoEntities) {
        return RepositoryUtil.save(videoEntities);
    }

    @Override
    public void delete(Long id) {
        RepositoryUtil.delete(id, VideoEntity.class);
    }
}