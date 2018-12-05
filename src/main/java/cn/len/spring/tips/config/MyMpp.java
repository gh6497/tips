package cn.len.spring.tips.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.val;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author len
 *
 * @date 2018年 12月02日
 */
@Component
public class MyMpp implements Jackson2ObjectMapperBuilderCustomizer {
    /**
     * Customize the JacksonObjectMapperBuilder.
     *
     * @param jacksonObjectMapperBuilder the JacksonObjectMapperBuilder to customize
     */
    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
//        val objectMapper = new ObjectMapper();
        // 格式化器
        val localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        val localDateTimeFormatter = DateTimeFormatter.ofPattern("y-M/d H:m:s");
        val localTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        val javaTimeModule = new JavaTimeModule();
        // java8新特性 解决optional的输出问题
        val jdk8Module = new Jdk8Module();
        // 注册模块
//        objectMapper.registerModules(javaTimeModule, jdk8Module);

        // 序列化配置
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(localDateFormatter));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(localDateTimeFormatter));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(localTimeFormatter));
        // 配置Date序列化格式
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // 配置序列化的包含项，null值不输出
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 反序列化设置
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(localDateFormatter));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(localDateTimeFormatter));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(localTimeFormatter));
        jacksonObjectMapperBuilder.modules(javaTimeModule,jdk8Module);
    }
}
