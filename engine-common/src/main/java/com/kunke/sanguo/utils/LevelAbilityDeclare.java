package com.kunke.sanguo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 建筑等级数值工具类
 */
public class LevelAbilityDeclare {
    /**
     * 每小时产量
     */
    public static String RESOURCE_OUTPUT_PER_HOUR = "ProducePreHour";
    /**
     * 产量增比
     */
    public static String RESOURCE_PRODUCE_ADDITION = "ProduceAddition";

    /**
     * 缩短建造、建筑、训练时间
     */
    public static String REDUCE_TIME_PERCENT = "ReduceTimePercent";

    /**
     * 治疗速度加成
     */
    public static String TREAT_ADDITION = "TreatAddition";

    /**
     * 防御加成
     */
    public static String DEFENSE_ADDITION = "DefenseAddition";

    /**
     * 资源存储上限
     */
    public static String STORE_LIMIT = "ResourceStoreLimit";

    /**
     * 设置资源每小时产量
     * @param output
     * @return
     */
    public static String setOutPutPerHour(Integer output) {
        Map<String, Integer> jsonMap = Maps.newHashMap();
        jsonMap.put(RESOURCE_OUTPUT_PER_HOUR, output);
        return JSON.toJSONString(jsonMap);
    }

    /**
     * 获取资源每小时产量
     * @param json
     * @return
     */
    public static Integer getOutputPerHour(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        return (Integer) jsonObject.get(RESOURCE_OUTPUT_PER_HOUR);
    }

    /**
     * 设置产量增比 0~1之间 两位小数 0.XX格式
     * @param addition
     * @return
     */
    public static String setAddition(Double addition) {
        Map<String, Double> jsonMap = Maps.newHashMap();
        jsonMap.put(RESOURCE_PRODUCE_ADDITION, addition);
        return JSON.toJSONString(jsonMap);
    }

    /**
     * 获取产量增比 两位小数 0.XX格式
     * @param json
     * @return
     */
    public static Double getAddition(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        return Double.valueOf(jsonObject.get(RESOURCE_PRODUCE_ADDITION).toString());
    }

    /**
     * 获取库存上限
     * @param json
     * @return
     */
    public static Integer getStoreLimit(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        return Integer.valueOf(jsonObject.get(STORE_LIMIT).toString());
    }

    /**
     * 设置库存上限json
     * @param num
     * @return
     */
    public static String setStoreLimit(Integer num) {
        Map<String, Integer> jsonMap = Maps.newHashMap();
        jsonMap.put(STORE_LIMIT, num);
        return JSON.toJSONString(jsonMap);
    }

    /**
     * 获取库存上限
     * @param json
     * @return
     */
    public static Map<String, Integer> getHideStoreLimit(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String, Integer> mp = Maps.newHashMap();
        mp.put("wei-shu", jsonObject.getObject("wei-shu", Integer.class));
        mp.put("wu", jsonObject.getObject("wu", Integer.class));
        return mp;
    }

    /**
     * 设置库存上限json
     * @param mp
     * @return
     */
    public static String setHideStoreLimit(Map<String, Integer> mp) {
        return JSON.toJSONString(mp);
    }

    /**
     * 设置缩短建造训练时间 0~1之间 两位小数 0.XX格式
     * @param addition
     * @return
     */
    public static String setTimeReducePercent(Double addition) {
        Map<String, Double> jsonMap = Maps.newHashMap();
        jsonMap.put(REDUCE_TIME_PERCENT, addition);
        return JSON.toJSONString(jsonMap);
    }

    /**
     * 获取缩短建造训练时间 两位小数 0.XX格式
     * @param json
     * @return
     */
    public static Double getTimeReducePercent(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        return Double.valueOf(jsonObject.get(REDUCE_TIME_PERCENT).toString());
    }

    /**
     * 防御加成 0~1之间 两位小数 0.XX格式
     * @param addition
     * @return
     */
    public static String setDefenseAddition(Double addition) {
        Map<String, Double> jsonMap = Maps.newHashMap();
        jsonMap.put(DEFENSE_ADDITION, addition);
        return JSON.toJSONString(jsonMap);
    }

    /**
     * 防御加成 两位小数 0.XX格式
     * @param json
     * @return
     */
    public static Double getDefenseAddition(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        return Double.valueOf(jsonObject.get(DEFENSE_ADDITION).toString());
    }

    /**
     * 治疗速度加成 0~1之间 两位小数 0.XX格式
     * @param addition
     * @return
     */
    public static String setTreatAddition(Double addition) {
        Map<String, Double> jsonMap = Maps.newHashMap();
        jsonMap.put(TREAT_ADDITION, addition);
        return JSON.toJSONString(jsonMap);
    }

    /**
     * 治疗速度加成 两位小数 0.XX格式
     * @param json
     * @return
     */
    public static Double getTreatAddition(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        return Double.valueOf(jsonObject.get(TREAT_ADDITION).toString());
    }
}
