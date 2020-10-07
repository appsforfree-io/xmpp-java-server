package io.appsforfree.xmpp_java_server.common.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stream {
	
	private String id;
	private String from;
	private String to;
	
	public String getId() { return id; }
	@XmlAttribute
	public void setId(String id) { this.id = id; }
	
	public String getFrom() { return from; }
	@XmlAttribute
	public void setFrom(String from) { this.from = from; }
	
	public String getTo() { return to; }
	@XmlAttribute
	public void setTo(String to) { this.to = to; }
	
}
