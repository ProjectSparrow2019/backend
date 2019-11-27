package br.com.sparrow.backend;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {
	
	@Value("${spring.activemq.broker-url}")
	private String BROKER_URL; 
	
	@Value("${spring.activemq.user}")
	private String BROKER_USERNAME; 
	
	@Value("${spring.activemq.password}")
	private String BROKER_PASSWORD;

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    connectionFactory.setPassword(BROKER_USERNAME);
	    connectionFactory.setUserName(BROKER_PASSWORD);
	    return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}
	
//	@Bean
//	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
//	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//	    factory.setConnectionFactory(connectionFactory());
//	    factory.setConcurrency("1-1");
//	    return factory;
//	}
}
