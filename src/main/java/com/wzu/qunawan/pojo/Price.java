package com.wzu.qunawan.pojo;

import java.util.Date;

public class Price {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price.date
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price.trip
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer trip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price.price
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float price;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price.id
     *
     * @return the value of price.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price.id
     *
     * @param id the value for price.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price.date
     *
     * @return the value of price.date
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price.date
     *
     * @param date the value for price.date
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price.trip
     *
     * @return the value of price.trip
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getTrip() {
        return trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price.trip
     *
     * @param trip the value for price.trip
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setTrip(Integer trip) {
        this.trip = trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price.price
     *
     * @return the value of price.price
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price.price
     *
     * @param price the value for price.price
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setPrice(Float price) {
        this.price = price;
    }
}