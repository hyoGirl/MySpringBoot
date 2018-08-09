package com.rabbitmq.topic.nolisten.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {
	
	@Autowired
	private AmqpTemplate template;

	public void send() {
		
		template.convertAndSend("topicNoListenexchange","topicNoListen.s2", "hello,rabbit~~~~~~~~~~~~~~~~~~~~~~");
	}
}