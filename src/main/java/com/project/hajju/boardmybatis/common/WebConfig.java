package com.project.hajju.boardmybatis.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
        업로드된 파일을 웹 브라우저에서 직접 접근할 수 있도록 매핑하는 역할을 하는 클래스.
        /upload/** 로 시작하는 모든 요청을 처리하고, 요청된 파일을 D:/boardMybatis/폴더에서 찾도록 설정.
    */
    @Value("${file.directory}")
    private String fileDirectory;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")           // view에서 사용할 경로
                .addResourceLocations("file:" + fileDirectory);      // 실제 파일 저장 경로
    }
}
