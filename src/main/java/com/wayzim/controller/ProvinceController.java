package com.wayzim.controller;

import com.wayzim.entity.result.Result;
import com.wayzim.entity.result.ResultCode;
import com.wayzim.service.StationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/6 20:36
 */
@CrossOrigin
@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private StationServiceI stationServiceI;


    /**
     * 查询所有省份的报警
     *
     * @return map集合
     */
    @RequestMapping(value = "/queryAlarmByProvince",method = RequestMethod.POST)
    public Result queryAlarmByProvince() {
        List<Map<String, Long>> list = stationServiceI.queryAlarmByProvince();
        return new Result(ResultCode.SUCCESS,list);
    }

    /**
     * 查询所有省份的站点和报警数量统计信息
     * @return
     */
    @RequestMapping(value = "/queryProvinceInfo",method = RequestMethod.GET)
    public Result queryProvinceInfo() {
        List<List<Object>> list = stationServiceI.queryProvinceInfo();
        return new Result(ResultCode.SUCCESS,list);
    }
}