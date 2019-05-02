package mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDelete {

	public static void main(String[] args) {
		String uri  = "mongodb+srv://admin:admin@mongodb-rb2mm.mongodb.net/test?retryWrites=true";
		MongoClient client = MongoClients.create(uri);
		
		MongoDatabase db = client.getDatabase("MongoDB");
		MongoCollection<Document> collection = db.getCollection("test");
		
		collection.deleteOne(new Document("name","Ambika"));
		collection.deleteMany(new Document("name","Vinay"));
	}

}
