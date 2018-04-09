package com.jk.controller;

import com.jk.entity.Car;
import com.jk.entity.RiZhi;
import com.jk.service.CarService;
import com.jk.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("app/rizhi")
public class CarController {

    @Resource
    private CarService carService;

    // 分页查询
    @GetMapping
    public String queryRiZhi() {
       List<RiZhi> list = carService.queryRiZhiInfo();
        return JSONUtil.toJson(list);
    }

    @PostMapping
    public void addRiZhi(@RequestBody RiZhi riZhi){

        carService.addRiZhi(riZhi);
    }

    @DeleteMapping("{id}")
    public void deleteRiZhi(@PathVariable Integer id){

        carService.deleteRiZhi(id);
    }

    @RequestMapping("update")
    public void updaterizhi(@RequestBody RiZhi riZhi){
        //System.out.println(riZhi);
        carService.updateRiZhi(riZhi);
    }

   /*@PutMapping("{id}")
    public void updaterizhi(@PathVariable Integer id){
        carService.updaterizhi(id);
    }*/
}
