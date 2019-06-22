package com.wzu.qunawan.dao;

import com.wzu.qunawan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userMapper")
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    int updateByPrimaryKey(User record);

    Boolean checkUser(User user);

    int updatePassword(@Param("newPassWord") String newPassWord,@Param("id") int id);

    User selectByPhoneAndPassword(User user);

    User selectAreaByCityId(int cityId);

    int insertUserImg(@Param("imgPath") byte[]  imgPath,@Param("id") int id);

    int updateUserImg(@Param("imgPath") byte[]  imgPath,@Param("id") int id);
    User selectByPhone(String phone);

}