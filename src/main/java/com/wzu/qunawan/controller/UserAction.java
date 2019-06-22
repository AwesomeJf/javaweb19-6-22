package com.wzu.qunawan.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzu.qunawan.pojo.Areas;
import com.wzu.qunawan.pojo.City;
import com.wzu.qunawan.pojo.Contact;
import com.wzu.qunawan.pojo.User;
import com.wzu.qunawan.service.AreaService;
import com.wzu.qunawan.service.ContactService;
import com.wzu.qunawan.service.UserService;
import com.wzu.qunawan.util.Constants;
import com.wzu.qunawan.util.Globle;
import com.wzu.qunawan.util.UploadUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
public class UserAction {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserService userService;

    @Autowired
    AreaService areaService;

    @Autowired
    ContactService contactService;

    String path = null;

    //登陆
    @RequestMapping("/login")
    public String login(User user, HttpSession httpSession, ModelMap modelMap,HttpServletRequest request) {
        logger.info(user.getPhone() + "----->" + user.getPassword());

        String code = request.getParameter("code");

        if(!Globle.getCode().equalsIgnoreCase(code)){
            request.setAttribute("errMsg", "验证码不正确！");
            return "login";
        }
        if (userService.login(user)) {
            logger.info("user的信息" + user.getName());
            User user1 = userService.selectByPhoneAndPassword(user);
            logger.info("user1的信息" + user1.getName());
            httpSession.setAttribute("userInfo", user1);
            logger.info(user.getPhone());
            return "redirect:/trip";
        } else {
            modelMap.addAttribute("errMsg", "用户名密码错误");
            return "login";
        }
    }

    //注册
    @RequestMapping("/register")
    public String register(User user) {
        logger.info(user.getName());
        userService.insert(user);
        return "login";
    }

    //    注销
    @RequestMapping("/Reload")
    public String Reload() {
        return "login";
    }

    //修改之前查询个人信息
    @GetMapping("/myInfo")
    public String myInfo( ModelMap modelMap,HttpServletRequest request) {

        HttpSession session = request.getSession();
        User myuser = (User) session.getAttribute("userInfo");

        logger.info("要修改的用户的ID:" + myuser.getId());
        User user = userService.selectByPrimaryKey(myuser.getId());
        if (user.getSex()==0) {
            user.setRealSex("男");
        } else {
            user.setRealSex("女");
        }
        //查询用户的具体地址
        //User user1 = (User) request.getSession(true).getAttribute("userInfo");
        int cityId = user.getCity();
        User user2 = userService.selectAreaByCityId(cityId);
        //user2.setImgPath("000000");
        String string = Base64.encodeBase64String(user2.getImgPath());
        logger.info("转String之后:"+string);
        request.getSession().setAttribute("path",string);//头像
        request.setAttribute("userArea",user2);
        logger.info("子地址"+user2.getAreas().getChild());
        logger.info("父地址"+user2.getAreas().getParent());
        //httpSession.setAttribute("userArea",user2);
        session.setAttribute("userInfo",user2);
        logger.info("session里面的对象:"+session.getAttribute("userInfo"));

        modelMap.addAttribute("user", user);

        return "myInformation";
    }

    @PostMapping("/updateUser")
    public String updateuser(User user,HttpServletRequest request){

        if(user.getRealSex().equals("男")){
            user.setSex(0);
        }else{
            user.setSex(1);
        }
        //user.setCity(user.getAreas().getChildId());
        User user1 = (User)request.getSession().getAttribute("userInfo");
        user.setId(user1.getId());
        userService.updateByPrimaryKey(user);
        logger.info("城市:"+user.getCity());
        User userInfo = userService.selectByPrimaryKey(user1.getId());
        int cityId = user.getCity();
        User user2 = userService.selectAreaByCityId(cityId);
        logger.info("修改之后的名字:"+userInfo.getName());
        request.getSession().setAttribute("userInfo",userInfo);
        request.setAttribute("userArea",user2);
        //request.getSession().setAttribute("userInfo1",user2);
        request.setAttribute("altermsg","用户信息修改成功");
        request.setAttribute("user",userInfo);
        return "myInformation";
    }

    @RequestMapping("/areas")
    @ResponseBody
    public List<City> initareas(HttpServletRequest request,HttpSession httpSession) throws IOException {
        String method = request.getParameter("method");

        logger.info("方法:" + method);
        if (null != method && !"".equals(method)) {
            if ("initProvince".equals(method)) {
                List<City> province = areaService.selectProvince();
                logger.info("爸爸:" + province);
                //PrintWriter out = response.getWriter();
                //用来在前端选中对应用户的Area
                //request.setAttribute("areaInfo",province);
                httpSession.setAttribute("areaInfo",province);
                return province;
                //modelMap.addAttribute("provinceInfo",province);
            } else if ("getCity".equals(method)) {
                int cityCode = Integer.parseInt(request.getParameter("provCode"));
                logger.info("爸爸的id:" + cityCode);
                List<City> city = areaService.selectCity(cityCode);
                //用来在前端选中对应用户的Area
                //request.setAttribute("areaInfo",city);
                httpSession.setAttribute("areaInfo",city);
                logger.info("儿子:" + city);
                return city;
                //modelMap.addAttribute("cityInfo",city);
            }
        }
        return null;
        //return "myInformation";

    }

