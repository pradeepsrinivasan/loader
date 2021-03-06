package com.flipkart.perf.server.config;

/**
 * Created by IntelliJ IDEA.
 * User: nitinka
 * Date: 25/10/12
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */

import com.yammer.dropwizard.config.Configuration;
import nitinka.jmetrics.JMetricConfig;

public class LoaderServerConfiguration extends Configuration {
    private String appName;
    private ScheduledExecutorConfig scheduledExecutorConfig;
    private ResourceStorageFSConfig resourceStorageFSConfig;
    private AgentConfig agentConfig;
    private MonitoringAgentConfig monitoringAgentConfig;
    private JobFSConfig jobFSConfig;
    private DataFixConfig dataFixConfig;
    private JMetricConfig jMetricConfig;
    private String reportConfigFile;
    private static LoaderServerConfiguration instance;

    public LoaderServerConfiguration() {
        instance = this;
    }

    public static LoaderServerConfiguration instance() {
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public ResourceStorageFSConfig getResourceStorageFSConfig() {
        return resourceStorageFSConfig;
    }

    public void setResourceStorageFSConfig(ResourceStorageFSConfig resourceStorageFSConfig) {
        this.resourceStorageFSConfig = resourceStorageFSConfig;
    }

    public AgentConfig getAgentConfig() {
        return agentConfig;
    }

    public void setAgentConfig(AgentConfig agentConfig) {
        this.agentConfig = agentConfig;
    }

    public JobFSConfig getJobFSConfig() {
        return jobFSConfig;
    }

    public void setJobFSConfig(JobFSConfig jobFSConfig) {
        this.jobFSConfig = jobFSConfig;
    }

    public MonitoringAgentConfig getMonitoringAgentConfig() {
        return monitoringAgentConfig;
    }

    public LoaderServerConfiguration setMonitoringAgentConfig(MonitoringAgentConfig monitoringAgentConfig) {
        this.monitoringAgentConfig = monitoringAgentConfig;
        return this;
    }

    public String getReportConfigFile() {
        return reportConfigFile;
    }

    public LoaderServerConfiguration setReportConfigFile(String reportConfigFile) {
        this.reportConfigFile = reportConfigFile;
        return this;
    }

    public DataFixConfig getDataFixConfig() {
        return dataFixConfig;
    }

    public LoaderServerConfiguration setDataFixConfig(DataFixConfig dataFixConfig) {
        this.dataFixConfig = dataFixConfig;
        return this;
    }

    public JMetricConfig getjMetricConfig() {
        return jMetricConfig;
    }

    public void setjMetricConfig(JMetricConfig jMetricConfig) {
        this.jMetricConfig = jMetricConfig;
    }

    public static LoaderServerConfiguration getInstance() {
        return instance;
    }

    public static void setInstance(LoaderServerConfiguration instance) {
        LoaderServerConfiguration.instance = instance;
    }

    public ScheduledExecutorConfig getScheduledExecutorConfig() {
        return scheduledExecutorConfig;
    }

    public void setScheduledExecutorConfig(ScheduledExecutorConfig scheduledExecutorConfig) {
        this.scheduledExecutorConfig = scheduledExecutorConfig;
    }
}


