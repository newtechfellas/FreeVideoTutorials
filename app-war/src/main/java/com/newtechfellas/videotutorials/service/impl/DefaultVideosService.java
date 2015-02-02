package com.newtechfellas.videotutorials.service.impl;

import com.newtechfellas.videotutorials.data.VideoCategoryEntity;
import com.newtechfellas.videotutorials.repository.CategoryRepository;
import com.newtechfellas.videotutorials.service.VideosService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/31/15.
 * Time: 9:11 PM
 */
public class DefaultVideosService implements VideosService {

    private CategoryRepository categoryRepository;


    @Override
    public List<VideoCategoryEntity> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
