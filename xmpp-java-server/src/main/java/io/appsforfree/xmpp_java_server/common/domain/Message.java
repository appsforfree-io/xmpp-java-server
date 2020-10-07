package io.appsforfree.xmpp_java_server.common.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	@XmlAttribute
	private String from;
	@XmlAttribute
	private String to;
	@XmlElement
	private String body;
	
	public void setFrom(String from) { this.from = from; }
	public String getFrom() { return from; }
	
	public void setTo(String to) { this.to = to; }
	public String getTo() { return to; }
	
	public void setBody(String body) { this.body = body; }
	public String getBody() { return body; }
	
}
