package mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoInsert {

	public static void main(String[] args) {
		String uri = "mongodb+srv://admin:admin@mongodb-rb2mm.mongodb.net/test?retryWrites=true";
		MongoClient mongoClient = MongoClients.create(uri);
		
		MongoDatabase mongoDb = mongoClient.getDatabase("MongoDB");
		MongoCollection collection = mongoDb.getCollection("test");
		
		Document document = new Document();
		document.append("name", "Vinay");
		document.append("age", "34");
		document.append("sex", "male");
		
		Document address = new Document("city","Bangalore");
		document.append("address", address);
		collection.insertOne(document);
	}

}
