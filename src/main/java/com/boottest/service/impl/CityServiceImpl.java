package com.boottest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boottest.dao.CityDao;
import com.boottest.domain.City;
import com.boottest.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    public City getFirst() {
        return cityDao.getFirst();
    }

}
