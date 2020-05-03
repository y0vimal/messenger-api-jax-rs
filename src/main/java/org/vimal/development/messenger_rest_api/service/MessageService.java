package org.vimal.development.messenger_rest_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.vimal.development.messenger_rest_api.model.Message;
import org.vimal.development.messenger_rest_api.model.Profile;


public class MessageService {
	
	private Session session = null;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageService.class);
	
	public List<Message> getAllMessages(){
		
		// return all the messages present in database
		List<Message> messageList = new ArrayList();
		try {
		session = DatabaseService.getSession();
		
//		messageList =  Arrays.asList((Message) session.get(Message.class, 1L));
//		return messageList;
		
		Query query = session.createQuery("from Message");
		messageList = query.list();
		LOGGER.info("------------- logging the message list ----------");
		
		messageList.stream()
				   .forEach(message -> LOGGER.info("message {} : {}", message.getId(), message));
		
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

	public Message getMessage(long id) {
		
		session = DatabaseService.getSession();
		session.beginTransaction();
		Message message = (Message) session.get(Message.class, id);
		session.getTransaction().commit();
		session.close();
		return message;
		
		
		
	}

	public Message updateMessage(Message message) {
		
		session = DatabaseService.getSession();
		session.beginTransaction();

		session.update(message);
		session.getTransaction().commit();
		session.close();
		return message;
		
		
	}

	public void deleteMessage(Long messageId) {
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		Message message = session.get(Message.class, messageId);
		if(message == null) {
			LOGGER.info("message to be delted, does not exist");
			return;
		}
		session.delete(message);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
