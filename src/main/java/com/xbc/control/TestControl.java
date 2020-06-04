package com.xbc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/testControl")
public class TestControl {
    @RequestMapping(value = "/hi")
//    @ResponseBody
    public String hi(){
//        ModelAndView ModelAndView=new ModelAndView();
//        ModelAndView.setViewName("/jsp/index");
//        ModelAndView.s
        return "ModelAndView";
    }
}
