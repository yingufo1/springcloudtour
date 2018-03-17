package cn.com.springboot.cloud.controller;

import cn.com.springboot.cloud.domain.entity.User;
import cn.com.springboot.cloud.domain.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangying on 2017/11/8.
 */
@RestController
@Log4j
public class QueryUserController {
    @Resource
    private UserService userService;

    @GetMapping("/queryUser")
    public User queryByUserNo(@RequestParam("userNo") String userNo){
        if(log.isDebugEnabled()){
            log.info("i find you");
        }
        return userService.getUserByUserNo(userNo);
    }
}
