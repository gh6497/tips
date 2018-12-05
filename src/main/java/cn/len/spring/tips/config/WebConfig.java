package cn.len.spring.tips.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * @author len
 * @date 2018年 10月31日
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<>(){
            /**
             * Convert the source object of type {@code S} to target type {@code T}.
             *
             * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
             * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
             * @throws IllegalArgumentException if the source cannot be converted to the desired target type
             */
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };
    }
    /**
     * Add {@link Converter Converters} and {@link Formatter Formatters} in addition to the ones
     * registered by default.
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<LocalDateTime>() {
            /**
             * Parse a text String to produce a T.
             *
             * @param text   the text string
             * @param locale the current user locale
             * @return an instance of T
             * @throws ParseException           when a parse exception occurs in a java.text parsing library
             * @throws IllegalArgumentException when a parse exception occurs
             */
            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }

            /**
             * Print the object of type T for display.
             *
             * @param object the instance to print
             * @param locale the current user locale
             * @return the printed text string
             */
            @Override
            public String print(LocalDateTime object, Locale locale) {
                return object.format(DateTimeFormatter.ofPattern("y-M-d h:m:s"));
            }
        });
    }
}
