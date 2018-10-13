package com.qunar.fresh2018.spring.controller;

import com.qunar.fresh2018.spring.model.User;
import com.qunar.fresh2018.spring.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author sht
 */
@Controller
@RequestMapping("/user")
public class HomeController {
    Logger logger = LoggerFactory.getLogger ( HomeController.class );
    @Resource
    private Service serviveImpl;

    @RequestMapping("/list")
    public ModelAndView helloMvc() {

        List<User> userList = serviveImpl.queryAll ( );
        ModelAndView mad = new ModelAndView ( "manage" );
        mad.addObject ( "users", userList );
        return mad;
    }

    @RequestMapping("/del")
    public ModelAndView delMvc(int user_id) {
        serviveImpl.deleteById ( user_id );
        List<User> userList = serviveImpl.queryAll ( );
        ModelAndView mad = new ModelAndView ( "manage" );
        mad.addObject ( "users", userList );
        return mad;
    }

    @RequestMapping("/show")
    public ModelAndView showMvc(int user_id) {
        User user = serviveImpl.queryByID ( user_id );
        ModelAndView mad = new ModelAndView ( "details" );
        mad.addObject ( "u", user );
        return mad;
    }

    @RequestMapping(value = "/modify", method = {RequestMethod.POST})
    public ModelAndView modifyMvc(@Validated User user, BindingResult result, final RedirectAttributes redirectAttributes) {
        //用户的参数校验
        if (!result.hasErrors ( )) {
            serviveImpl.updateUser ( user );
            List<User> userList = serviveImpl.queryAll ( );
            ModelAndView mad = new ModelAndView ( "/manage" );
            mad.addObject ( "users", userList );
            return mad;
        } else {
            logger.info ( "用户输入的更新信息不完整或没有输入！" );
            redirectAttributes.addAttribute ( "message", "请严格输入用户的信息 " );
            return new ModelAndView ( "redirect:/modify.jsp" );
        }
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public ModelAndView addMvc(@Validated User user, BindingResult result, final RedirectAttributes redirectAttributes) {
        //用户的参数校验
        if (!result.hasErrors ( )) {
            serviveImpl.addUser ( user );
            List<User> userList = serviveImpl.queryAll ( );
            ModelAndView mad = new ModelAndView ( "/manage" );
            mad.addObject ( "users", userList );
            return mad;
        } else {
            logger.info ( "用户输入的信息不完整或没有输入！" );
            redirectAttributes.addAttribute ( "message", "请严格输入新增用户的信息 " );
            return new ModelAndView ( "redirect:/add_user.jsp" );
        }
    }
}
