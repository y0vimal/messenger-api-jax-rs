package org.vimal.development.messenger_rest_api.resources;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vimal.development.messenger_rest_api.model.Message;

@Path("/messages")
public class MessageResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return Arrays.asList(
				new Message(1L, "vimal", "Hello World!"),
				new Message(2L, "vimal", "Hello World!")
				);
		
	}
}
