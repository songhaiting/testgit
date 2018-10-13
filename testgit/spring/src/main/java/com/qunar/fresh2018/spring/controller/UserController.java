package com.qunar.fresh2018.spring.controller;


import com.qunar.fresh2018.spring.model.User;
import com.qunar.fresh2018.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller @RequestMapping("/user") public class UserController {

    @Resource(name = "userService") private UserService userService;

    /**
     * 显示所有用户信息
     *
     * @param model
     * @return
     */

    @RequestMapping("/list") public String userList(Model model) {

        List<User> userlist = userService.getAllUsers();
        if (userlist != null) {
            model.addAttribute("users", userlist);
        }
        //return new ModelAndView("userlist");
        return "userlist";

    }

    /**
     * 显示用户信息详情
     *
     * @param id
     * @return
     */
    @RequestMapping("detail/{id}") public String userDetail(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        // return user.toString();

        return "userdetail";

    }

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}") public String delete(@PathVariable("id") int id) {

        userService.delete(id);
        return "redirect:/user/list";

    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/add") public String addUser(User user) {
        if (user.getName() == null) {
            return "addUser";
        }
        userService.addUser(user);
        return "redirect:/user/list";

    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/update") public String update(User user) {
        //System.out.println(params);
        userService.update(user);
        return "redirect:/user/list";

    }

}