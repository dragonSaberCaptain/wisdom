import com.jskj.wisdom.config.common.Global;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName PACKAGE_NAME
 * @description
 * @date 2018-05-04 14:24 星期五
 */
public class TestMain {
    public static void main(String[] args) {
//        ThumbnailatorUtil.ImgScale("E:/主题壁纸/图片/看图片/IMG_0437.JPG", "E:/主题壁纸/图片/dragonSaberCaptain.jpg", 0.5f);
//        MongoCollection<Document> collection = MongodbUtil.createCollection("flib_1");
//        Document                  document   = collection.find(and(eq("name", "郭宏"), eq("phone", "13608045265"), eq("zjnum", "51010319710628511X"))).first();

//        String s1 = DigestUtils.md5Hex("666");
        //fae0b27c451c728867a567e8c1bb4e53
//        System.out.printf("--------------TestMain.main: %s %n", s1);
//        System.out.printf("--------------TestMain.main: %s %n", DigestUtils.md5Hex(Global.MD5_SALT + s1));
//
//        int    hashIterations    = 1;//加密的次数
//        Object credentials       = "fae0b27c451c728867a567e8c1bb4e53";//密码
//        String hashAlgorithmName = "MD5";//加密方式
//        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials, null,
//                hashIterations);
//        //78faa33e1582b852af8ae0158bddbdba
//        System.out.println("加密后的值----->" + simpleHash);

        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String result = new Md5Hash("fe7bfb09becc4e645420f3ad67b5147c", DigestUtils.md5Hex(Global.MD5_SALT + "999"), 1024).toString();
        System.out.printf("--------------TestMain.main: %s %n", result);
    }
}
