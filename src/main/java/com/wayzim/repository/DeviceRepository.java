package com.wayzim.repository;

import com.wayzim.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

/**localhost:3306
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/7 21:09
 */
public interface DeviceRepository extends JpaRepository<Device,Integer> {


    /**
     * 根据城市和时间进行报警信息的查询
     * @param name 站点名
     * @param starTime 开始时间
     * @param endTime 结束时间
     * @param type 设备类型
     * @return
     */
    @Query(value = "select t.name ,s.sortlinecode ,d.type ,d.index,d.state,d.LastStateChangedTime from station t " +
            "join sortline s on t.id=s.stationid join device d on d.sortlineid=s.id  where t.name=:name and " +
            " d.type=:type and d.stateType!=0 and date_format(d.LastStateChangedTime,'%Y%m%d %H%i%S')>=:startTime and  " +
            "  date_format(d.LastStateChangedTime,'%Y%m%d %H%i%S')<=:endTime order by d.LastStateChangedTime asc ",nativeQuery = true)
    List<List<Object>> queryStationInfo(@Param("type") Integer type,@Param("name") String name, @Param("startTime") Date starTime, @Param("endTime") Date endTime);


    /**
     * 按设备类型进行统计报警数量
     * @param type
     * @return
     */
    @Query(value = "select count(*) from device where type=:type and stateType!=0" +
            " and DATE_FORMAT(LastStateChangedTime,'%Y%m%d%H%i%S') BETWEEN DATE_add(NOW(),INTERVAL-1 day) AND NOW()",nativeQuery = true)
    Long queryDeviceType(@Param("type") Integer type);

    /**
     * 分区域报警数量统计
     * @param type
     * @return
     */
    @Query(value="select t.province,t.city,t.name,count(*) from device d join sortline s on d.sortlineid=s.id join station t on s.stationid=t.id" +
            "  where  d.type=:type and stateType!=0 and DATE_FORMAT(LastStateChangedTime,'%Y%m%d%H%i%S') BETWEEN DATE_add(NOW(),INTERVAL-1 day ) AND NOW()" +
            " group by t.name ",nativeQuery=true)
    List<List<Object>> queryStateByDistrict(@Param("type") Integer type);


    /**
     * 查询某个时间段的分区域设备类型报警数量统计
     * @param type 设备类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @Query(value="select t.province,t.city,t.name,count(*) from device d join sortline s on d.sortlineid=s.id join station t on s.stationid=t.id" +
            "  where  d.type=:type and stateType!=0 and DATE_FORMAT(d.LastStateChangedTime,'%Y-%m-%d %H%i%S')>=:startTime and DATE_FORMAT(d.LastStateChangedTime,'%Y-%m-%d %H%i%S')<=:endTime" +
            " group by t.name ",nativeQuery=true)
    List<List<Object>> queryStateByDistrictTime(@Param("type") Integer type,@Param("startTime") Date startTime,@Param("endTime") Date endTime);



    @Query(value = "select count(*) from device where  stateType!=0 and date_format(LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval-1 day ) and NOW() ",nativeQuery = true)
    Long findByTime();

    @Query(value = "select count(*) from device where stateType!=0 and date_format(LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval-2 day ) and date_add(NOW(),interval-1 day ) ",nativeQuery = true)
    Long findByTime1();

    @Query(value = "select count(*) from device where stateType!=0 and date_format(LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval-3 day ) and date_add(NOW(),interval-2 day ) ",nativeQuery = true)
    Long findByTime2();

    @Query(value = "select count(*) from device where stateType!=0 and date_format(LastStateChangedTime,'%Y%m%d%H%i%S') between date_add(NOW(),interval-4 day ) and date_add(NOW(),interval-3 day ) ",nativeQuery = true)
    Long findByTime3();


    /**
     * 根据报警分类
     * @param stateType
     * @return
     */
    @Query(value = "select count(*) from device where stateType=:stateType and stateType!=0 and DATE_FORMAT(LastStateChangedTime,'%Y%m%d%H%i%S') BETWEEN DATE_add(NOW(),INTERVAL-1 day ) AND NOW()",nativeQuery = true)
    Long queryDeviceState(@Param("stateType") Integer stateType);


    /**
     * 根据设备id查找站点名称
     * @param id 设备id号
     * @return
     */
    @Query(value="select t.name,s.sortlinecode,d.type from station t join sortline s on t.id=s.StationID join device d on s.ID=d.SortlineID and d.ID=:id",nativeQuery=true)
    String queryName(@Param("id") Long id);

}
