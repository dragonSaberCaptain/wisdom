package com.jskj.wisdom.utils.pic;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.utils.safety.UuidUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils.pic
 * @description
 * @date 2018-05-18 10:38 星期五
 */
public class PicUtil {
    private static final Logger logger = LoggerFactory.getLogger(PicUtil.class);

    public static String savePic(MultipartFile imageFile, double scale) {
        long timeStamp = System.currentTimeMillis();


        String filePath = Global.VIDEO_PICTURE_PATH + timeStamp + "/";
        File   picFile  = new File(filePath);
        //判断图片路径是否存在，若不存在则创建
        boolean bool = true;
        if (!picFile.exists()) {
            bool = picFile.mkdirs();
        }
        String UUid = UuidUtil.creatUUID();

        //图片完整路径
        String picPath = filePath + UUid;
        if (bool) {
            // 先尝试压缩并保存图片
            ThumbnailatorUtil.ImgScale(imageFile, picPath, scale);
        }
        //返回的路径
        return timeStamp + "/" + UUid + ".jpg";
    }

    public static String getImageStr(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in   = null;
        byte[]      data = null;
        File        file;
        try {
            file = new File(imgFile);
            if (!file.exists()) {
                return null;
            }
        } catch (Exception e) {
            logger.error("PicUtil--getImageStr", e);
            return null;
        }

        // 读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 返回Base64编码过的字节数组字符串
        return Base64.encodeBase64String(data);
    }
}
