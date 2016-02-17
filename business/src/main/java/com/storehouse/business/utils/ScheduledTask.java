package com.storehouse.business.utils;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTask extends TimerTask {

	private Timer timer = new Timer();

	public ScheduledTask() {
		timer.schedule(this, 0, 1000);
	}

	public void run() {

	}
}
