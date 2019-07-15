package cn.com.springboot.cloud.ResourceIsolator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 被注解标记的接口需要设置资源,可为接口设置的资源是线程池或信号量
 *
 * @author yangying
 * @since 2019/7/15 16:55
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceIsolateable {
    /**
     * 隔离策略
     */
    public enum IsolateStrategy{
        /**
         * 线程池
         */
        THREADPOOL,
        /**
         * 信号量
         */
        SEMAPHORE;
        private IsolateStrategy(){
            // to do nothing
        }
    }
    /**
     * 隔离策略.{@link IsolateStrategy},默认值{@code IsolateStrategy.THREADPOOL}
     * @return
     */
    IsolateStrategy isolateStrategy() default IsolateStrategy.THREADPOOL;

    int coreThreadPoolSize() default 10;

    int maxThreadPollSize() default 10;

    int maxSemaphoreSiz() default 10;
}
