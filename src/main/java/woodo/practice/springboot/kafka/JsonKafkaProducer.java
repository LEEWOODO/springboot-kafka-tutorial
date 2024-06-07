package woodo.practice.springboot.kafka;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import woodo.practice.springboot.payload.User;

/**
 * Project        : springboot-kafka-tutorial
 * DATE           : 6/7/24
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 6/7/24      dnejdzlr2          최초 생성
 */
@Service
public class JsonKafkaProducer {

	@Value(value = "${spring.kafka.topic-json.name}")
	private String topicJsonName;

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendJsonMessage(User data) {
		LOGGER.info(String.format("Producing json message -> %s", data));

		Message<User> message = MessageBuilder
			.withPayload(data)
			.setHeader(KafkaHeaders.TOPIC, topicJsonName)
			.build();

		kafkaTemplate.send(message);

	}
}
