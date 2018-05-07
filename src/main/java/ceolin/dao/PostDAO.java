package ceolin.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ceolin.domain.Post;
import ceolin.manager.DynamoDBManager;

public class PostDAO {

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();
	
	public void saveOrUpdatePost(String id, String text, String voice) {
		Post post = new Post();
		post.setId(id);
		post.setText(text);
		post.setVoice(voice);
		mapper.save(post);
	}

}
