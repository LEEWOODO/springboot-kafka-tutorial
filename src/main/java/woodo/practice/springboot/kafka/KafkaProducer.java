package woodo.practice.springboot.kafka;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	@Value(value = "${spring.kafka.topic.name}")
	private String topicName;

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("Producing message sent -> %s", message));
		kafkaTemplate.send(topicName, message);
	}
}
