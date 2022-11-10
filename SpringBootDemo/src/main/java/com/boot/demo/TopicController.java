package com.boot.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TopicController {
	
	@Autowired
private TopicService tservice;
	
	@RequestMapping("/gett")
	@ResponseBody
	public List<Topic> getAllTopics() {
		return tservice.getAllTopics();
								
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		tservice.addTopic(topic);
	}

}
