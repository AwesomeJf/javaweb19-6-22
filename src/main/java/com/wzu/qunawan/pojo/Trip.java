package com.wzu.qunawan.pojo;

public class Trip {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.num
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.title
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.s_title
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String sTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.start_place
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer startPlace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.position
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.type
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.traffic
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String traffic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.hotel
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String hotel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.time
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Integer time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.good_rate
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float goodRate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.place_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float placeScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.hotel_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float hotelScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.service_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float serviceScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.traffic_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float trafficScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.is_ok
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Boolean isOk;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.main_picname
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private String mainPicname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trip.min_price
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    private Float minPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.id
     *
     * @return the value of trip.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.id
     *
     * @param id the value for trip.id
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.num
     *
     * @return the value of trip.num
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.num
     *
     * @param num the value for trip.num
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.title
     *
     * @return the value of trip.title
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.title
     *
     * @param title the value for trip.title
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.s_title
     *
     * @return the value of trip.s_title
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getsTitle() {
        return sTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.s_title
     *
     * @param sTitle the value for trip.s_title
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setsTitle(String sTitle) {
        this.sTitle = sTitle == null ? null : sTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.start_place
     *
     * @return the value of trip.start_place
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getStartPlace() {
        return startPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.start_place
     *
     * @param startPlace the value for trip.start_place
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setStartPlace(Integer startPlace) {
        this.startPlace = startPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.position
     *
     * @return the value of trip.position
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.position
     *
     * @param position the value for trip.position
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.type
     *
     * @return the value of trip.type
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.type
     *
     * @param type the value for trip.type
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.traffic
     *
     * @return the value of trip.traffic
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getTraffic() {
        return traffic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.traffic
     *
     * @param traffic the value for trip.traffic
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setTraffic(String traffic) {
        this.traffic = traffic == null ? null : traffic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.hotel
     *
     * @return the value of trip.hotel
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.hotel
     *
     * @param hotel the value for trip.hotel
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setHotel(String hotel) {
        this.hotel = hotel == null ? null : hotel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.time
     *
     * @return the value of trip.time
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Integer getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.time
     *
     * @param time the value for trip.time
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.good_rate
     *
     * @return the value of trip.good_rate
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getGoodRate() {
        return goodRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.good_rate
     *
     * @param goodRate the value for trip.good_rate
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setGoodRate(Float goodRate) {
        this.goodRate = goodRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.place_score
     *
     * @return the value of trip.place_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getPlaceScore() {
        return placeScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.place_score
     *
     * @param placeScore the value for trip.place_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setPlaceScore(Float placeScore) {
        this.placeScore = placeScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.hotel_score
     *
     * @return the value of trip.hotel_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getHotelScore() {
        return hotelScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.hotel_score
     *
     * @param hotelScore the value for trip.hotel_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setHotelScore(Float hotelScore) {
        this.hotelScore = hotelScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.service_score
     *
     * @return the value of trip.service_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getServiceScore() {
        return serviceScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.service_score
     *
     * @param serviceScore the value for trip.service_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setServiceScore(Float serviceScore) {
        this.serviceScore = serviceScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.traffic_score
     *
     * @return the value of trip.traffic_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getTrafficScore() {
        return trafficScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.traffic_score
     *
     * @param trafficScore the value for trip.traffic_score
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setTrafficScore(Float trafficScore) {
        this.trafficScore = trafficScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.is_ok
     *
     * @return the value of trip.is_ok
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Boolean getIsOk() {
        return isOk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.is_ok
     *
     * @param isOk the value for trip.is_ok
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.main_picname
     *
     * @return the value of trip.main_picname
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public String getMainPicname() {
        return mainPicname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.main_picname
     *
     * @param mainPicname the value for trip.main_picname
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setMainPicname(String mainPicname) {
        this.mainPicname = mainPicname == null ? null : mainPicname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trip.min_price
     *
     * @return the value of trip.min_price
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public Float getMinPrice() {
        return minPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trip.min_price
     *
     * @param minPrice the value for trip.min_price
     *
     * @mbg.generated Mon Jun 17 12:43:51 CST 2019
     */
    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }
}