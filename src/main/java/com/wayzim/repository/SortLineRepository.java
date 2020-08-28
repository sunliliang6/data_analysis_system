package com.wayzim.repository;

import com.wayzim.entity.SortLine;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/3/24
 */

@Repository
public interface SortLineRepository extends JpaRepository<SortLine, Integer> {

}
