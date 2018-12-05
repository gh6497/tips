package cn.len.spring.tips.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author len
 * @date 2018年 10月31日
 */
@Data
public class UserDto {
    @Length(min = 6)
    @ApiModelProperty("6-20个字符")
    private String username;
    @Length(min = 6)
    private String password;
    private Integer age;
    @Past
    @ApiModelProperty("必须过去的时间")
    private LocalDate birthday;

    private LocalDateTime localDateTime;
}


