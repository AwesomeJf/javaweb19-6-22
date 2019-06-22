/*
package com.wzu.qunawan.controller;


import com.wzu.qunawan.pojo.User;
import com.wzu.qunawan.service.UserService;
import com.wzu.qunawan.util.Utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


@Controller
public class UpLoadImgAction {

    private static final String HEAD_PIC = "headPic";
    //private static final String COMMENTPIC = "commentPic";
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;


    @PostMapping("/crop")
    public String UpdateLoad(HttpServletRequest request) throws Exception {
        */
/*String flag = request.getParameter("pictureType");
        User user = (User) request.getSession().getAttribute("userInfo");
        switch (flag) {
            case HEAD_PIC:
                getUserHeadPic(user,request);
                break;
            case COMMENTPIC:
                //getCommentPic(user.getId(),request);
                break;
            default:
                break;

        }*//*

        User user = (User) request.getSession().getAttribute("userInfo");
        getUserHeadPic(user, request);
        return "myInformation";
    }

    */
/**
     * 请求获取用户头像
     *
     * @throws ServletException
     * @throws IOException
     *//*

    private void getUserHeadPic(User user, HttpServletRequest request) throws ServletException, IOException {

        */
/** 实训场景006：用户头像上传 - 上传并保存头像【START】 *//*

        // 解析表单数据并得到用户裁剪后上传的图片
        BufferedImage image = receiveImage(request);

        String file_name = Utils.createName() + ".jpg";
        File file = new File(request.getSession().getServletContext().getRealPath("\\user_img\\" + file_name));
        ImageIO.write(image, "png", file);

        user.setImgPath(file_name);

        // 保存用户对象
        //userDao.update(user);
        //userService.updateUser(user);
        */
/** 实训场景006：用户头像上传 - 上传并保存头像【END】 *//*


        // 跳转到个人页面

    }

    */
/**
     * 请求获取提交的评论图片
     *//*


    */
/*private void getCommentPic(Integer userId,HttpServletRequest request) {

        byte[] image = Utils.analysisForm(request);

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            Globle.uploadPics(userId, image);
        } finally {
            lock.unlock();
        }
    }*//*



    */
/**
     * 从请求对象中获取到上传的图片，以及裁剪坐标
     *
     * @return 获得的上传图
     *//*

    private BufferedImage receiveImage(HttpServletRequest request) {

        */
/** 实训场景006：用户头像上传 - 解析请求数据并裁剪图片【START】 *//*

        // 表单上传数据集合
        List<FileItem> items = null;
        // 上传图片
        BufferedImage bi = null;

        // 实例化文件工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 用于文件上传的对象实例
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析请求中的请求数据
        try {
            items = upload.parseRequest(request);
            logger.info("头像数据:"+items);

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 如果上传数据为空则返回null
        if (items == null || items.size() == 0)
            return null;

        // 截图左上角左边和宽高
        int x1 = 0, y1 = 0, w = 0, h = 0;
        // 原始图和截图界面的缩放图的比例
        float ratio = 0;

        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 如果是表单域 ，就是非文件上传元素
            if (item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString();
                // 设置截图左上角的x坐标
                if (name.equals("x1"))
                    x1 = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置截图左上角的y坐标
                if (name.equals("y1"))
                    y1 = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置截图的宽
                if (name.equals("w"))
                    w = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置截图的高
                if (name.equals("h"))
                    h = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置原始图和截图界面缩放图的比例
                if (name.equals("ratio"))
                    ratio = Float.parseFloat("".equals(value) ? "0" : value);
            }
            // 如果是二进制文件流
            else {
                // 把二进制流转化为图片缓存对象
                try {
                    bi = ImageIO.read(item.getInputStream());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        // 如果缓存图片不为空，则根据截图界面的坐标和宽高对原始图进行相应的裁剪
        if (null != bi)
            bi = cut(bi, (int) (x1 * ratio), (int) (y1 * ratio), (int) (w * ratio), (int) (h * ratio));

        // 返回裁剪后的图片
        return bi;

    }


    */
/**
     * 图像切割(按指定起点坐标和宽高切割)
     *
     * @param bi     需要裁剪的BufferedImage图
     * @param x1     起点坐标X
     * @param y1     起点坐标Y
     * @param width  目标宽度
     * @param height 目标高度
     *//*

    private BufferedImage cut(BufferedImage bi, int x1, int y1, int width, int height) {
        int srcWidth = bi.getWidth();
        int srcHeight = bi.getHeight();
        if (srcWidth <= 0 || srcHeight <= 0)
            return null;

        // 获取传入的Image资源图
        Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
        ImageFilter cropFilter = new CropImageFilter(x1, y1, width, height);
        // Image进行裁剪
        Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 创建画布，并绘制Image
        Graphics g = result.getGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();

        return result;
    }


}
*/
