package com.wzu.qunawan.dao;

import com.wzu.qunawan.pojo.Areas;
import com.wzu.qunawan.pojo.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "cityMapper")
public interface CityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int insert(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    City selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    List<City> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int updateByPrimaryKey(City record);

    List<Areas> selectAreas();

    List<City> selectProvince();

    List<City> selectCity(int id);

}