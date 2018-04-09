package com.jk.service;

import com.jk.entity.Car;
import com.jk.entity.RiZhi;
import com.jk.mapper.RiZhiMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("carServiceImpl")
public class CarServiceImpl implements CarService{

    @Resource
    private RiZhiMapper riZhiMapper;

    public List<RiZhi> queryRiZhiInfo() {

        return riZhiMapper.queryRiZhiInfo();
    }

    public void addRiZhi(RiZhi riZhi) {
        riZhiMapper.addRiZhi(riZhi);
    }

    public void deleteRiZhi(Integer id) {
        riZhiMapper.deleteRiZhi(id);
    }

    public void updateRiZhi(RiZhi riZhi) {
        riZhiMapper.updateRiZhi(riZhi);
    }

    /*public void updaterizhi(Integer id) {
        riZhiMapper.updaterizhi(id);
    }*/

    /*@Override
    public Car queryCarInfo(String carid) {
   *//*要将这个接口发布出去*//*
        System.out.println("carid = [" + carid + "]");
        Car car = new Car();
        car.setCarid(carid);
        car.setCarname("悍马");
        return car;
    }*/





}
