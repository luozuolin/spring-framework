package com.luozl;


import com.alibaba.fastjson.JSON;
import com.luozl.domain.Book;
import com.luozl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/example/")
public class TestController {
    @RequestMapping("")
    @ResponseBody
    public ModelAndView sayHello1(int age, String name) {
        ModelAndView mav = new ModelAndView();
        MyBean bean = new MyBean(age, name);
        mav.addObject("myBean", bean);
        mav.setViewName("sayHello");
        System.out.println("sayHello1:"+bean.toString());
        return mav;
    }

    @RequestMapping("sayHello")
    @ResponseBody
    public ModelAndView sayHello(int age, String name) {
        ModelAndView mav = new ModelAndView();
        MyBean bean = new MyBean(age, name);
        mav.addObject("myBean", bean);
        mav.setViewName("sayHello");
        System.out.println("sayHello:"+bean.toString());
        return mav;
    }

    @Autowired
    BookService bookService;
    @RequestMapping(value = "getbook",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String book() {
       List<Book> list= bookService.getAllBooks();
        return JSON.toJSON(list).toString();
    }

}