package org.vimal.development.messenger_rest_api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vimal.development.messenger_rest_api.model.Comment;
import org.vimal.development.messenger_rest_api.service.CommentService;

@Path("/")
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getComments(@PathParam("messageId") long messageId){
		
		return commentService.getComments(messageId);
	}
	
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam ("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment postComment(@PathParam ("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@DELETE
	@Path ("/{commentId}")
	public void deleteComment(@PathParam ("messageId")long messageId, @PathParam("commentId") long commentId) {
			commentService.deleteComment(messageId, commentId);
	}
	
	@PUT
	@Path ("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId")long commentId, Comment comment) {
		return commentService.updateComment(messageId, commentId, comment);
		
	}
	
	
}
