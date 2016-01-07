package com.kafka.test;

public class KafkaProducerClient {

	public static void main(String[] args) {
		String host = args[0];
		String topic = args[1];

		KafkaProducer producer = new KafkaProducer(host, topic);
		producer.sendMessage();
		producer.cleanUp();
	}

}
