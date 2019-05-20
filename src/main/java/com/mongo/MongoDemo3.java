package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator 2019-01-23 09:51
 * 插入数据
 * 查询浏览量大于1000的记录
 **/
public class MongoDemo3 {

    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("192.168.43.44");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        Map<String,Object> map = new HashMap<>();
        map.put("content","我要吐槽");
        map.put("userid","1015");
        map.put("visits",123);
        map.put("publishtime",new Date());

        Document document = new Document(map);
        spit.insertOne(document);
        client.close();
    }
}
