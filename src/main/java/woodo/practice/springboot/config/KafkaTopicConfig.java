package woodo.practice.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Value(value = "${spring.kafka.topic.name}")
	private String topicName;

	@Value(value = "${spring.kafka.topic-json.name}")
	private String topicJsonName;

	@Bean
	public NewTopic javaguidesTopic() {
		return TopicBuilder.name(topicName)
				.partitions(10)
				.build();
	}

	@Bean
	public NewTopic javaguidesJsonTopic() {
		return TopicBuilder.name(topicJsonName)
				.partitions(3)
				.replicas(1)
				.build();
	}
}