    //修改密码
    @PostMapping("/alterPassword")
    public String alterPassword(String oldPassWord, String newPassWord, String newPassWordt, HttpServletRequest request) {
        //logger.info("要修改的用户密码:"+user.getPassword());
        User user = (User) request.getSession(true).getAttribute("userInfo");
        int id = user.getId();
        logger.info("要修改的用户的ID:" + id);
        logger.info(oldPassWord + "   " + newPassWord + "    " + newPassWordt + "ID: " + user.getId());
        if (user.getPassword().equals(oldPassWord) == false) {
            request.setAttribute("pw_error", "原密码错误");
            return "alterPassword";
        } else if (newPassWord.equals(newPassWordt) == false) {
            request.getSession(true).setAttribute("pw_error", "新密码不一致");
            return "alterPassword";
        } else {
            userService.updatePassword(newPassWord, id);
            request.getSession(true).removeAttribute("userInfo");
            return "login";
        }

    }

    @RequestMapping("/jump")
    public String jump(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("userInfo");
        String string = Base64.encodeBase64String(user.getImgPath());
        logger.info("转String之后:"+string);
        request.getSession().setAttribute("path",string);//头像
        return "alterPassword";
    }

    //查询常用游客信息
    @RequestMapping("/contact")
    public String contact(HttpServletRequest request,
                          @RequestParam(value = "pageNum",defaultValue = "1")Integer start,
                          @RequestParam(value = "pageSize",defaultValue = "5")Integer size) {
        User user = (User) request.getSession(true).getAttribute("userInfo");

        String string = Base64.encodeBase64String(user.getImgPath());
        logger.info("转String之后:"+string);
        request.getSession().setAttribute("path",string);//头像
        int id = user.getId();
        PageHelper.startPage(start, size); //紧接着的查询会被分页
        List<Contact> contacts = contactService.selectAll(id);
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getSex()==0){
                contacts.get(i).setRealSex("男");
            }else{
                contacts.get(i).setRealSex("女");
            }
        }
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo page = new PageInfo(contacts, size);

        logger.info(page.getList().toString());
        request.setAttribute("pageInfo",page);

        return "myContact";
    }

    //添加游客
    @PostMapping("/addcontact")
    public String addcontact(ModelMap modelMap,HttpServletRequest request,Contact contact){
        User user = (User) request.getSession(true).getAttribute("userInfo");
        String string = Base64.encodeBase64String(user.getImgPath());
        logger.info("转String之后:"+string);
        request.getSession().setAttribute("path",string);//头像
        int id = user.getId();
        contact.setUser(id);
        if(contact.getRealSex().equals("男")){
            contact.setSex(0);
        }else{
            contact.setSex(1);
        }
        contactService.insert(contact);

        request.setAttribute("msg","游客新增成功");
        //contactService.updateByUserId(contact,id);
        return "addcontact";
    }

    @RequestMapping("/jumptoadd")
    public String jumptoadd(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("userInfo");
        String string = Base64.encodeBase64String(user.getImgPath());
        logger.info("转String之后:"+string);
        request.getSession().setAttribute("path",string);//头像
        return "addcontact";
    }

    //查询要修改的游客并回显
    @GetMapping("/addcontact/{id}")
    public String toaddcontact(@PathVariable("id") Integer id, ModelMap modelMap){
        logger.info("要修改的游客的ID:"+id);
        Contact contact = contactService.selectByPrimaryKey(id);

        modelMap.addAttribute("contact", contact);

        return "addcontact";
    }

    //修改游客信息
    @PutMapping("/addcontact")
    public String altetcontact(Contact contact,HttpServletRequest request){
        if(contact.getRealSex().equals("男")){
            contact.setSex(0);
        }else{
            contact.setSex(1);
        }
        contactService.updateByContactId(contact);
        request.setAttribute("msg","游客修改成功");
        return "addcontact";
    }

    //删除游客信息
    @DeleteMapping("/addcontact/{id}")
    public String deletecontact(@PathVariable("id") Integer id){
        contactService.deleteByPrimaryKey(id);
        return "redirect:/contact";
    }


    //头像
    @PostMapping("/empImg")
    public String upload(@RequestParam("avatar_file") MultipartFile file, HttpServletRequest request) throws Exception{

        User user = (User) request.getSession().getAttribute("userInfo");
        int userid = user.getId();
        //System.out.println(file);
        if(!file.isEmpty()){
            // 拿到文件名
            logger.info("文件的流:"+file);
            logger.info("转byte之后;"+file.getBytes());

            if(user.getImgPath()==null||user.getImgPath().equals("")){
                userService.insertUserImg(file.getBytes(),userid);
            }else{
                userService.updateUserImg(file.getBytes(),userid);
            }

            /*String filename = file.getOriginalFilename();
            // 存放上传图片的文件夹
            File fileDir = UploadUtils.getImgDirFile();
            // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
            logger.info(fileDir.getAbsolutePath());
            try {
                // 构建真实的文件路径
                File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
                logger.info(newFile.getAbsolutePath());

                path = "/userImg/"+filename;
                // 上传图片到 -》 “绝对路径”
                file.transferTo(newFile);
                request.setAttribute("filename",filename);

            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        return "redirect:/myInfo";

    }


}
