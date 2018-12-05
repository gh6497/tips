package cn.len.spring.tips.web.controller;

import cn.len.spring.tips.common.LenResponse;
import cn.len.spring.tips.common.Page;
import cn.len.spring.tips.domain.User;
import cn.len.spring.tips.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * @author len
 * @date 2018年 10月31日
 */
@RequestMapping("/user")
@RestController
@Api(value = "用户接口", tags = "用户接口")
public class UserController {
    private User user;

    @PostMapping
    @ApiOperation("添加用户")
    public List<User> add( @Valid UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            result.getFieldErrors()
                    .forEach(System.out::println);
            return null;
        }
        val dto = new UserDto();
//        var ddd = new UserDto();
        User user = new User();
        user.setAge(userDto.getAge());
        user.setBirthday(userDto.getBirthday());
        user.setLocalDateTime(userDto.getLocalDateTime());
        final List<User> user1 = List.of(user);
        return user1;
    }

    @GetMapping("/single")
    public LenResponse user(@ApiParam(value = "username", defaultValue = "124") String username) {
        System.out.println("username = " + username);
        return null;
    }

    /**
     *
     * @param page 分页
     * @param queryVo 参数
     *                param1:xxxx, param2:xxxxx, param3:xxxx, param4:xxxx, param5, xxxx
     * @return LenResponse
     */
    @GetMapping
    public LenResponse users(Page page, Page.QueryVo queryVo) {


        return null;
    }
}
