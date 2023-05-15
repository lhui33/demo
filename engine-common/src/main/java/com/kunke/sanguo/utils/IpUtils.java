package com.kunke.sanguo.utils;

import com.alibaba.fastjson.JSONObject;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class IpUtils {


    @SneakyThrows
    public static String getIp(String ip){
        String result = "";
        ClassPathResource classPathResource = new ClassPathResource("GeoLite2-City.mmdb");
        DatabaseReader reader = new DatabaseReader.Builder(classPathResource.getInputStream()).build();
        InetAddress inetAddress = InetAddress.getByName(ip);
        CityResponse response = reader.city(inetAddress);
        String country  = response.getCountry().getNames().get("ja");
        if (response.getSubdivisions().size() > 0) {
            // 获取所在省份
            String province = response.getSubdivisions().get(0).getNames().get("zh-CN");
            // 获取所在城市
            String city = response.getCity().getNames().get("zh-CN");
            city = city == null ? "" : city;
            result = country + province + city;
        } else {
            result = getAlibaba(ip);
        }
        return result;
}

    /**
     * description ali地域查询
     *
     * @param ip ip地址
     * @return java.lang.String
     * @version 1.0
     */
    @SneakyThrows
    public static String getAlibaba(String ip) {
        Map map = new HashMap();
        map.put("ip", ip);
        map.put("accessKey", "alibaba-inc");
        String result = HttpUtil.postString("http://ip.taobao.com/outGetIpInfo", map);
        Map valueMap = JSONObject.parseObject(result, Map.class);

        // 请求成功，解析响应数据
        if ("query success".equals(valueMap.get("msg"))) {
            Map<String, String> dataMap = (Map<String, String>) valueMap.get("data");
            String country = dataMap.get("country");
            String region = dataMap.get("region");
            String city = dataMap.get("city");
            return country + region + city;
        }
        return "";
    }
}
