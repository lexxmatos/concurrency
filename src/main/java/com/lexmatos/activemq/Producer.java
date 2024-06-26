package com.lexmatos.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import lombok.extern.java.Log;

@Log
public class Producer {

		  private Connection connection;
		  private Session session;
		  private MessageProducer producer;

		  public void openConnection() throws JMSException {
		    // Create a new connection factory
		    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		    connection = connectionFactory.createConnection();
		  }

		  public void closeConnection() throws JMSException {
		    connection.close();
		  }

		  public void createProducer(String queue) throws JMSException {
		    // Create a session for sending messages
		    session =
		        connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		    // Create the destination to which messages will be sent
		    Destination destination = session.createQueue(queue);

		    // Create a MessageProducer for sending the messages
		    producer = session.createProducer(destination);
		  }

		  public void send(String text) throws JMSException {
		    TextMessage message = session.createTextMessage(text);
		    producer.send(message);

		    log.info(String.format("%s sent with default priority(=4)",text));
		  }

		  public void send(String text, int priority) throws JMSException {
		    TextMessage message = session.createTextMessage(text);
		    // Note: setting the priority directly on the JMS Message does not work
		    // as in that case the priority of the producer is taken
		    producer.send(message, DeliveryMode.PERSISTENT, priority, 0);

		    log.info(String.format("%s sent with priority=%s", text, priority));
		  }
}
