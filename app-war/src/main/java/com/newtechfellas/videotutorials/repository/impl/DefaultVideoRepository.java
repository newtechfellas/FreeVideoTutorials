package com.newtechfellas.videotutorials.repository.impl;

import com.newtechfellas.videotutorials.data.VideoCourseEntity;
import com.newtechfellas.videotutorials.repository.VideosRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.newtechfellas.videotutorials.repository.impl.RepositoryUtil.findEntitiesWithFilters;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 11:31 PM
 */
public class DefaultVideoRepository implements VideosRepository {
    @Override
    public List<VideoCourseEntity> getVideosForCategory(final String category) {
        Map filters = new HashMap<>();
        filters.put("category", category);
        return findEntitiesWithFilters(VideoCourseEntity.class, filters);
    }

    @Override
    public List<VideoCourseEntity> getVideosForTechnology(String technology) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("technology", technology);
        return findEntitiesWithFilters(VideoCourseEntity.class, filters);
    }

    @Override
    public List<VideoCourseEntity> getVideosForCategoryAndTechnology(String category, String technology) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("category", category);
        filters.put("technology", technology);
        return findEntitiesWithFilters(VideoCourseEntity.class, filters);
    }

    @Override
    public List<Long> save(List<VideoCourseEntity> videoEntities) {
        return RepositoryUtil.save(videoEntities);
    }

    @Override
    public void delete(Long id) {
        RepositoryUtil.delete(id, VideoCourseEntity.class);
    }

    @Override
    public List<VideoCourseEntity> searchVideos(List<String> searchStrings) {
        return null;
    }

    @Override
    public long getTotalVideosCount() {
        return RepositoryUtil.getTotalEntitiesCount(VideoCourseEntity.class);
    }
}