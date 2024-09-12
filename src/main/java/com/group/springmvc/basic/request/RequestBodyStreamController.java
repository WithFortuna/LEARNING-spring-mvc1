package com.group.springmvc.basic.request;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletInputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

//--------------------------------------------------request_body에 담긴 데이터 꺼내기
@Slf4j
@Controller
public class RequestBodyStreamController {
    @PostMapping("/request-body-string-v1")
    public void requestBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();

        String responseBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("body: {}", responseBody);

        response.getWriter().write("ok");

    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer writer) throws IOException {

        String responseBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("body: {}", responseBody);

        writer.write("ok");

    }


    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();
        log.info("body: {}", messageBody);


        return new HttpEntity<>("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String body) throws IOException {

        log.info("body: {}", body);


        return "ok";
    }

}
