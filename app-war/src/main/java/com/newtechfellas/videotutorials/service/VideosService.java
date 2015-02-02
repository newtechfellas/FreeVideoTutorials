package com.newtechfellas.videotutorials.service;

import com.newtechfellas.videotutorials.data.VideoCategoryEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/31/15.
 * Time: 9:10 PM
 */
public interface VideosService {
    List<VideoCategoryEntity> getAllCategories();
}
