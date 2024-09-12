package com.group.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServlet;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@Slf4j
public class RequestHeaderController {
//    private final Logger log = LoggerFactory.getLogger(RequestHeaderController.class); //@Slf4j 와 같은 효과

    @RequestMapping("/headers")
    public String getHeaderInfo(HttpServletRequest request, HttpServletResponse response,
                                HttpMethod method,
                                Locale locale,
                                @RequestHeader MultiValueMap<String, String> headerMap,
                                @RequestHeader("host") String host,
                                @CookieValue(value = "myCookie", required = false) String cookie) {
        log.info("request = {}", request);
        log.info("response = {}", response);
        log.info("httpMethod = {}", method);
        log.info("locale = {}", locale);
        log.info("headerMap = {}", headerMap);
        log.info("host = {}", host);
        log.info("myCookie = {}", cookie);

        return "ok";

    }
}
