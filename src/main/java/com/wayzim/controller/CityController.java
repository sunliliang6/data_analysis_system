package com.wayzim.controller;

import com.wayzim.entity.result.Result;
import com.wayzim.entity.result.ResultCode;
import com.wayzim.service.StationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/7 9:46
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    private StationServiceI stationServiceI;

    /**
     * 查询所有城市的报警
     * @return
     */
    @RequestMapping(value = "/queryAlarmCity",method = RequestMethod.GET)
    public Result queryAlarmCity() {
        List<Map<String, Long>> list = stationServiceI.queryAlarmCity();
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 查询所有直辖市报警
     * @return
     */
    @RequestMapping(value = "/queryZCityAlarm",method = RequestMethod.POST)
    public Result queryZCityAlarm(){
        List<Map<String, Long>> list = stationServiceI.queryZCityAlarm();
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 查询相应省份的所有城市站点和报警信息
     * @param province
     * @return
     */
    @RequestMapping(value = "/queryCityInfo",method = RequestMethod.POST)
    public Result queryCityInfo(@RequestParam(value = "province") String province){
        List<List<Object>> list = stationServiceI.queryCityInfo(province);
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 查询相应城市的具体报警信息
     * @param city
     * @return
     */
    @RequestMapping("/queryStationInfo")
    public Result queryStationCity(@RequestParam(value = "city") String city){
        List<List<Object>> list = stationServiceI.queryStationCity(city);
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 查询地区直辖市地区报警信息
     * @param district
     * @return
     */
    @RequestMapping("/queryStationDistrict")
    public Result queryStationDistrict(@RequestParam(value = "district") String district){
        List<List<Object>> list = stationServiceI.queryStationDistrict(district);
        return new Result(ResultCode.SUCCESS,list);
    }
}
