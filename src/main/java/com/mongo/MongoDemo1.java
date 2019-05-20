package com.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author Administrator 2019-01-23 09:51
 * 条件查询
 * 查询userid为1013的记录
 **/
public class MongoDemo1 {

    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("192.168.43.44");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //创建查询条件
        BasicDBObject bson = new BasicDBObject("userid","1013");
        //查询记录获取结果集合
        FindIterable<Document> documents = spit.find(bson);

        //遍历集合
        for (Document document:documents) {
            System.out.println("内容：" + document.getString("content"));
            System.out.println("用户id：" + document.getString("userid"));
        }
        client.close();
    }
}
