package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonModel;

import java.util.Date;

public class Scheduling extends CommonModel {

   /*
   public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";
    private Long jobId;

    private Date createTime;

    private Date updateTime;
    *//**
     * 任务名称
     *//*
    private String jobName;
    *//**
     * 任务分组
     *//*
    private String jobGroup;
    *//**
     * 任务状态 是否启动任务
     *//*
    private String jobStatus;
    *//**
     * cron表达式
     *//*
    private String cronExpression;
    *//**
     * 描述
     *//*
    private String description;
    *//**
     * 任务执行时调用哪个类的方法 包名+类名
     *//*
    private String beanClass;
    *//**
     * 任务是否有状态
     *//*
    private String isConcurrent;
    *//**
     * spring bean
     *//*
    private String springId;
    *//**
     * 任务调用的方法名
     *//*
    private String methodName;
*/

    private String scdlName;

    private Date beginAt;

    private Date upTo;

    private String cronExp;

    private String taskType;

    private String taskId;

    public String getScdlName() {
        return scdlName;
    }

    public void setScdlName(String scdlName) {
        this.scdlName = scdlName == null ? null : scdlName.trim();
    }

    public Date getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(Date beginAt) {
        this.beginAt = beginAt;
    }

    public Date getUpTo() {
        return upTo;
    }

    public void setUpTo(Date upTo) {
        this.upTo = upTo;
    }

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp == null ? null : cronExp.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}