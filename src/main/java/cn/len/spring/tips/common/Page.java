package cn.len.spring.tips.common;

import lombok.Data;

/**
 * @author len
 * @date 2018年 11月12日
 */
@Data
public class Page {
    /**
     * 页码
     */


    private Long page;

    /**
     * 每页显示数量
     */
    private Integer size;
    @Data
    public static class QueryVo {
        private String param1;
        private String param2;
        private String param3;
        private String param4;
        private String param5;
        private String param6;
        private String param7;

        private String sort1;
        private String sort2;
        private String sort3;
        private String sort4;
        private String sort5;
        private String sort6;
        private String sort7;

        private String asc1;
        private String asc2;
        private String asc3;
        private String asc4;
        private String asc5;
        private String asc6;
        private String asc7;
    }

}
