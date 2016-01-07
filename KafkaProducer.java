package com.kafka.test;

import java.io.IOException;
import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {
	private final kafka.javaapi.producer.Producer<Integer, String> producer;
	private final String topic;
	private final Properties props = new Properties();
	private final String host;

	public KafkaProducer(String host, String topic) {
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("metadata.broker.list", host);
		// Use random partitioner. Don't need the key type. Just set it to
		// Integer.
		// The message is of type String.
		producer = new kafka.javaapi.producer.Producer<Integer, String>(
				new ProducerConfig(props));
		this.topic = topic; //This is the topic name (queue name)
		this.host = host;
	}

	public void sendMessage() {
		String messageStr;
		try {
			System.out.println("Sending a message");
			messageStr = "Test case for Mist";
			producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
			System.out.println("Message Sent=" + messageStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cleanUp(){
		if(null != producer){
			producer.close();
		}
	}
}
