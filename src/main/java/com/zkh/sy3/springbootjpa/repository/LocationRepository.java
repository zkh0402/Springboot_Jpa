package com.zkh.sy3.springbootjpa.repository;

import com.zkh.sy3.springbootjpa.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zkh
 * @date 2022/6/12 -10:53
 */
public interface LocationRepository extends JpaRepository<Location,Integer> {
}
