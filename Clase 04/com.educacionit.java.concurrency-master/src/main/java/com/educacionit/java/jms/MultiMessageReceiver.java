package com.educacionit.java.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class MultiMessageReceiver {

    private static final Logger logger = Logger.getLogger(MessageSender.class);

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String subject = "EDUCACIONIT_QUEUE";

    public static void main(String[] args) throws JMSException {
        // Getting JMS connection from the server
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Creating session for seding messages
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Getting the queue'
        Destination destination = session.createQueue(subject);

        // MessageConsumer is used for receiving (consuming) messages
        MessageConsumer consumer = session.createConsumer(destination);

        while (true) {

            logger.info("Waiting...");
            Message message = consumer.receive();

            Runnable r = () -> {

                try {

                    // We will be using TestMessage in our example. MessageProducer sent us a TextMessage
                    // so we must cast to it to get access to its .getText() method.
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;

                        logger.info("Received message '" + textMessage.getText() + "'");
                        Thread.sleep(10000);

                    }
                } catch (Exception e) {
                }
            };

            Thread t = new Thread(r);
            t.start();
        }
    }
}
