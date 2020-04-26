package org.vimal.development.messenger_rest_api.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private Long id;
	private String author;
	private Date created;
	private String content;
	
	public Message() {}
	
	
	public Message(Long id, String author, String content) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.created = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", author=" + author + ", created=" + created + ", content=" + content + "]";
	}
	

}
