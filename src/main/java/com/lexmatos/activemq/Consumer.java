package com.lexmatos.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import lombok.extern.java.Log;

@Log
public class Consumer {

	  private Connection connection;
	  private Session session;
	  private MessageConsumer consumer;

	  public void openConnection() throws JMSException {
	    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616?jms.messagePrioritySupported=true");
	    connection = connectionFactory.createConnection();
	  }

	  public void closeConnection() throws JMSException {
	    connection.close();
	  }

	  public void createConsumer(String queue) throws JMSException {
	    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    Destination destination = session.createQueue(queue);
	    consumer = session.createConsumer(destination);

	    connection.start();
	  }

	  public String receive(int timeout) throws JMSException {
	    Message message = consumer.receive(timeout);
	    TextMessage input = (TextMessage) message;

	    String text = input.getText();
	    log.info(String.format("%s received", text));

	    return text;
	  }
	}
