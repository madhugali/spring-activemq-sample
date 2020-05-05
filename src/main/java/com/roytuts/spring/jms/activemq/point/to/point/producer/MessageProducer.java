package com.roytuts.spring.jms.activemq.point.to.point.producer;

import javax.jms.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	private JmsTemplate jmsTemplate;

	private Queue produceQueue;

	private static final Logger logger_c = Logger.getLogger(MessageProducer.class);

	public void sendMessageToDefaultDestination(final String message) {
//		jmsTemplate.convertAndSend(message);
		logger_c.debug(
				"About to put message on queue. Queue[" + produceQueue.toString() + "] Message[" + message + "]");
		jmsTemplate.convertAndSend(produceQueue, message);
//		jmsTemplate_i.convertAndSend(testQueue_i, message_p);
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setProduceQueue(Queue produceQueue) {
		this.produceQueue = produceQueue;
	}

}