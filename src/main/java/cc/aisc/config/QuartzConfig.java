package cc.aisc.config;

import cc.aisc.commons.task.ScheduledTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by sjf on 16-9-29.
 */
@Configuration
public class QuartzConfig {

    private static final Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    @Autowired
    private ScheduledTask task;

    @Bean(name = "detailFactoryBean")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean ();
        //这儿设置对应的Job对象
        bean.setTargetObject(task);
        //这儿设置对应的方法名  与执行具体任务调度类中的方法名对应
        bean.setTargetMethod("work");
        bean.setConcurrent (false);
        return bean;
    }

    @Bean(name = "cronTriggerBean")
    public CronTriggerFactoryBean cronTriggerBean(){
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean ();
        trigger.setJobDetail (detailFactoryBean().getObject());
        trigger.setCronExpression ("*/10 */30 * ? * *");//每60秒执行一次
        return trigger;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactory(){
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean ();
        schedulerFactory.setTriggers(cronTriggerBean().getObject());
        return schedulerFactory;
    }
    /*private String config = "/job.properties";

    @Autowired
    private ApplicationContext context;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        logger.info("初始化quartz定时器");
        QuartzFactory factory = new QuartzFactory(config,context);
        return factory.build();
    }

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }*/
}
