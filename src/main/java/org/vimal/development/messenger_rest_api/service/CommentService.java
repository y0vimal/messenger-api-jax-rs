package org.vimal.development.messenger_rest_api.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.vimal.development.messenger_rest_api.model.Comment;
import org.vimal.development.messenger_rest_api.model.Message;

import com.google.gson.Gson;

public class CommentService {
	
	private Session session = null;

	public List<Comment> getComments(long messageId){
		
		session = DatabaseService.getSession();
		
		session.beginTransaction();
		Message message = (Message) session.get(Message.class, messageId);
		
		System.out.println("message is : {}" + new Gson().toJson(message));
		
		session.getTransaction().commit();
		session.close();
		
		if(message == null) {
			System.out.print("No message found with message id : " + messageId);	
			return null;
		}
		  
		
		return (List<Comment>) message.getComments();
		
	}

	
	public Comment getComment(long messageId, long commentId) {
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		Message message = session.get(Message.class, messageId);
		session.getTransaction().commit();
		
		session.close();
		
		return message.getComments()
			   .stream()
			   .filter(comment -> comment.getCommentId() == commentId)
			   .findFirst()
			   .get();
		
		
		
	}


	public Comment addComment(long messageId, Comment comment) {
		
		session = DatabaseService.getSession();
		
		session.beginTransaction();
		
		Message message = session.get(Message.class, messageId);
		
		message.getComments().add(comment);
		
		session.update(message);
		
		session.getTransaction().commit();
		
		session.close();
		return comment;
		
		
	}


	public void deleteComment(long messageId, long commentId) {
		
		session = DatabaseService.getSession();
		
		session.beginTransaction();
		
		Message message = session.get(Message.class, messageId);
		System.out.println(message.getComments().removeIf(comment -> {
			
			 if(comment.getCommentId() == commentId) {
				 session.delete(comment);
				 return true;
			 }
			 return false;
		}));
		
		System.out.println("message after deletion :{} " + new Gson().toJson(message));
		session.update(message);
		
		session.getTransaction().commit();
		session.close();
		
	}


	public Comment updateComment(long messageId, long commentId, Comment updatedComment) {
		
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		Message message = session.get(Message.class, messageId);
		updatedComment.setCommentId(commentId);
		
		session.update(updatedComment);
		
		session.getTransaction().commit();
		session.close();
		return updatedComment;
	}
}
	 
