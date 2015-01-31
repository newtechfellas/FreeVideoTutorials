package com.newtechfellas.videotutorials.repository.impl;

import com.newtechfellas.videotutorials.data.VideoCategoryEntity;
import com.newtechfellas.videotutorials.repository.CategoryRepository;

import java.util.List;

import static com.newtechfellas.videotutorials.repository.impl.RepositoryUtil.findEntities;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/31/15.
 * Time: 12:13 AM
 */
public class DefaultCategoryRepository implements CategoryRepository {

    @Override
    public List<VideoCategoryEntity> getAllCategories() {
        return findEntities(VideoCategoryEntity.class);
    }

    @Override
    public List<Long> save(List<VideoCategoryEntity> categories) {
        return RepositoryUtil.save(categories);
    }

    @Override
    public void delete(Long id) {
        RepositoryUtil.delete(id, VideoCategoryEntity.class);
    }
}