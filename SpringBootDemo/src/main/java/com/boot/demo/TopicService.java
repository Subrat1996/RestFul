package com.boot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(new Topic(102,"spring","java framework")));
	
	
	public List<Topic> getAllTopics(){
		
		return topics;
	}

	public void addTopic(Topic topic) {
		
		topics.add(topic);
	}

}
