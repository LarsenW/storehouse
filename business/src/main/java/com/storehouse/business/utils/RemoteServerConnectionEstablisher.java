package com.storehouse.business.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RemoteServerConnectionEstablisher {
	private static boolean connectionEstablished = false;

	@Autowired
	private RemoteServerConnector serverConnector;

	@Pointcut("execution(* com.storehouse.business.services.impl.UserCreatingServiceImpl.createUser(..)) ||"
			+ " execution (* com.storehouse.business.services.impl.ItemCreatingServiceImpl.createItem(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void establishConnection(JoinPoint jp) {
		if (!connectionEstablished) {
			if (serverConnector.connectToRemoteServer()) {
				connectionEstablished = true;
			}
		}

	}

	@After("pointcut()")
	public void disconnect(JoinPoint jp) {
		if (connectionEstablished) {
			if (serverConnector.disconnect()) {
				connectionEstablished = false;
			}
		}
	}
}
