package com.storehouse.web.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.xml.parsers.SAXParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Component
public class RemoteServerParamsResolver {
	@Autowired
	ServletContext servletContext;

	@Autowired
	private SAXParser parser;

	private String configFilePath;

	private String serverHost;

	private int serverPort;

	private String user;

	private String password;

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
				serverHost = new String(ch, start, length);
			}
			if (thisElement.equals("port")) {
				serverPort = new Integer(new String(ch, start, length));
			}
			if (thisElement.equals("user")) {
				user = new String(ch, start, length);
			}
			if (thisElement.equals("password")) {
				password = new String(ch, start, length);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			thisElement = "";
		}
	};

	public RemoteServerParamsResolver() {

	}

	public void parse() {
		try {
			configFilePath = servletContext.getRealPath("/WEB-INF/ftp-server-params.xml");
			parser.parse(new File(configFilePath), handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "RemoteServerParamsResolver [serverHost=" + serverHost + ", serverPort=" + serverPort + ", user=" + user
				+ ", password=" + password + "]";
	}

}
