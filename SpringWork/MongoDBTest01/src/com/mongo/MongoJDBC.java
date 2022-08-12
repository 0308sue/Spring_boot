package com.mongo;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoJDBC {
	public static void main(String[] args) {
		System.out.println("MongoJDBC");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("testDB");	 
	    MongoCollection<Document> collections = db.getCollection("emp");
		System.out.println("데이터베이스 이름: " +db.getName());
		FindIterable<Document> iterate=collections.find();
		MongoCursor<Document> cursor=iterate.iterator();
		while(cursor.hasNext()) {
			Document document=cursor.next();
			String JsonResult=document.toJson();
			System.out.println(JsonResult);
		}
		mongoClient.close();
	}

}
