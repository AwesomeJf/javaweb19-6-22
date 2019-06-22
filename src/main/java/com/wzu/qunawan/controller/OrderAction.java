package com.wzu.qunawan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzu.qunawan.pojo.Contact;
import com.wzu.qunawan.pojo.Orders;
import com.wzu.qunawan.pojo.User;
import com.wzu.qunawan.service.ContactService;
import com.wzu.qunawan.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderAction {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    OrderService orderService;

    @Autowired
    ContactService contactService;

    /*我的订单*/
    @GetMapping("/myOrder")
    public String listCategory(HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1")Integer start,
                               @RequestParam(value = "pageSize",defaultValue = "5")Integer size) {
        //System.out.println("----------page-----------");
        logger.info(start+"..");
        //logger.info("用户ID:"+userid+"...");

        /*由于是静态页面，前端的session不会保存，需要从后端强制取出*/
        HttpSession session = request.getSession();
        logger.info("强制取出的session"+session.getAttribute("userInfo")+"..");
        User user = (User) session.getAttribute("userInfo");
        logger.info("强制取出的用户ID"+user.getId());
        //
        session.setAttribute("userInfo",session.getAttribute("userInfo"));

        logger.info("当前页:"+start);

        PageHelper.startPage(start, size); //紧接着的查询会被分页
        List<Orders> orders =  orderService.MyselectAll(user.getId());
        logger.info(orders.size()+"..");


        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo page = new PageInfo(orders, size);

        //使用map集合存放对象信息，返回数据
        //Map<String,Object> results = new HashMap<>();
        //model.addAttribute("pageInfo",page);
        logger.info(page.getList().toString());
        request.setAttribute("pageInfo",page);

        //results.put("pageInfo", page);
        return "myOrder";
    }

    /*订单详情*/
    @GetMapping("/orderDetail/{userid}/{orderno}/{tripId}")
    public String orderDetail(@PathVariable("userid") Integer userid ,@PathVariable("orderno") String  orderno,
                              @PathVariable("tripId") Integer tripId, ModelMap modelMap){
        logger.info("当前用户ID:"+userid);
        //查询游客联系人信息
        List<Contact> contacts=contactService.selectByOrdersuser(userid);
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getSex()==0){
                contacts.get(i).setRealSex("男");
            }else{
                contacts.get(i).setRealSex("女");
            }
        }
        modelMap.addAttribute("contactInfo",contacts);
        //查询订单具体信息，包括购买人，订单状态
        Orders orders = orderService.selectByUserAndSequence(userid,orderno);
        modelMap.addAttribute("ordersInfo",orders);

        //查询某个订单的信息，产品名称，游玩日期等
        Orders orders1 = orderService.selectByTripId(tripId,orderno);
        modelMap.addAttribute("orders1Info",orders1);

        return "myOrderDetail";
    }




}
