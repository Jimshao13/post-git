package com.post.db.controller;

import com.post.db.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin//允许跨域
@RequestMapping("/package")
@Slf4j//利用@Sel4j注解，快速打印日志信息
public class OrderController {
    @Autowired
    OrderService orderService;

}
