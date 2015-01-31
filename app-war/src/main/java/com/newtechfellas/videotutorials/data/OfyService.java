package com.newtechfellas.videotutorials.data;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Registering the entity classes with app engine
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 8/16/14.
 * Time: 5:34 PM
 */
public class OfyService {
    static {
        factory().register(VideoCategoryEntity.class);
        factory().register(VideoEntity.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
