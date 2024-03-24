package com.example.skye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.skye.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper  mapper注释也可以使用
public interface BrandMapper extends BaseMapper<Brand> {

    //所有CRUD操作都编写完成了，不用像以前一样配置一大堆文件


}
