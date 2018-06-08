package com.javaman.jdk;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pengzhe
 * @date 2018/6/1 17:19
 * @description
 */

public class LinkedHashMapSample {

    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderedMap =
                new LinkedHashMap<String, String>(16, 0.75F, true) {
                    /**
                     *实现自定义删除策略,否则行为就和普通Map没什么区别
                     * @param eldest
                     * @return
                     */
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                        return size() > 3;
                    }
                };
        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");

        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        //模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        //触发删除
        accessOrderedMap.put("Project3", "Mission");
        System.out.println("Oldest entry should be delete");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

    }
}
