package com.musican.SchedulerTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.ejb.Schedule;

/**
 * 定时任务测试
 */
//@Component
public class TestSchedulerTask {
    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("-----定时任务测试："+(count++));
    }
}
