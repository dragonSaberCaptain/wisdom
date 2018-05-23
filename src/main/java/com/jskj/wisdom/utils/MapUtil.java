package com.jskj.wisdom.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.MapUtil
 * @description
 * @date 2018-05-06 22:25 星期日
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

    private String paramsString(Map<String, Object> map) {
        Map<String, Object> rec = MapUtil.simpleSort(map);
        StringBuilder       sb  = new StringBuilder();

        for (Map.Entry<String, Object> entry : rec.entrySet()) {
            String name  = entry.getKey();
            Object value = entry.getValue();
            sb.append(name + "=" + value).append("|");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        logger.debug("签名验签" + sb.toString());
        return sb.toString();
    }
}
