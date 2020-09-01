package com.wayzim.controller;

import com.wayzim.entity.result.Result;
import com.wayzim.entity.result.ResultCode;
import com.wayzim.service.DeviceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/11 16:38
 */
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceServiceI deviceServiceI;

    /**
     * 按设备类型统计报警数量
     * @param type
     * @return
     */
    @RequestMapping("/queryDeviceType")
    public Result<Long> queryDeviceType(@RequestParam("type") Integer type){
        Long count = deviceServiceI.queryDeviceType(type);
        return new Result<>(ResultCode.SUCCESS,count);
    }

    /**
     * 按设备状态统计报警数量
     * @param stateType
     * @return
     */
    @RequestMapping("/queryDeviceState")
    public Result<Long> queryDeviceState(@RequestParam("stateType") Integer stateType){
        Long count = deviceServiceI.queryDeviceState(stateType);
        return new Result<>(ResultCode.SUCCESS,count);
    }

    /**
     * 前四小时报警数量统计
     * @return
     */
    @RequestMapping(value = "/timeCount",method = RequestMethod.POST)
    public Result<List<Long>> findTime(){
        List<Long> list = deviceServiceI.findTime();
        return new Result<>(ResultCode.SUCCESS,list);
    }

    /**
     * 查询预测分析的标题
     * @param stationName
     * @return
     */
    @RequestMapping(value = "/queryName",method = RequestMethod.GET)
    public Result queryName(@RequestParam("stationName") String stationName){
        String name = deviceServiceI.queryName(new Long(stationName));
        return new Result(ResultCode.SUCCESS,name);
    }

    /**
     *
     * @param stateType
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/queryStateByDistrictTime",method = RequestMethod.GET)
    public Result<List<List<Object>>> queryStateByDistrictTime(@RequestParam(value = "type",required = false) Integer stateType, @RequestParam(value = "startTime",required = false)
            String startTime,@RequestParam(value = "endTime",required =false) String endTime) throws ParseException {
        if (startTime == null && endTime == null) {
            List<List<Object>> list = deviceServiceI.queryStateByDistrict(stateType);
            return new Result<>(ResultCode.SUCCESS,list);
        } else {
            List<List<Object>> list = deviceServiceI.queryStateByDistrictTime(stateType, getDate(startTime), getDate(endTime));
            return new Result<>(ResultCode.SUCCESS,list);
        }
    }


    @RequestMapping(value = "/queryStationInfo")
    public Result<List<List<Object>>> queryStationInfo(@RequestParam("type") Integer type,@RequestParam("name") String name,
                                               @RequestParam("startTime") Date startTime,@RequestParam("endTime") Date endTime){
        List<List<Object>> list = deviceServiceI.queryStationInfo(type, name, startTime, endTime);
        return new Result<>(ResultCode.SUCCESS,list);
    }
    /**
     * 字符串转换时间工具
     * @param date 日期字符串
     * @return
     * @throws ParseException
     */
    public Date getDate(String date) throws ParseException {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        Date transDate = dateFormat.parse(date);
        return transDate;
    }
}
