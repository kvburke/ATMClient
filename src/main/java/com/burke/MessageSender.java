package com.burke;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="singleton")
@Component
public class MessageSender {
	
	//URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	// default broker URL is : tcp://localhost:61616"
	private static String subject = "JCG_QUEUE"; // Queue Name.You can create any/many queue names as per your requirement.	
	
	public void sendmessage(int accountnumber, String message, int creditscore, int savingsbalance, int currentbalance) throws JMSException {		
		// Getting JMS connection from the server and starting it
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		//Creating a non transactional session to send/receive JMS message.
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);	
		
		//Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
		//The queue will be created automatically on the server.
		Destination destination = session.createQueue(subject);	
		
		// MessageProducer is used for sending messages to the queue.
		MessageProducer producer = session.createProducer(destination);
		
		// We will send a small text message saying 'Hello World!!!' 
		Account object1= new Account();
		Account object2= new Account();
		Account object3= new Account();
		Account object4= new Account();
		
		
		
		object1.setAccountnumber(accountnumber);
		object1.setMessage(message);
		object1.setHistory(null);
		object1.setCreditscore(creditscore);
		object1.setSavingsbalance(savingsbalance);
		object1.setCurrentbalance(currentbalance);

		
	//	object2.setAccountnumber(1001);
	//	object2.setMessage("1001abcd");
	//	object2.setHistory(null);
	//	object2.setCreditscore(500);
	//	object2.setSavingsbalance(300);
	//	object2.setCurrentbalance(600);
		
		
	//	object3.setAccountnumber(1002);
	//	object3.setMessage("1002abcd");
	//	object3.setHistory(null);
	//	object3.setCreditscore(700);
	//	object3.setSavingsbalance(500);
	//	object3.setCurrentbalance(300);
		
		
	//	object4.setAccountnumber(1003);
	//	object4.setMessage("1003abcd");
	//	object4.setHistory(null);
	//	object4.setCreditscore(800);
	//	object4.setSavingsbalance(1500);
	//	object4.setCurrentbalance(3300);
		
		
		
		ObjectMessage obj1= session.createObjectMessage();
		obj1.setObject(object1);
	//	ObjectMessage obj2= session.createObjectMessage();
	//	obj2.setObject(object2);
	//	ObjectMessage obj3= session.createObjectMessage();
	//	obj3.setObject(object3);
	//	ObjectMessage obj4= session.createObjectMessage();
	//	obj4.setObject(object4);
	
		// Here we are sending our message!
		producer.send(obj1);
	//	producer.send(obj2);
	//	producer.send(obj3);
	//	producer.send(obj4);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
	}
}