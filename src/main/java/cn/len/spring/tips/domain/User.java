package cn.len.spring.tips.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author len
 * @date 2018年 10月31日
 */
@Data
public class User {
    private String username;


    private String  password;

    private Integer age;



    private LocalDate birthday;

    private Integer status;

    private Long createdTime;

    private LocalDateTime localDateTime;

    private String location;


}
