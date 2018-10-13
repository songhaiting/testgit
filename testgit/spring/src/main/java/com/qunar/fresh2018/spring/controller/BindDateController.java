package com.qunar.fresh2018.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 日期处理
 */
@Slf4j @RestController public class BindDateController {
    @RequestMapping("/binding_data.do") public String dateFormat(
            @RequestParam(value = "date", required = true) Date date) {
        System.out.println(date);
        return date.toString();

    }
}