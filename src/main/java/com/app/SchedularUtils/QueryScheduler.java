package com.app.SchedularUtils;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by K.Kokulan on 3/2/2017.
 */
@Component
public class QueryScheduler extends QuartzJobBean {

    private QueryProcessor queryProcessor;

    public void setQueryProcessor(QueryProcessor queryProcessor) {
        this.queryProcessor = queryProcessor;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobContext)  throws JobExecutionException {
        queryProcessor.printX();
    }
}
