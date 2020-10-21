package com.marketshrimp.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo {

    public static void main(String[] args) {
        new QuartzDemo().quartzTest();
    }

    public void quartzTest(){
        try {
            //获取调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            //创建任务器：定义任务细节
            JobDetail jobDetail = JobBuilder.newJob(SendMsgJob.class).withIdentity("sendMsgJob", "group1").build();
            // 每天早上8:30
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
            //定义触发器
            Trigger trigger=TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();

            //将任务和触发器注册到调度器中
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}