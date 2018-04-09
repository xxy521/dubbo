package com.jk.mapper;

import com.jk.entity.RiZhi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RiZhiMapper {

    @Select("select * from t_rizhi")
    List<RiZhi> queryRiZhiInfo();

    @Insert("insert into t_rizhi(rtype,rname,rtime) values(#{rtype},#{rname},#{rtime})")
    void addRiZhi(RiZhi riZhi);

    @Delete("delete from t_rizhi where rid=#{id}")
    void deleteRiZhi(Integer id);

    @Update("update t_rizhi set rname=#{rname},rtype=#{rtype},rtime=#{rtime}  where rid = #{rid}")
    void updateRiZhi(RiZhi riZhi);

    /*@Update("update t_rizhi set rname=#{rname},rtype=#{rtype},rtime=#{rtime}  where rid = #{id}")
    void updaterizhi(Integer id);*/
}
