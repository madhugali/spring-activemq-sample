import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roytuts.spring.jms.activemq.point.to.point.producer.MessageProducer;

public class SpringJmsActiveMqPointToPointApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/activemq-jms-spring-context.xml");
		MessageProducer messageProducer = (MessageProducer) applicationContext
				.getBean("messageProducer");
		messageProducer
				.sendMessageToDefaultDestination("Send this message to default destination.");
	}
	
}