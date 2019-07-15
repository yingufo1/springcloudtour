package cn.com.hystrix.tour.example;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * 类CommandHelloWorldTest的实现描述：TODO
 *
 * @author yangying
 * @since 2019/7/11 11:33
 */
public class CommandHelloWorldTest {

    @Test
    public void syncExecute() {
        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("world");
        try {
            Assert.assertThat(commandHelloWorld.execute(), CoreMatchers.equalTo("hello world!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void asyExecute() {
        Future<String> asyCommand = new CommandHelloWorld("world").queue();
        try {
            Assert.assertThat(asyCommand.get(), CoreMatchers.equalTo("hello world!"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void toObservable() {
        Observable<String> fWord = new CommandHelloWorld("world").toObservable();
        Observable<String> bWord = new CommandHelloWorld("bob").toObservable();

        fWord.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                //do noting
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }
        });

        bWord.subscribe((v)->{
            System.out.println("onNext: "+v);
        },(exception)->{
            exception.printStackTrace();
        });
    }
}
