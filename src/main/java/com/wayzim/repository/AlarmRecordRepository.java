package com.wayzim.repository;

import com.wayzim.entity.AlarmRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author SunLiLiang
 * @version 1.0
 * @date 1010/3/14
 */

@Repository
public interface AlarmRecordRepository extends JpaRepository<AlarmRecord, Integer> {

}
