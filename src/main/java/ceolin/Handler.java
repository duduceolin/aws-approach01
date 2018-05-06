package ceolin;

import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class Handler {
	
	
	
	public String handle(RequestClass request, Context context) {

        LambdaLogger logger = context.getLogger();
		final UUID uuid = UUID.randomUUID();
		final String voice = request.getVoice();
		final String text = request.getText();
		
        logger.log("Generating new DynamoDB record ID : " + uuid.toString());
        logger.log("Input Text: " + text);
        logger.log("Selected voice: " + voice);
        
        return String.valueOf("response " + request);
    }
	
	public void createNewRecord() {
		
		
		
	}
	
	
	
}
