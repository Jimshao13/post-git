package com.post.db.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.post.db.entity.Package;
import com.post.db.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 邵鹏泽
 * @create 2021-01-22:03
 */
@SpringBootTest
class PackageServiceTest {
    @Autowired
    PackageService packageService;

    //用户或管理人员可以根据电话查询未取件
    @Test
    void findByPhoneUnToken() {
        List<Package> packages = packageService.findByPhoneUnToken("18805196853");
        System.out.println(packages);
    }

    //用户或管理人员可以根据电话查询用户过去三个月已取件
    @Test
    void findByPhoneToken() {
        List<Package> packages = packageService.findByPhoneToken("18805196853");
        System.out.println(packages);
    }

    //用户或管理人员可以根据快递单号查询快递
    @Test
    void findByPackId() {
        Package pack= packageService.findByPackId("122228992");
        System.out.println(pack);
    }

    //根据快递id查询快递，仅供项目内部使用
    @Test
    void findById(){
        Package pack = packageService.findById("1");
        System.out.println(pack);
    }

    //管理人员查询今日的待取件快递
    @Test
    void findUnToken() {
        List<Package> unToken = packageService.findUnToken();
        System.out.println(unToken);
    }

    //管理人员查询驿站今日截止到目前的已取件快递列表
    @Test
    void findToken() {
        List<Package> token = packageService.findToken();
        System.out.println(token);
    }

    //管理人员查询滞留件信息（快递入站时间超过24h仍为被取件的快递）
    @Test
    void findDetained(){
        List<Package> detained = packageService.findDetained();
        System.out.println(detained);
    }

    //管理人员查询问题件信息列表
    @Test
    void findProblem(){
        List<Package> problem = packageService.findProblem();
        System.out.println(problem);
    }

    //管理人员查询驿站目前问题件数量
    @Test
    void findNum(){
        Integer num = packageService.problemNum();
        System.out.println(num);
    }

    //驿站管理人员查询今日截止到目前的已取件快递数量
    @Test
    void tokenNum(){
        Integer tokenNum = packageService.tokenNum();
        System.out.println(tokenNum);
    }

    //查询快递入库时间在24小时内的待取件数量
    @Test
    void unTokenNum() {
        Integer unTokenNum = packageService.unTokenNum();
        System.out.println(unTokenNum);
    }


    //修改快递状态为已取件
    @Test
    void updateStatus() {
        Package pack= packageService.findByPackId("12229929");
        packageService.updateStatusPicked(pack);
    }


    //修改入库24小时内的未通知的待取件的快递短信状态为已通知
    @Test
    void informed(){
        packageService.updateStatusInformed();
    }

    //测试错峰取件功能:查询今日每小时的取件量
    @Test
    void todayHourNum(){
        List<Integer> list = packageService.todayHourNum();
        System.out.println(list);
    }


    //测试错峰取件：查询昨日每小时的取件量
    @Test
    void yesterdayHourNum(){
        List<Integer> list = packageService.yesterdayHourNum();
        System.out.println(list);
    }


    @Test
    void test(){

        Date d=new Date();
        System.out.println(d);
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }

}