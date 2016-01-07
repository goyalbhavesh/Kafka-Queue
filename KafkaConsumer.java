package com.kafka.test;

import java.io.IOException;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
 
public class KafkaConsumer implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;
 
    public KafkaConsumer(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }
 
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext()){
        	String messageStr = new String(it.next().message());       	
        }
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
}