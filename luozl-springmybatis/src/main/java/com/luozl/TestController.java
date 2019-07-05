package com.luozl;

import com.luozl.mapper1.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    private UserDao userDao;
    @RequestMapping("getUsers")
    @ResponseBody
    public   long  getUsers(){
        long list = userDao.getUserList();
        return list;
    }
}