package mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUpdate {

	public static void main(String[] args) {
		String uri = "mongodb+srv://admin:admin@mongodb-rb2mm.mongodb.net/test?retryWrites=true";
		MongoClient client = MongoClients.create(uri);
		
		MongoDatabase db = client.getDatabase("MongoDB");
		MongoCollection collection = db.getCollection("test");
		
		Document found = (Document) collection.find(new Document("name","Vinay")).first();
		
		if(found!=null) {
			System.out.println("found user");
			
			Document updatedAge = new Document("age",32);
			Document op = new Document("$set",updatedAge);
			
			collection.updateOne(found, op);
			
		}
		
	}

}
