package com.lexmatos.activemq;

import org.junit.jupiter.api.Assertions;

import javax.jms.JMSException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProducerTest {
	  private static Consumer consumer;
	  private static Producer producer;

	  private static String QUEUE = "priority.q";

//	  @BeforeAll
	  public static void setUpBeforeClass() throws JMSException {
	    producer = new Producer();
	    producer.openConnection();
	    producer.createProducer(QUEUE);

	    consumer = new Consumer();
	    consumer.openConnection();
	    consumer.createConsumer(QUEUE);
	  }

//	  @AfterAll
	  public static void tearDownAfterClass() throws JMSException {
	    producer.closeConnection();
	    consumer.closeConnection();
	  }

//	  @Test
	  public void testSend() throws JMSException, InterruptedException {
	    producer.send("message1");
	    producer.send("message2");
	    producer.send("message3");

	    Thread.sleep(10000);
	    // FIFO
	    Assertions.assertEquals("message1", consumer.receive(5000));
	    Assertions.assertEquals("message2", consumer.receive(5000));
	    Assertions.assertEquals("message3", consumer.receive(5000));
	  }

//	  @Test
	  public void testSendWithPriority() throws JMSException, InterruptedException {
	    producer.send("message1", 1);
	    producer.send("message2", 2);
	    producer.send("message3", 3);

	    Thread.sleep(50000);

	    Assertions.assertEquals("message3", consumer.receive(5000));
	    Assertions.assertEquals("message2", consumer.receive(5000));
	    Assertions.assertEquals("message1", consumer.receive(5000));
	  }
}
