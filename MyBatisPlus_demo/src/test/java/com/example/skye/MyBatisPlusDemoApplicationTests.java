package com.example.skye;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.skye.mapper.BrandMapper;
import com.example.skye.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MyBatisPlusDemoApplicationTests {


    @Autowired
    private BrandMapper brandMapper;

    @Test
    void testDemo() {
        //参数是一个wrapper对象，条件构造器
        List<Brand> brands = brandMapper.selectList(null);
        brands.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
/*        Brand brand = Brand.builder()
                .brandName("apple")
                .companyName("apple")
                .ordered(100)
                .status(1).build();*/
        Brand brand = new Brand();
        brand.setBrandName("ipad");
        brand.setCompanyName("ipad");
        brand.setOrdered(100);
        brand.setStatus(1);

        int result = brandMapper.insert(brand);
        System.out.println(result);
        System.out.println(brand.getId());
    }

    @Test
    public void testUpdate() {
        Brand brand = Brand.builder()
                .id(6L)
                .brandName("ipad")
                .companyName("ipad").build();

        int result = brandMapper.updateById(brand);
        System.out.println(result);
    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testOptimisticLocker(){
        //先查询要修改的数据
        Brand brand = brandMapper.selectById(5);
        //跟新值
        brand.setBrandName("ipad123");
        //更新
        brandMapper.updateById(brand);
        //这是version值自动加一（涉及到并发问题）
    }

    /**
     * 通过id查询
     */
    @Test
    public void testSelectById(){
        Brand brand = brandMapper.selectById(3);
        System.out.println(brand);
    }

    /**
     * 通过ids批量查询
     */
    @Test
    public void testSelectBatchIds(){
        List<Brand> brands = brandMapper.selectBatchIds(Arrays.asList(2, 3, 4));
        brands.forEach(System.out::println);
    }

    /**
     * 条件查询，通过map封装
     */
    @Test
    public void testMap(){
        Map<String, Object> map = new HashMap();
        map.put("ordered", 100);

        List<Brand> brands = brandMapper.selectByMap(map);
        brands.forEach(System.out::println);
    }

    /**
     * 条件查询，通过map封装
     */
    @Test
    public void testPagination(){
        //分页查询
        //参数current当前页面，size每页显示的条数
        Page<Brand> page = new Page<>(1, 2);
        brandMapper.selectPage(page, null);
        //获取分页数据

        List<Brand> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    @Test
    public void testDeleteById(){
        brandMapper.deleteById(5);
    }

    @Test
    public void testDeleteBatchIds(){
        brandMapper.deleteBatchIds(Arrays.asList(6));
    }

    /**
     * 该方法也测试了逻辑删除
     */
    @Test
    public void testDeleteByMap(){
        Map<String, Object> map = new HashMap();
        map.put("brand_name", "华为");
        brandMapper.deleteByMap(map);
    }


}
