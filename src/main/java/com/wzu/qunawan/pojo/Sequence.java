package com.wzu.qunawan.pojo;

public class Sequence {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.value
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String value;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.keying
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String keying;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.type
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.descing
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String descing;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.id
     *
     * @return the value of sequence.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.id
     *
     * @param id the value for sequence.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.value
     *
     * @return the value of sequence.value
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.value
     *
     * @param value the value for sequence.value
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.keying
     *
     * @return the value of sequence.keying
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getKeying() {
        return keying;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.keying
     *
     * @param keying the value for sequence.keying
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setKeying(String keying) {
        this.keying = keying == null ? null : keying.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.type
     *
     * @return the value of sequence.type
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.type
     *
     * @param type the value for sequence.type
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.descing
     *
     * @return the value of sequence.descing
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getDescing() {
        return descing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.descing
     *
     * @param descing the value for sequence.descing
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setDescing(String descing) {
        this.descing = descing == null ? null : descing.trim();
    }
}