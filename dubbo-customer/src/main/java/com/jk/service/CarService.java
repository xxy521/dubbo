package com.jk.service;


import com.jk.entity.RiZhi;

import java.util.List;

public interface CarService {

    List<RiZhi> queryRiZhiInfo();

    void addRiZhi(RiZhi riZhi);

    void deleteRiZhi(Integer id);

    void updateRiZhi(RiZhi riZhi);

    //void updaterizhi(Integer id);
}
