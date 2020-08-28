package com.wayzim.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/11 20:29
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class DeviceServiceImplTest {

    @Autowired
    private DeviceServiceImpl deviceService;
    @Test
    void findCount() {
//        List<Long> count = deviceService.findCount();
//        for(Long l:count){
//            System.out.println(l);
//        }
    }
}