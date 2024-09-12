package com.group.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    //ModelAndView반환
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mv = new ModelAndView("/response/hello.html");
        mv.addObject("data", "helloworld");

        return mv; //이후 FrontController가 ViewResolver 호출
    }


    //템플릿 경로 반환
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "helloworld");

        return "/response/hello";
    }

    //템플릿 주소를 안넣어도 RequestUrl을 바탕으로 자동으로 템플릿을 렌더링한다.(비추천)
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "helloworld");
    }


}
