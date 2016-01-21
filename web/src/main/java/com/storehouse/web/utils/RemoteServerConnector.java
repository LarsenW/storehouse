package com.storehouse.web.utils;

import java.io.IOException;
import java.net.SocketException;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteServerConnector {
	@Autowired
	private RemoteServerParamsResolver paramsResolver;

	private Map<String, String> params;

	@Autowired
	private FTPClient ftpClient;

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

	public boolean connectToRemoteServer() {
		params = paramsResolver.parse();
		try {
			ftpClient.connect(params.get("host"), new Integer(params.get("port")));
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Operation failed. Server reply code: " + replyCode);
				return false;
			}
			boolean success = ftpClient.login(params.get("user"), params.get("password"));
			showServerReply(ftpClient);
			if (!success) {
				System.out.println("Could not login to the server");
				return false;
			} else {
				System.out.println("LOGGED IN SERVER");
				return true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
