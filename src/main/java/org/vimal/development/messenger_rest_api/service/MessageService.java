package org.vimal.development.messenger_rest_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.vimal.development.messenger_rest_api.hibernate.service.DatabaseService;
import org.vimal.development.messenger_rest_api.model.Message;


public class MessageService {
	
	private Session session = null;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageService.class);
	
	public List<Message> getAllMessages(){
		
		// return all the messages present in database
		List<Message> messageList = new ArrayList();
		try {
		session = DatabaseService.getSession();
		messageList =  Arrays.asList((Message) session.get(Message.class, 1L));
		return messageList;
		
		}catch(Exception e) {
			LOGGER.warn("exception caught: {} " , e.toString());
			return messageList;
			
		}finally {
			session.close();
		}
	
		
	}
	
	public Message addMessage(Message message) {
		
		Message returnMessage = null;
		try {
		
		LOGGER.info("creating the message");
		session = DatabaseService.getSession();
		session.beginTransaction();
		session.save(message);
		
		session.getTransaction().commit();
		
		returnMessage = (Message) session.get(Message.class, message.getId());
		return returnMessage;
		
		}catch(Exception e) {
			LOGGER.warn("exception caught while adding messages : {}", e.toString());
			return returnMessage;
		}finally {
			LOGGER.info("closing the session");
			session.close();
		}

		
	}

}