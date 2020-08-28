package com.wayzim.util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;


/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/4/30 11:03
 */
public class JsonTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/sunli/Desktop/1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = reader.readLine();
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject.getString("256"));
//        Set<String> json = jsonObject.keySet();
//        Iterator<String> iterator = json.iterator();
//        Map<String,Map<String,String>> m=new HashMap<>();
//        Map<String,String> map=new HashMap<>();
//        while(iterator.hasNext()){
//            String next = iterator.next();
//            String string = jsonObject.getString(next);
//            JSONArray array = JSONObject.parseArray(string);
//            for(int i=0;i<array.size();i++){
//                JSONObject object = array.getJSONObject(i);
//                map.put(object.getString("ds"),object.getString("yhat"));
//                m.put(next,map);
//            }
//        }
////        Set<String> set = m.keySet();
////        for(String key:set){
////            Map<String, String> stringMap = m.get(key);
////            for(Map.Entry<String,String> t:stringMap.entrySet()){
////                System.out.println(t);
////            }
////        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s1 = objectMapper.writeValueAsString(m);
//        JSONObject object = JSONObject.parseObject(s1);
//        System.out.println(object);
    }
}
