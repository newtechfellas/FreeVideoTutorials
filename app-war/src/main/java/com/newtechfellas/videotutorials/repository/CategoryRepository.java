package com.newtechfellas.videotutorials.repository;

import com.newtechfellas.videotutorials.data.VideoCategoryEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/31/15.
 * Time: 12:12 AM
 */
public interface CategoryRepository {
    List<VideoCategoryEntity> getAllCategories();
    List<Long> save(List<VideoCategoryEntity> categories);
    void delete(Long id);
}
