import com.jskj.wisdom.utils.mongodb.MongodbUtil;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

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
        MongoCollection<Document> collection = MongodbUtil.createCollection("flib_1");
        Document                  document   = collection.find(and(eq("name", "郭宏"), eq("phone", "13608045265"), eq("zjnum", "51010319710628511X"))).first();
    }
}
