package com.wayzim.repository;

;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/7 21:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class DeviceRepositoryTest {

    @Autowired
    private DeviceRepository deviceRepository;

    public Date getDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        Date transDate = dateFormat.parse(date);
        return transDate;
    }

    @Test
    public void queryStationInfo() throws ParseException {
        List<List<Object>> lists = deviceRepository.queryStationInfo(4, "无锡市", getDate("2020-08-17 00:00:00"), getDate("2020-08-20 00:00:00"));
        System.out.println(lists);
    }
}