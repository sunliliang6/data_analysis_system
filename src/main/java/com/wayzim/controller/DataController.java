package com.wayzim.controller;
import com.alibaba.fastjson.JSONObject;
import com.wayzim.entity.result.Result;
import com.wayzim.entity.result.ResultCode;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author sunli
 */
@RestController
public class DataController {
    static final Map<Integer,String>  map=new HashMap<>();

    /**
     * 接收报警预测信息
     * @param data
     */
    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public void getSession(@RequestBody String data){
        map.put(1,data);
    }

    /**
     * 传递报警预测信息至前端
     * @return
     */
    @RequestMapping(value = "/getMap")
    public Result getData(){
        String s = map.get(1);
        JSONObject jsonObject = JSONObject.parseObject(s);
        return new Result(ResultCode.SUCCESS,jsonObject);
    }


}