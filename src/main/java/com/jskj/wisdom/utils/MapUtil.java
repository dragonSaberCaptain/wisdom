package com.jskj.wisdom.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Administrator on 2015/4/22.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class MapUtil {

    public static final Logger logger = LoggerFactory.getLogger(MapUtil.class);

    public static <T> List<T> toList(Collection<T> collection) {
        ArrayList rlist = new ArrayList();
        Iterator  it    = collection.iterator();

        while (it.hasNext()) {
            Object t = it.next();
            rlist.add(t);
        }

        return rlist;
    }

    public static Map<String, Object> simpleSort(Map params) {
        List<String> list = toList(params.keySet());
        Collections.sort(list);
        Map<String, Object> result = new LinkedHashMap();
        for (String name : list) {
            result.put(name, params.get(name));
        }
        return result;
    }
}
