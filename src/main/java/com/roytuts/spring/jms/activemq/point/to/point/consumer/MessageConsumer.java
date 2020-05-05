package com.roytuts.spring.jms.activemq.point.to.point.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roytuts.spring.jms.activemq.point.to.point.producer.MessageProducer;

@Component
public class MessageConsumer implements MessageListener {
	
	private MessageProducer messageProducer;

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				String msg = ((TextMessage) message).getText();
				System.out.println("Message has been consumed : " + msg);
				messageProducer.sendMessageToDefaultDestination(msg);
			} catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
	}

	public void setMessageProducer(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

}
