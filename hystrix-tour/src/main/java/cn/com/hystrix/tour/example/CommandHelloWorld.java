package cn.com.hystrix.tour.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Random;

/**
 * 类HelloWorldHystrixCommond的实现描述：TODO
 *
 * @author yangying
 * @since 2019/7/11 11:25
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    private String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        Random random = new Random();
        boolean randomFail = random.nextBoolean();

        if (randomFail) {
            throw new RuntimeException("random fail throw a exception,");
        }
        return "hello " + name + "!";
    }

    @Override
    protected String getFallback() {
        return "fall back:hello " + name + "!";
    }
}
