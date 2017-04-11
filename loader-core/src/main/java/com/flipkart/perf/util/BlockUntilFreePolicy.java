package com.flipkart.perf.util;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by pradeep on 17/09/16.
 */
public class BlockUntilFreePolicy implements java.util.concurrent.RejectedExecutionHandler {

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
            afterEnqueue(runnable);
        } catch (InterruptedException ie) {
            throw new RejectedExecutionException(ie);
        }
    }

    protected void afterEnqueue(Runnable runnable) {

    }
}
