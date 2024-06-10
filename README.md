# springboot-kafka-tutorial

## kafka
   1. 설치 : https://kafka.apache.org/quickstart
   2. 실행 : 
      - zookeeper 실행 : bin/zookeeper-server-start.sh config/zookeeper.properties
      - kafka 실행 : bin/kafka-server-start.sh config/server.properties
   3. topic 생성
      - bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
   4. topic 확인
      - bin/kafka-topics.sh --list --bootstrap-server localhost:9092
   5. topic 삭제
      - bin/kafka-topics.sh --delete --topic quickstart-events --bootstrap-server localhost:9092
   6. producer 실행
      - bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
   7. consumer 실행
      - bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092