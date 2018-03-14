package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nikikiy
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String showPages(@PathVariable  String page){
        System.out.println(page);
        return page;
    }
}
