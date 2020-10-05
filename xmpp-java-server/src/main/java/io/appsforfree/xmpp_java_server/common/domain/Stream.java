package io.appsforfree.xmpp_java_server.common.domain;

public class Stream {
	
	private String id;
	private String from;
	private String to;
	
	public Stream(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	public Stream(String id, String from, String to) {
		this.id = id;
		this.from = from;
		this.to = to;
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getFrom() { return from; }
	public void setFrom(String from) { this.from = from; }
	
	public String getTo() { return to; }
	public void setTo(String to) { this.to = to; }
	
}
