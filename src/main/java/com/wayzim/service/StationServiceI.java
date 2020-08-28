package com.wayzim.service;


import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiliangSun
 */
public interface StationServiceI {

    /**
     * 查找每个城市报警
     * @return
     */
    List<Map<String,Long>> queryAlarmCity();

    /**
     * 直辖市报警
     * @return
     */
    List<Map<String,Long>> queryZCityAlarm();

    /**
     * 按省份查找各城市站点信息
     * @param province
     * @return
     */
    List<List<Object>> queryCityInfo(String province);

    /**
     * 查找相应城市的站点报警信息
     * @param city
     * @return
     */
    List<List<Object>> queryStationCity(String city);

    /**
     * 查找直辖市相应地区的站点报警信息
     * @param district
     * @return
     */
    List<List<Object>> queryStationDistrict(String district);

    /**
     * 查询各个省份报警数量
     * @return
     */
    List<Map<String,Long>> queryAlarmByProvince();

    /**
     * 查询所有省份的站点和报警数量统计信息
     * @return
     */
    List<List<Object>> queryProvinceInfo();

}
