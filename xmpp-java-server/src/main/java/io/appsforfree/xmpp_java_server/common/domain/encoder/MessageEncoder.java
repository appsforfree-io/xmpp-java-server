package io.appsforfree.xmpp_java_server.common.domain.encoder;

import java.io.StringWriter;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import io.appsforfree.xmpp_java_server.common.domain.Message;

public class MessageEncoder implements Encoder.Text<Message> {

	@Override
	public void init(EndpointConfig config) { }

	@Override
	public void destroy() { }

	@Override
	public String encode(Message object) throws EncodeException {
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jc = JAXBContext.newInstance(Message.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(object, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}

}
