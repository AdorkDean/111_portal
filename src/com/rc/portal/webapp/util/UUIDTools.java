package com.rc.portal.webapp.util;

import java.util.UUID;

/**
 * Created by ws on 2015/8/7.
 */
public class UUIDTools {

    public static synchronized String getUUID()
    {
        String ret = null;
        try {

            UUID uuid = UUID.randomUUID();

            ret = uuid.toString();

        }catch ( Exception e ){
            e.printStackTrace();
        }

        return ret;
    }


}
