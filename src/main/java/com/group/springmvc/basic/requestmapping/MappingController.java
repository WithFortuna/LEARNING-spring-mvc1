package com.group.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(MappingController.class);

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");

        return "ok";
    }

    @PutMapping("hello-put")
    public String helloPut() {
        return "ok";
    }

    @RequestMapping("/members/{memberId}")
    public String save(@PathVariable String memberId) {
        log.info("save함수호출 id는 {} ", memberId);
        return "ok";
    }

    @RequestMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mapping-param호출==============");
        return "Ok";
    }

    @RequestMapping(value = "mapping-header", headers = "mode") //HttpRequest헤더에 mode라는 키가 있어야함
    public String mappingHeader() {
        return "ok";

    }

    @RequestMapping(value = "mapping-contentType", consumes = "text/plain")
    public String mappingContentType() {
        return "ok";
    }

    @RequestMapping(value = "mapping-accept", produces = "text/html")
    public String mappingAccept() {
        return "ok";
    }
}
