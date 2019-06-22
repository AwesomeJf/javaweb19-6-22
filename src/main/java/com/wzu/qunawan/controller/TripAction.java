package com.wzu.qunawan.controller;


import com.wzu.qunawan.pojo.*;
import com.wzu.qunawan.service.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TripAction {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TripService tripService;

    @Autowired
    PriceService priceService;
    @Autowired
    TrippictureService trippictureService;
    @Autowired
    ThemeService themeService;
    @Autowired
    PlaceService placeService;
    @Autowired
    CityService cityService;
    @Autowired
    PositionService positionService;
    @Autowired
    DetailService detailService;
    @Autowired
    DatesService datesService;
    @Autowired
    TrafficService trafficService;
    @Autowired
    UserService userService;
    @Autowired
    ContactService contactService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/trip")
    public String findAll(HttpServletRequest request, HttpServletResponse httpResponse, ModelMap modelMap) throws IOException {
        List<Trip> tripList = tripService.findAllByHot();
        ArrayList<Tripshow> tripshowList = new ArrayList<Tripshow>();

//        logger.info(tripList.toString());
        for (int i = 0; i < 9; i++) {
            String buff = Base64.encodeBase64String(trippictureService.findByTrip(tripList.get(i).getId()).get(0).getData());
            logger.info("ecode之后的图片数据:" + buff);
            //httpResponse.getOutputStream().write(trippictureService.findpic(tripList.get(i).getId()).getData());
            Tripshow item = new Tripshow(tripList.get(i).getId(), tripList.get(i).getTitle(), tripList.get(i).getsTitle(), tripList.get(i).getGoodRate(),
                    priceService.getPriceByTrip(tripList.get(i).getId()).get(0).getPrice(), buff);
            tripshowList.add(item);
        }
        ;
        logger.info(tripshowList.toString());
        request.setAttribute("tripInfo", tripshowList);
        return "index";

    }

    @RequestMapping("/tripselect")
    public String selectAll(HttpServletRequest request, HttpServletResponse httpResponse, ModelMap modelMap) throws IOException {
        List<Trip> tripList = tripService.findAllByHot();
        ArrayList<Tripshow> tripshowList = new ArrayList<Tripshow>();

//        logger.info(tripList.toString());
        for (int i = 0; i < 5; i++) {
            String buff = Base64.encodeBase64String(trippictureService.findByTrip(tripList.get(i).getId()).get(0).getData());
//            logger.info("ecode之后的图片数据:"+buff);
            ArrayList<Date> date = new ArrayList<Date>();
            ArrayList<String> theme = new ArrayList<String>();
            ArrayList<String> place = new ArrayList<String>();
            for (int j = 0; j < 2; j++) {
                date.add(priceService.getPriceByTrip(tripList.get(i).getId()).get(j).getDate());
            }
            for (Theme item : themeService.findByTrip(tripList.get(i).getId())) {
                theme.add(item.getName());
            }
            for (Place item : placeService.selectByTrip(tripList.get(i).getId())) {
                place.add(item.getName());
            }

            //httpResponse.getOutputStream().write(trippictureService.findpic(tripList.get(i).getId()).getData());
            Tripshow item = new Tripshow(tripList.get(i).getId(), tripList.get(i).getTitle(), tripList.get(i).getsTitle(), tripList.get(i).getGoodRate(),
                    priceService.getPriceByTrip(tripList.get(i).getId()).get(0).getPrice(), buff,
                    cityService.findCity(tripList.get(i).getStartPlace()),
                    tripList.get(i).getTraffic(), tripList.get(i).getHotel(), tripList.get(i).getTime(),
                    place, theme, date);
            tripshowList.add(item);
        }
        ;
        logger.info(tripshowList.toString());
        request.setAttribute("tripInfo", tripshowList);


        List<Theme> themeList = themeService.findAll();
        logger.info(themeList.toString());
        request.setAttribute("themeInfo", themeList);
        return "information";

    }

    @RequestMapping("/select/{city}")
//    @ResponseBody
    public String select(@PathVariable("city") String city, HttpServletRequest request) throws IOException {


        List<Tripshow> tripList = tripService.selectByPlaceAndCity(city);
//        logger.info(tripList.toString());


        for (int i = 0; i < tripList.size(); i++) {
            int id = tripList.get(i).getId();
            String buff = Base64.encodeBase64String(trippictureService.findByTrip(tripList.get(i).getId()).get(0).getData());
            ArrayList<Date> date = new ArrayList<Date>();
            ArrayList<String> theme = new ArrayList<String>();
            ArrayList<String> place = new ArrayList<String>();
            for (int j = 0; j < 2; j++) {
                date.add(priceService.getPriceByTrip(tripList.get(i).getId()).get(j).getDate());
            }
            for (Theme item : themeService.findByTrip(tripList.get(i).getId())) {
                theme.add(item.getName());
            }
            for (Place item : placeService.selectByTrip(tripList.get(i).getId())) {
                place.add(item.getName());
            }
            tripList.get(i).setPrice(priceService.getPriceByTrip(tripList.get(i).getId()).get(0).getPrice());
            tripList.get(i).setData(buff);
            tripList.get(i).setStartPlace(cityService.findCity(tripService.selectByPrimaryKey(id).getStartPlace()));
            tripList.get(i).setPlace(place);
            tripList.get(i).setTheme(theme);
            tripList.get(i).setDate(date);
        }
        ;
        logger.info(tripList.toString());
        request.setAttribute("tripInfo", tripList);
        List<Theme> themeList = themeService.findAll();
        logger.info(themeList.toString());
        request.setAttribute("themeInfo", themeList);
        int choose = 1;
        request.setAttribute("chooseInfo", choose);
        return "information";

    }

    @RequestMapping("/select1/{theme}")
    public String selectByTheme(@PathVariable("theme") String theme, HttpServletRequest request) throws IOException {

          List<Tripshow> tripList = tripService.selectByTheme(theme);
//        logger.info(tripList.toString());


        for (int i = 0; i < tripList.size(); i++) {
            int id = tripList.get(i).getId();
            String buff = Base64.encodeBase64String(trippictureService.findByTrip(tripList.get(i).getId()).get(0).getData());
            ArrayList<Date> date = new ArrayList<Date>();
            ArrayList<String> theme1 = new ArrayList<String>();
            ArrayList<String> place = new ArrayList<String>();
            for (int j = 0; j < 2; j++) {
                date.add(priceService.getPriceByTrip(tripList.get(i).getId()).get(j).getDate());
            }
            for (Theme item : themeService.findByTrip(tripList.get(i).getId())) {
                theme1.add(item.getName());
            }
            for (Place item : placeService.selectByTrip(tripList.get(i).getId())) {
                place.add(item.getName());
            }
            tripList.get(i).setPrice(priceService.getPriceByTrip(tripList.get(i).getId()).get(0).getPrice());
            tripList.get(i).setData(buff);
            tripList.get(i).setStartPlace(cityService.findCity(tripService.selectByPrimaryKey(id).getStartPlace()));
            tripList.get(i).setPlace(place);
            tripList.get(i).setTheme(theme1);
            tripList.get(i).setDate(date);
        }
        ;
        logger.info(tripList.toString());
        request.setAttribute("tripInfo", tripList);
        List<Theme> themeList = themeService.findAll();
        logger.info(themeList.toString());
        request.setAttribute("themeInfo", themeList);
        int choose = 1;
        request.setAttribute("chooseInfo", choose);
        return "information";

    }



    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse httpResponse, ModelMap modelMap) throws IOException {
        logger.info("" + id);
        Trip trip = tripService.selectByPrimaryKey(id);
        logger.info(trip.toString());
        List<Trippicture> pic = trippictureService.findByTrip(id);
        ArrayList<String> realpic = new ArrayList<String>();
        for (Trippicture item : pic) {
            String buff = Base64.encodeBase64String(item.getData());
            realpic.add(buff);
        }
        logger.info(pic.get(0).getName());
        List<Price> pricelist = priceService.getPriceByTrip(id);

//        得到出發地
        String startplace = cityService.findCity(tripService.selectByPrimaryKey(id).getStartPlace());
//        得到景點地點
        ArrayList<String> place = new ArrayList<String>();
        for (Place item : placeService.selectByTrip(id)) {
            place.add(item.getName());
        }
//         得到地理位置
        Position pos = positionService.findByid(id);
//         得到detail
        Detail detail = detailService.selectByTrip(id);
//         得到行程详情
        List<Dates> datesList = datesService.selectBySchedule(id);
//         schedual的id=trip的id
//           得到traffic
        Traffic traffic = trafficService.selectByTrip(id);


        request.setAttribute("tripInfo", trip);
        request.setAttribute("picInfo", pic);
        request.setAttribute("realpicInfo", realpic);
        request.setAttribute("minPirceInfo", pricelist.get(0));
        request.setAttribute("startInfo", startplace);
        request.setAttribute("placeInfo", place);
        request.setAttribute("posInfo", pos);
        request.setAttribute("detailInfo", detail);
        request.setAttribute("datesInfo", datesList);
        request.setAttribute("trafficInfo", traffic);

        return "trip_detail";
    }


    @RequestMapping("/confirmOrder")
    public String order(HttpServletRequest request, HttpServletResponse httpResponse, HttpSession httpSession, ModelMap modelMap) throws IOException{
          logger.info( request.getParameter("num").toString());
          logger.info( request.getParameter("trip_id").toString());
          logger.info( request.getParameter("date").toString());
          logger.info( request.getParameter("people").toString());
//          logger.info(request.getSession().getAttribute("userInfo").toString());
          User user=(User) request.getSession().getAttribute("userInfo");


          int num=Integer.parseInt(request.getParameter("num"));
          int people=Integer.parseInt(request.getParameter("people"));
          int id=Integer.parseInt(request.getParameter("trip_id"));
          String date=request.getParameter("date");
          Trip trip=tripService.selectByPrimaryKey(id);
//          联系人
          List<Contact> contactList=contactService.selectByUser(user.getId());
           request.setAttribute("tripIdInfo",id);
           request.setAttribute("titleInfo", trip.getTitle());
           request.setAttribute("stitleInfo", trip.getsTitle());
           request.setAttribute("dateInfo",date);
           request.setAttribute("peopleInfo",people);
           request.setAttribute("numInfo",num);
           request.setAttribute("userInfo",user);
           request.setAttribute("contactInfo",contactList);



        return "order";
    }

    @RequestMapping("/ordered")
    public String ordered(HttpServletRequest request, HttpServletResponse httpResponse, HttpSession httpSession, ModelMap modelMap) throws IOException, ParseException {
        Float totalnum=Float.parseFloat(request.getParameter("total_num"));
        int people=Integer.parseInt(request.getParameter("people"));
        int id=Integer.parseInt(request.getParameter("trip_id"));
        String time=request.getParameter("time");
        int emer_id=Integer.parseInt(request.getParameter("emer_id"));
        User user=(User) request.getSession().getAttribute("userInfo");


        Orders order=new Orders();
        order.setNum(people);
        order.setTotalPrice(totalnum);
        order.setUser(user.getId());
        order.setTrip(id);
        order.setState(4);
        DateFormat format= new SimpleDateFormat("yyyyMMdd");
        Date date=format.parse(time);

        order.setStartTime(date);
        orderService.insertOrder(order);
        return "redirect:/trip";
    }
}
