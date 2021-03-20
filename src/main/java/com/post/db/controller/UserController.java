package com.post.db.controller;

import com.post.db.entity.User;
import com.post.db.service.UserService;
import com.post.db.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Api(tags="用户服务的相关接口描述")
@RestController
@CrossOrigin//允许跨域
@RequestMapping("/user")
@Slf4j//利用@Sel4j注解，快速打印日志信息
public class UserController {
    @Autowired
    private UserService userService;

    //处理用户登录
    @ApiOperation(value="用于处理用户的登陆请求",
    notes="<span style='color:red;'>描述:</span>&nbsp;用来处理用户的登陆请求")
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        log.info("当前登录的用户信息:[{}]",user.toString());

        Map<String,Object>map=new HashMap<>();

        try {
            User userDB=userService.login(user);
            map.put("status",true);
            map.put("msg","登录成功");
            map.put("user",userDB);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","提示:"+e.getMessage());
        }
        return map;
    }

    //接收前台的user:用户信息，code：验证码信息，还要拿到最大的作用域，request对象
    @PostMapping("/register")//处理用户注册
    public Map<String,Object> register(@RequestBody User user, String code, HttpServlet request){
        log.info("用户信息:[{}]",userService.toString());
        log.info("用户输入的验证码信息:[{}]",code);

        Map<String,Object> map=new HashMap<>();

        try {
            String key = (String) request.getServletContext().getAttribute("code");
            if(key.equalsIgnoreCase(code)){
                userService.register(user);
                map.put("status",true);
                map.put("msg","注册成功");
            }else{
                throw new RuntimeException("验证码错误");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","提示:"+e.getMessage());
        }
        return map;
    }


    //生成验证码图片
    @GetMapping("/getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {

        String code = VerifyCodeUtils.generateVerifyCode(4);

        request.getServletContext().setAttribute("code",code);

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();//内存输出流
        VerifyCodeUtils.outputImage(100,30,byteArrayOutputStream,code);//输出验证码，宽220
        return "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());//转为base64编码
    }



}
