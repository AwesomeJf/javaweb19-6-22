package com.wzu.qunawan.dao;

import com.wzu.qunawan.pojo.Ordercontact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "ordercontactMapper")
public interface OrdercontactMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordercontact
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordercontact
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int insert(Ordercontact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordercontact
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    Ordercontact selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordercontact
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    List<Ordercontact> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordercontact
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int updateByPrimaryKey(Ordercontact record);
}