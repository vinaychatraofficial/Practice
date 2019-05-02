package mongo;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

public class MongoAggregation {

	public static void main(String[] args) {
		String uri  = "mongodb+srv://admin:admin@mongodb-rb2mm.mongodb.net/test?retryWrites=true";
		MongoClient client = MongoClients.create(uri);
		
		MongoDatabase db = client.getDatabase("MongoDB");
		MongoCollection collection = db.getCollection("test");
		
		Block<Document> printBlock = document -> System.out.println(document.toJson());
		
		collection.aggregate(
			Arrays.asList(
				Aggregates.match(Filters.eq("age",34)),
				Aggregates.group("$sex",Accumulators.sum("count", 1))
					)
			
				).forEach(printBlock);
	}

}
