package com.xulei.spring.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname SpiderExecutors
 * @Description TODO
 * @Date 2020/4/20 17:08
 * @Created by xulei
 */
@Component
public class SpiderExecutors {


//    int corePoolSize,
//    int maximumPoolSize,
//    long keepAliveTime,
//    TimeUnit unit,
//    BlockingQueue<Runnable> workQueue,
//    ThreadFactory threadFactory,
//    RejectedExecutionHandler handler


    /**
     * ExecutorServiceUtil
     */

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    @Bean(name ="spiderExecutor")
    public Executor spiderExecutor() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6,
                10,
                10,
                TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("spider-" + threadNumber.getAndIncrement());
                        return thread;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        return threadPoolExecutor;
    }
}
