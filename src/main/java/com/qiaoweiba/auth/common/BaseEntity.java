package com.qiaoweiba.auth.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 四月 01 2017 22:02.
 */
public class BaseEntity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static <T extends BaseEntity>Map<Long,T> idEntityMap(Collection<T> list) {
        Map<Long, T> map = new HashMap<Long, T>();

        if (null==list|| 0==list.size()){
            //集合最好不要返回null值，避免空指针异常
            return map;
        }
        for (T entity:list) {
            map.put(entity.getId(), entity);
        }
        return map;
    }
}
