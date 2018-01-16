package com.activeMQ.sendService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class sendService {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(String queueName, final String message){
			jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	System.out.println("========:"+session.createTextMessage(message).toString());
                return session.createTextMessage(message);
            }
        });
	}
}
