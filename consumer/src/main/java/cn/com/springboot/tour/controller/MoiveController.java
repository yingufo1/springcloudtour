package cn.com.springboot.tour.controller;

import cn.com.springboot.tour.domain.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by yangying on 2017/11/8.
 */
@RestController
public class MoiveController {
    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/movie/findUser")
    public User findByUserNo(@RequestParam String userNo){
        return  this.restTemplate.getForObject("http://localhost:8000/queryUser?userNo="+userNo,User.class);
    }
}
