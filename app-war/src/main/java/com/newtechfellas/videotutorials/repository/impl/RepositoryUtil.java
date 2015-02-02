package com.newtechfellas.videotutorials.repository.impl;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import java.util.*;

import static com.newtechfellas.videotutorials.data.OfyService.ofy;
import static com.newtechfellas.videotutorials.util.Utils.isEmptyOrNull;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/31/15.
 * Time: 12:14 AM
 */
public class RepositoryUtil {

    public static <E> Query<E> queryForEntity(Class<E> entityClass) {
        return ofy().load().type(entityClass);
    }

    public static <E> List<E> findEntitiesWithFilters(Class<E> entityClass, Map<String, Object> filters) {
        return applyFilters(queryForEntity(entityClass), filters).list();
    }

    public static long getTotalEntitiesCount(Class entityClass) {
        int count = 0;
        //TODO: Why is there not an easy way to get count of entities in Data Store ? Implement this
//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//        Entity globalStat = datastore.prepare(new Query("__Stat_Total__")).asSingleEntity();
//        Long totalBytes = (Long) globalStat.getProperty("bytes");
//        Long totalEntities = (Long) globalStat.getProperty("count");
        return count;
    }

    public static <E> List<E> findEntities(Class<E> entityClass) {
        return queryForEntity(entityClass).list();
    }

    public static <E> List<Long> save(List<E> entities) {
        List<Long> keyIds = new ArrayList<>();
        Set<Key<E>> keys = ofy().save().entities(entities).now().keySet();
        for (Key<E> key : keys) {
            keyIds.add(key.getId());
        }
        return keyIds;
    }


    public static Query applyFilters(Query query, Map<String, Object> filters) {
        if (filters == null || filters.isEmpty()) {
            return query;
        }
        Collection<String> filterProperties = filters.keySet();
        for (String property : filterProperties) {
            Object filterValue = filters.get(property);
            if (!isEmptyOrNull(filterValue)) {
                query = query.filter(property, filterValue);
            }
        }
        return query;
    }

    public static void delete(Long id, Class entityClass) {
        ofy().delete().key(Key.create(entityClass, id)).now();
    }
}
