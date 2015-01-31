package com.newtechfellas.videotutorials.util;

import com.google.appengine.repackaged.com.google.common.base.StringUtil;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 11:38 PM
 */
public class Utils {

    // TODO: There might a library with this functionality. Check it instead of reinventing
    public static boolean isEmptyOrNull(Object object) {
        boolean retVal = false;
        if (object == null) {
            retVal = true;
        } else {
            if (object instanceof String) {
                retVal = StringUtil.isEmptyOrWhitespace((String) object);
            } else if (object instanceof Collection) {
                retVal = ((Collection) object).isEmpty();
            }
        }
        return retVal;
    }
}
