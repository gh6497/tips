package cn.len.spring.tips.common;

import lombok.Data;

/**
 * @author len
 * @date 2018年 10月31日
 */
@Data
public class LenResponse {
    private Object data;

    private String msg;

    private Integer code;

    private Integer status;
}
