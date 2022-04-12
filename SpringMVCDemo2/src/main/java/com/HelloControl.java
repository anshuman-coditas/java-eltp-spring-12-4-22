package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControl {
    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","Hi AK");
        return modelAndView;
    }


}
