package com.wayzim.service.impl;

import com.wayzim.repository.DeviceRepository;
import com.wayzim.service.DeviceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/7 21:54
 */
@Service
public class DeviceServiceImpl implements DeviceServiceI {

    @Autowired
    private DeviceRepository deviceRepository;


    @Override
    public Long queryDeviceType(Integer type) {
        return deviceRepository.queryDeviceType(type);
    }

    @Override
    public Long queryDeviceState(Integer stateType) {
        return deviceRepository.queryDeviceState(stateType);
    }

    @Override
    public List<Long> findTime() {
        List<Long> list=new ArrayList<>();
        list.add(deviceRepository.findByTime());
        list.add(deviceRepository.findByTime1());
        list.add(deviceRepository.findByTime2());
        list.add(deviceRepository.findByTime3());
        return list;
    }

    @Override
    public String queryName(Long id) {
        return deviceRepository.queryName(id);
    }

    @Override
    public List<List<Object>> queryStateByDistrict(Integer type) {
        return deviceRepository.queryStateByDistrict(type);
    }

    @Override
    public List<List<Object>> queryStateByDistrictTime(Integer type, Date startTime, Date endTime) {
        return deviceRepository.queryStateByDistrictTime(type,startTime,endTime);
    }

    @Override
    public List<List<Object>> queryStationInfo(Integer type, String name, Date starTime, Date endTime) {
        return deviceRepository.queryStationInfo(type,name,starTime,endTime);
    }
}
