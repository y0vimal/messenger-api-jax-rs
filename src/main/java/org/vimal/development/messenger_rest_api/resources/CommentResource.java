package org.vimal.development.messenger_rest_api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vimal.development.messenger_rest_api.model.Comment;
import org.vimal.development.messenger_rest_api.service.CommentService;

@Path("/")
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class CommentResource {
	
	/*
	 * private final CommentService commentService = new CommentService();
	 * 
	 * @GET public List<Comment> getComments() { return
	 * commentService.getComments(); }
	 * 
	 * @POST public Comment postComment(Long messageId, Comment comment) { return
	 * commentService.postComment(messageId, comment); }
	 */

}
