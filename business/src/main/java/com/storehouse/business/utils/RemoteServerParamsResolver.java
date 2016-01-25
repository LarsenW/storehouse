package com.storehouse.business.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Component
public class RemoteServerParamsResolver {
	@Autowired
	private SAXParser parser;

	private Map<String, String> params = new HashMap<>();

	private DefaultHandler handler = new DefaultHandler() {
		private String thisElement;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			thisElement = qName;
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			if (thisElement.equals("host")) {
				params.put("host", new String(ch, start, length));
			}
			if (thisElement.equals("port")) {
				params.put("port", new String(ch, start, length));
			}
			if (thisElement.equals("user")) {
				params.put("user", new String(ch, start, length));
			}
			if (thisElement.equals("password")) {
				params.put("password", new String(ch, start, length));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			thisElement = "";
		}
	};

	public RemoteServerParamsResolver() {

	}

	public Map<String, String> parse() {
		try {			
			parser.parse(new ClassPathResource("ftp-server-params.xml").getInputStream(), handler);
			return params;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
