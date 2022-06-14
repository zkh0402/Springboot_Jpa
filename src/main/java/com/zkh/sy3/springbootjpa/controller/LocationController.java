package com.zkh.sy3.springbootjpa.controller;

import com.zkh.sy3.springbootjpa.entity.Location;
import com.zkh.sy3.springbootjpa.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zkh
 * @date 2022/6/12 -10:53
 */
@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/findAllLoaction")
    public List<Location> findAllLoaction(){
        return locationRepository.findAll();
    }
}
