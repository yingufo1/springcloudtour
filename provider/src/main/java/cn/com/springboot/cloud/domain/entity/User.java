package cn.com.springboot.cloud.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * Created by yangying on 2017/11/8.
 */
@Setter
@Getter
@Table(name = "user")
public class User {
    private String userName;
    private String userNo;
}
