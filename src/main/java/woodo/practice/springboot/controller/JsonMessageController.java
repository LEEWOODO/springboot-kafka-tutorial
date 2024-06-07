package woodo.practice.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import woodo.practice.springboot.kafka.JsonKafkaProducer;
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
@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {

	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@PostMapping("/publish")
	private ResponseEntity<String> publish(@RequestBody User user) {
		kafkaProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json Message sent to the topic");
	}
}
