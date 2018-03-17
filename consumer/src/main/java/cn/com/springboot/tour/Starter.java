package cn.com.springboot.tour;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yangying on 2017/11/8.
 */
@SpringBootApplication
public class Starter {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Starter.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
    }
}
