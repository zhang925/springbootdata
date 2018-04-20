package com.zzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 此类是解决 html 跨域 不能访问的问题
 *  安全性 有待测试
 *
 */
@Configuration
public class CorsConfig {
 /*
 解决 跨域 问题
 方法一【测试可用】：把本类 复制到项目中
 方法二【测试 [不] 可用】：html加：
 		<meta name="_csrf" th:content="${_csrf.token}">
		<meta name="_csrf_header" th:content="${_csrf.headerName}">
 方法三【测试 [不] 可用】：js 最开始 加：
   var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
*/

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}