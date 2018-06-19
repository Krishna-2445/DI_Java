package com.mutualofomaha.mob.java.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class JsonHelper {

    private JsonHelper() {
    }

    public static Object toJSON(Object object) {

        if (object instanceof Map) {
            JSONObject json = new JSONObject();
            Map map = (Map) object;
            map.entrySet().stream().forEach(key ->{
                json.put(key.toString(), toJSON(map.get(key)));
            });
            return json;
        } else if (object instanceof Iterable) {
            JSONArray json = new JSONArray();
            for (Object value : ((Iterable) object)) {
                json.put(value);
            }
            return json;
        } else {
            return object;
        }
    }
}
