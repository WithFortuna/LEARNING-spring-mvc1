package com.group.springmvc.basic.request;

import com.group.springmvc.basic.HelloDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");

    }

    @ResponseBody // 반환 문자열을 response body에 바로 담아버린다. 즉, @Controller임에도 viewName으로 취급x
    @RequestMapping("request-param-v2")
    public String requestParamV2(@RequestParam("username") String username, @RequestParam("age") int age) {

        log.info("username = {}, age = {}", username, age);
        return "ok";

    }

    @ResponseBody // 반환 문자열을 response body에 바로 담아버린다. 즉, @Controller임에도 viewName으로 취급x
    @RequestMapping("request-param-v3")
    public String requestParamV3(@RequestParam(required = true) String username, @RequestParam int age) {

        log.info("username = {}, age = {}", username, age);
        return "ok";

    }

    @ResponseBody
    @RequestMapping("request-param-v4")
    public String requestParamV4(String username,int age) { //@RequestParam을 생략해도 쿼리파라미터를 받아온다

        log.info("username = {}, age = {}", username, age);
        return "ok";

    }
    @ResponseBody
    @RequestMapping("request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,@RequestParam(defaultValue = "-1") int age) { //@RequestParam을 생략해도 쿼리파라미터를 받아온다

        log.info("username = {}, age = {}", username, age);
        return "ok";

    }

    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> map) { //@RequestParam을 생략해도 쿼리파라미터를 받아온다

        Object o1 = map.get("username");
        Object o2 = map.get("age");
        log.info("username = {}, age = {}", o1, o2);
        return "ok";

    }

    @ResponseBody
    @RequestMapping("model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloDataDTO helloData) { //쿼리파라미터의 변수명이 username 이면 setUserName()을 찾아서 호출하고 초기화하는 방식.

        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "ok";

    }
    @ResponseBody
    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(HelloDataDTO helloData) { //쿼리파라미터의 변수명이 username 이면 setUserName()을 찾아서 호출하고 초기화하는 방식.

        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "ok";

    }

}
