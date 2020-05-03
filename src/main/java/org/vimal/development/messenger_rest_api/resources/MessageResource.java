package org.vimal.development.messenger_rest_api.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.vimal.development.messenger_rest_api.model.Message;
import org.vimal.development.messenger_rest_api.service.MessageService;

import com.google.gson.Gson;

@Path("/messages")
public class MessageResource {
	
	private final MessageService messageService = new MessageService();
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageService.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam ("year") int year,
									 @QueryParam ("start") int start,
									 @QueryParam ("end") int end){
		
		return messageService.getAllMessages(year, start, end);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Message postMessage(Message message) {
		//return "Hello";
		LOGGER.info("message is  : {}", new Gson().toJson(message));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		
		try {
			Date date = simpleDateFormat.parse(
					message.getCreated());
			LOGGER.info("date is : {} " + date);
			
			simpleDateFormat.applyPattern("dd-MM-yyyy");
			String formattedDate = simpleDateFormat.format(date);
			LOGGER.info("formatted Date is : {} ", formattedDate);
			
			message.setCreated(formattedDate);
			
		
		}catch(ParseException e) {
			LOGGER.warn("Exception caught : {}", e.toString());
			
		}catch(Exception e) {
			LOGGER.warn("Exception caught : {}", e.toString());
			
		}
		return messageService.addMessage(message);
		
	}
	
	@GET
	@Path ("/{messageId}")
	@Produces (MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam ("messageId") long id) {
		return messageService.getMessage(id);
	}
	
	@PUT
	@Path ("/{messageId}")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message, @PathParam ("messageId") long id) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path ("/{messageId}")
	public void deleteMessage(@PathParam ("messageId") Long messageId) {
		messageService.deleteMessage(messageId);
	}
}
