package com.group.springmvc.basic.response;

import com.group.springmvc.basic.HelloDataDTO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@Controller
@Slf4j
public class ResponseBodyController {

    //HttpServletResponse사용
    @GetMapping("/response-body-string-v1")
    public void responseBodyStringV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    //ResponseEntity사용
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyStringV2() {
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    //@ResponseBody
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyStringV3() {
        return "ok";
    }

    //json담아서 response보내기-------------------------------------

    //return ResponseEntity<>()
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloDataDTO> responseBodyJsonV1() {
        HelloDataDTO helloDataDTO = new HelloDataDTO("olaf", 21);
        return new ResponseEntity<>(helloDataDTO, HttpStatus.OK);
    }

    //@ResponseBody & @ResponseStatus
    @GetMapping("/response-body-json-v2")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public HelloDataDTO responseBodyV1() {
        HelloDataDTO helloDataDTO = new HelloDataDTO("olaf", 21);

        return helloDataDTO;
    }
}
