package com.wayzim.repository;

import com.wayzim.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author SunLiLiang
 * @version 2.0
 * @date 2020/3/24
 */

@Repository
public interface StationRepository extends JpaRepository<Station,Integer>{


    /**
     * 查询相应省份每个城市五分钟内的报警数量
     * @return
     */
    @Query(value = "select t.city,count(a.sortlineid) alarmCount from station t join sortline s on t.id=s.stationid join device a on a.sortlineid=s.id  and date_format(a.LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval -1 day) and NOW() where a.stateType!=0 group by t.city ",nativeQuery = true)
    List<Map<String,Long>> queryAlarmCity();


    /**
     * 查询每个直辖市报警数量
     * @return
     */
    @Query(value = "select t.district,count(a.sortlineid) alarmCount from station t join sortline s on t.id=s.stationid join device a on a.sortlineid=s.id  and date_format(a.LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval -1 day) and NOW() where a.stateType!=0 group by t.district ",nativeQuery = true)
    List<Map<String,Long>> queryZCityAlarm();


    /**
     * 按省份查找各城市信息
     * @param province
     * @return
     */
    @Query(value = "select  t.city,t.stationCount,a.sortlineCount,b.alarmCount from (select province,city,count(*) 'stationCount' from station GROUP BY city) t JOIN\n" +
            "(select province,city,count(SortLineCode) 'sortLineCount' from station join sortline on station.id=sortline.StationID GROUP BY city) a\n" +
            "on t.city=a.city join \n" +
            "(select province,city,count(SortlineID) 'alarmCount' from station join sortline on station.ID=sortline.StationID join device on device.SortlineId=sortline.id where device.StateType!=0 and DATE_FORMAT(device.LastStateChangedTime,'%Y%m%d%H%i%S') BETWEEN DATE_add(NOW(),INTERVAl-1 day) and NOW() group by city) b on a.city=b.city where t.Province=:province" +
            " GROUP BY city",nativeQuery = true)
    List<List<Object>> queryCityInfo(@Param("province") String province);

    /**
     * 查询相应城市的站点报警信息
     * @param city
     * @return
     */
    @Query(value = "select t.name ,s.sortlinecode ,d.type ,d.index,d.state,d.LastStateChangedTime from station t " +
            "join sortline s on t.id=s.stationid join device d on d.sortlineid=s.id  where t.city=:city  and d.stateType!=0 and date_format(d.LastStateChangedTime,'%Y%m%d%H%i%S') between " +
            "date_add(NOW(),interval -1 day ) and NOW() order by d.LastStateChangedTime asc ",nativeQuery = true)
    List<List<Object>> queryStationCity(@Param("city") String city);

    /**
     * 查询直辖市的地区报警
     * @param district
     * @return
     */
    @Query(value = "select t.name ,s.sortlinecode ,d.type ,d.index,d.state,d.LastStateChangedTime from station t " +
            "join sortline s on t.id=s.stationid join device d on d.sortlineid=s.id  where t.district=:district and d.stateType!=0 and date_format(d.LastStateChangedTime,'%Y%m%d%H%i%S') between " +
            "date_add(NOW(),interval -1 day ) and NOW() order by d.LastStateChangedTime asc ",nativeQuery = true)
    List<List<Object>> queryStationDistrict(@Param("district") String district);



    /**
     * 按照省份分组查询报警数量
     * @return
     */
    @Query(value = "SELECT t.province,count(*) alarmCount FROM device a JOIN sortline s ON a.SortlineId = s.id JOIN station t ON s.StationID = t.ID" +
            "  WHERE a.stateType!=0 and date_format(a.LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval -1 day ) and NOW() GROUP BY t.Province", nativeQuery = true)
    List<Map<String,Long>> queryAlarmByProvince();


    /**
     * 查找所有省份站点和报警数量统计信息
     * @return 返回省份的基本信息
     */
    @Query(value = "select t.Province,t.stationCount,a.sortlineCount,b.alarmCount from (select Province,count(*) 'stationCount' from station GROUP BY Province) t JOIN " +
            "(select province,count(SortLineCode) 'sortLineCount' from station join sortline on station.id=sortline.StationID GROUP BY Province) a " +
            "on t.Province=a.Province join  " +
            "(select province,count(device.SortlineID) 'alarmCount' from station join sortline on station.ID=sortline.StationID join device on device.SortlineId=sortline.ID where device.StateType!=0 and DATE_FORMAT(device.LastStateChangedTime,'%Y%m%d%H%i%S') BETWEEN DATE_add(NOW(),INTERVAl-1 day ) and NOW() group by Province) b on a.Province=b.Province" +
            " group by t.Province"
            ,nativeQuery = true)
    List<List<Object>> queryProvinceInfo();
}
