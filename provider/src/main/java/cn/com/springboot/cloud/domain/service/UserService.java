package cn.com.springboot.cloud.domain.service;

import cn.com.springboot.cloud.domain.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author yangying
 * @since on 2017/11/8.
 */
@Service
public class UserService {
    public User getUserByUserNo(String userNo){
        User user =  new User();
        user.setUserName("yangying");
        user.setUserNo("1111111111111");
        return user;
    }
}
