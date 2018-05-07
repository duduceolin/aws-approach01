package ceolin;

import java.util.UUID;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.JsonObject;

import ceolin.dao.PostDAO;

public class Handler {

	static final String REGION = "";

	static DynamoDB db;

	public String handle(RequestClass request, Context context) {

		LambdaLogger logger = context.getLogger();
		final UUID uuid = UUID.randomUUID();
		final String voice = request.getVoice();
		final String text = request.getText();

		logger.log("Generating new DynamoDB record ID : " + uuid.toString());
		logger.log("Input Text: " + text);
		logger.log("Selected voice: " + voice);

		initDynamoDbClient(logger, uuid.toString(), voice, text);

		return String.valueOf("response " + request);
	}

	private void initDynamoDbClient(LambdaLogger logger, String id, String voice, String text) {
		PostDAO dao = new PostDAO();

		JsonObject obj = new JsonObject();
		obj.addProperty("id", id);
		obj.addProperty("text", text);
		obj.addProperty("voice", voice);
		
		logger.log(obj.toString());
		
		dao.saveOrUpdatePost(id, text, voice);
	}

}
