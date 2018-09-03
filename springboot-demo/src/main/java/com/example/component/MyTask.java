package com.example.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
	/*@Scheduled(cron="0/5 * * * * *")*/
	public void work() {
		System.out.println("开始定时任务！！！");
	}
}
