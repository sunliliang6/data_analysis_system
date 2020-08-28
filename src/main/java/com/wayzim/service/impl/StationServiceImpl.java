package com.wayzim.service.impl;

import com.wayzim.repository.StationRepository;
import com.wayzim.service.StationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/3/24
 */
@Service
public class StationServiceImpl implements StationServiceI {
    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Map<String, Long>> queryAlarmCity() {
        return stationRepository.queryAlarmCity();
    }

    @Override
    public List<Map<String, Long>> queryZCityAlarm() {
        return stationRepository.queryZCityAlarm();
    }

    @Override
    public List<List<Object>> queryCityInfo(String province) {
        return stationRepository.queryCityInfo(province);
    }

    @Override
    public List<List<Object>> queryStationCity(String city) {
        return stationRepository.queryStationCity(city);
    }

    @Override
    public List<List<Object>> queryStationDistrict(String district) {
        return stationRepository.queryStationCity(district);
    }

    @Override
    public List<Map<String, Long>> queryAlarmByProvince() {
        return stationRepository.queryAlarmByProvince();
    }

    @Override
    public List<List<Object>> queryProvinceInfo() {
        return stationRepository.queryProvinceInfo();
    }
}
