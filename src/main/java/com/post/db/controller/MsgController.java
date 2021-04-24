package com.post.db.controller;

import com.post.db.entity.Package;
import com.post.db.service.PackageService;
import com.post.db.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    PackageService packageService;

    //对特定id快递发送取件码
    @GetMapping("/informById")
    public void sendPackId(String id){
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        String appcode = "e1368b4ac5ce43c6bf13d7ede7ca205a";//AppCode
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        Package pack = packageService.findById(id);

        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", pack.getReceiverPhone());
        querys.put("param", "code:"+pack.getPickUpCode());

        //querys.put("param", "code:1234");

        //querys.put("param", "这里填写你和商家定义的变量名称和变量值填写格式看上一行代码");
        querys.put("tpl_id", "TP2102014");//这里填写你和商家商议的模板
        Map<String, String> bodys = new HashMap<String, String>();

        try {
//             *
//             * 重要提示如下:
//             * HttpUtils请从
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//             * 下载
//             *
//             * 相应的依赖请参照
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());

            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //对驿站所有未短信通知的快递发送短信通知,并修改相关快递短信状态为已通知
    @GetMapping("/informUninformed")
    public Map<String,Object> informUninformed(){
        List<Package> packs = packageService.findUninformed();
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        String appcode = "e1368b4ac5ce43c6bf13d7ede7ca205a";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        //querys.put("mobile", "18805196853");
        //querys.put("param", "code:1234");
        querys.put("tpl_id", "TP2102014");
        Map<String, String> bodys = new HashMap<String, String>();


        //出于实际考虑，本部分目前做一个demo,将实际的代码先注释掉
       /* for(Package pack:packs){
            querys.put("mobile",pack.getReceiverPhone());
            querys.put("param","code:"+pack.getPickUpCode());
            try {

                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
*/



            querys.put("mobile","18805196853");
            querys.put("param","code:"+"A-3");
            try {

                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            //修改未通知快递的通知状态为已通知
        packageService.updateStatusInformed();


        Map<String,Object> map=new HashMap<>();
        try {
            packageService.updateStatusInformed();
            map.put("status",true);
            map.put("msg","短信通知成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","通知失败，请稍后再试");
        }
        return map;

    }

    //对滞留件快递发送短信，提醒用户取件
    @GetMapping("/informDetained")
    public Map<String,Object> informDetained(){
        List<Package> packs = packageService.findDetained();
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        String appcode = "e1368b4ac5ce43c6bf13d7ede7ca205a";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        //querys.put("mobile", "18805196853");
        //querys.put("param", "code:1234");
        querys.put("tpl_id", "TP2102014");
        Map<String, String> bodys = new HashMap<String, String>();

        for(Package pack:packs){
            querys.put("mobile",pack.getReceiverPhone());
            querys.put("param","code:"+pack.getPickUpCode());
            try {

                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String,Object> map=new HashMap<>();
        try {
            packageService.updateStatusInformed();
            map.put("status",true);
            map.put("msg","短信提醒成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","通知失败，请稍后再试");
        }
        return map;

    }





}
