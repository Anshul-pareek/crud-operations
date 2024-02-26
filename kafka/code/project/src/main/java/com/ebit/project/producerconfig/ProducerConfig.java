package com.ebit.project.producerconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerConfig {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	public void sendMessage(String message) {
		kafkaTemplate.send("user-topic", message);
	}

}
