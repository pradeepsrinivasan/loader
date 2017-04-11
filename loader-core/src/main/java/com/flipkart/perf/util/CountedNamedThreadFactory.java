package com.flipkart.perf.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pradeep on 17/09/16.
 */
public class CountedNamedThreadFactory implements ThreadFactory {
    private final AtomicInteger threadCount = new AtomicInteger(0);
    private final String prefix;

    public CountedNamedThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    public Thread newThread(Runnable r) {
        return new Thread(r, prefix + threadCount.getAndIncrement());
    }

}
