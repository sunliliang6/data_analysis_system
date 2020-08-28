package com.wayzim.service;

import com.wayzim.entity.Device;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/7 21:54
 */
public interface DeviceServiceI {

    /**
     * 按设备类型报警数量统计
     * @param type
     * @return
     */
    Long queryDeviceType(Integer type);

    /**
     * 按设备状态统计报警数量
     * @param stateType
     * @return
     */
    Long queryDeviceState(Integer stateType);

    /**
     * 统计前四小时报警
     * @return
     */
    List<Long> findTime();

    /**
     * 预测分析的图表标题
     * @param id
     * @return
     */
    String queryName(Long id);

    /**
     * 区域报警数量统计
     * @param type 设备类型
     * @return
     */
    List<List<Object>> queryStateByDistrict(Integer type);

    /**
     * 查询  设备类型的分区域统计报警数量
     * @param type 设备类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<List<Object>> queryStateByDistrictTime(Integer type,Date startTime,Date endTime);

    /**
     * 弹窗后下查区域报警的详细信息
     * @param type 设备类型
     * @param name 站点名
     * @param starTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<List<Object>> queryStationInfo(Integer type,String name,Date starTime,Date endTime);

}
