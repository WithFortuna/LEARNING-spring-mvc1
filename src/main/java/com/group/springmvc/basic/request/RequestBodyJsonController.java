package com.group.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.springmvc.basic.HelloDataDTO;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class RequestBodyJsonController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody = {}", body);

        HelloDataDTO helloData = objectMapper.readValue(body, HelloDataDTO.class);
        log.info("username: {}, age:{}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    //HttpEntity
    @RequestMapping("/request-body-json-httpentity")
    public void requestBodyJsonHttpEntity(HttpEntity<HelloDataDTO> httpEntity) {
        HelloDataDTO hello = httpEntity.getBody(); //HttpEntity<HelloDataDTO>였기에 .getBody()를 하면 HelloDataDTO.class 객체가 반환
        log.info("username: {}, age: {}", hello.getUsername(), hello.getAge());

    }
    //@RequestBody & objectMapper
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String body) throws IOException {

        log.info("messageBody = {}", body);

        HelloDataDTO helloData = objectMapper.readValue(body, HelloDataDTO.class);
        log.info("username: {}, age:{}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    //only @RequestBody
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public HelloDataDTO requestBodyJsonV3(@RequestBody HelloDataDTO helloData) throws IOException {

        log.info("messageBody = {}", helloData);

        log.info("username: {}, age:{}", helloData.getUsername(), helloData.getAge());

        return helloData; //HttpMessageConverter가 객체->json으로 변환해줌
    }

    //HttpEntity
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public String requestBodyJsonV5(HttpEntity<HelloDataDTO> data) throws IOException {

        HelloDataDTO helloData = data.getBody();

        log.info("username: {}, age:{}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }
}
