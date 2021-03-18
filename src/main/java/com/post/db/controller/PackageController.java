package com.post.db.controller;

import com.post.db.entity.POutLog;
import com.post.db.entity.Package;
import com.post.db.service.POutLogService;
import com.post.db.service.PackageService;
import org.apache.commons.io.FilenameUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author 邵鹏泽
 * @create 2021-01-17:14
 */
@RestController
@CrossOrigin//允许跨域
@RequestMapping("/package")
@Slf4j//利用@Sel4j注解，快速打印日志信息
public class PackageController {
    @Autowired
    PackageService packageService;

    @Autowired
    POutLogService pOutLogService;

    @Value("${photo.dir}")
    private String realPath;

    //根据手机号码查询个人全部待取快递
    @GetMapping("/findByPhoneUnToken")
    public List<Package> findByPhoneUnToken(String receiverPhone){
        return packageService.findByPhoneUnToken(receiverPhone);
    }

    //根据手机号码查询个人过去三个月的已取快递
    @GetMapping("/findByPhoneToken")
    public List<Package> findByPhoneToken(String receiverPhone){
        return packageService.findByPhoneToken(receiverPhone);
    }

    /*分页查询方法*/
    @GetMapping("/findByPageByPhoneToken")
    public Map<String,Object> findByPageByPhoneToken(Integer pageNow,Integer pageSize,String receiverPhone){
        Map<String,Object> result=new HashMap<>();

        pageNow=pageNow==null?1:pageNow;
        pageSize=pageSize==null?6:pageSize;

        List<Package> packages = packageService.findByPageByPhoneToken(pageNow, pageSize,receiverPhone);
        Long totals = packageService.findTotalsByPhoneToken(receiverPhone);
        result.put("packages",packages);
        result.put("total",totals);
        return result;
    }

    //查询个人快递数据的统计
    @GetMapping("/findMyNum")
    public Map<String,Object> findMyNum(String receiverPhone){
        Integer myUnTokenNum = packageService.myUnTokenNum(receiverPhone);
        Integer myTokenNum = packageService.myTokenNum(receiverPhone);
        Integer myProblemNum = packageService.myProblemNum(receiverPhone);

        Map map=new HashMap<String,Object>();
        map.put("myUnTokenNum",myUnTokenNum);
        map.put("myTokenNum",myTokenNum);
        map.put("myProblemNum",myProblemNum);
        
        return map;

    }



    //根据快递单号查询快递
    @GetMapping("/findByPackId")
    public Package findByPackId(String packId){
        return packageService.findByPackId(packId);
    }

    //根据id查询快递
    @GetMapping("/findById")
    public Package findById(String id){
        return packageService.findById(id);
    }

    //根据packId删除快递记录
    @GetMapping("deleteByPackId")
    public Map<String,Object> deleteByPackId(String packId){
        Map<String,Object> map=new HashMap<>();
        try {
            packageService.deleteById(packId);
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
        }
        return map;
    }

    //查看驿站今日的待取件快递列表
    @GetMapping("/findUnToken")
    public List<Package> findUnToken(){
        return packageService.findUnToken();
    }

    //查看今日到目前的已取件快递
    @GetMapping("/findToken")
    public List<Package> findToken(){
        return packageService.findToken();
    }

    //查看滞留件
    @GetMapping("/findDetained")
    public List<Package> findDetained(){
        return packageService.findDetained();
    }


    //查看问题件
    @GetMapping("/findProblem")
    public List<Package> findProblem(){
        return packageService.findProblem();
    }



    //查看驿站今日的各种数量统计
    @GetMapping("/findNum")
    public Map<String,Object> findNum(){
        Integer detainedNum = packageService.detainedNum();
        Integer problemNum = packageService.problemNum();
        Integer tokenNum = packageService.tokenNum();
        Integer unTokenNum = packageService.unTokenNum();

        Map<String,Object> map=new HashMap<>();
        map.put("detainedNum",detainedNum);
        map.put("problemNum",problemNum);
        map.put("tokenNum",tokenNum);
        map.put("unTokenNum",unTokenNum);
        return map;
    }

    //出库：用户取件，添加出库记录，同时修改快递状态为已取件，
    //问题件处理
    @GetMapping("/pick")
    public Map<String,Object> pick(String packId){
        log.info("取件的快递单号为:[{}]",packId);
        Map<String,Object> map=new HashMap<>();
        try {
            packageService.updateStatusPicked(packId);
            Package pack = packageService.findByPackId(packId);
            POutLog pOutLog=new POutLog();
            pOutLog.setPackId(pack.getPackId());

            //pOutLog.setCurDate(new Timestamp(System.currentTimeMillis()));//创建当前日期时间
            pOutLog.setCurDate(new Date());
            pOutLog.setStation(pack.getStation());
            pOutLog.setLocation("1001-1");
            pOutLogService.save(pOutLog);
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
        }
        return map;
    }

    //修改快递状态为问题件
    @GetMapping("/problem")
    public Map<String,Object> updateStatusProblem(String packId){
        log.info("问题件的快递单号为:[{}]",packId);
        Map<String,Object> map=new HashMap<>();
        try {
            packageService.updateStatusProblem(packId);
            map.put("status",true);
            map.put("msg","以修改状态为问题件");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","修改状态失败，请稍后再试");
        }
        return map;
    }


    //快递入库
    @PostMapping("/save")
    public Map<String,Object> save(Package pack, MultipartFile photo) throws IOException {
        log.info("快递信息[{}]",pack.toString());
        log.info("快递图片信息:[{}]",photo.getOriginalFilename());
        Map<String,Object> map=new HashMap<>();

        try {
            //快递图像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());//修改文件名
            photo.transferTo(new File(realPath,newFileName));//按指定路径进行文件上传

            //设置快递的图像地址
            pack.setPath(newFileName);

            //保存快递信息
            packageService.save(pack);
            map.put("status",true);
            map.put("msg","快递入库成功");
        } catch (IOException e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","快递入库失败");
        }
        return map;

    }



    //错峰取件：查询当日每小时内的取件量，以图的形式展示
    //        查询昨日每小时的取件量，以图的形式展示
    @GetMapping("/hourNum")
    public Map<String,Object> hourNum(){
        Map<String,Object> map=new HashMap<>();
        List<Integer> todayHourNum = packageService.todayHourNum();
        List<Integer> yesterdayHourNum = packageService.yesterdayHourNum();

        map.put("todayHourNum",todayHourNum);
        map.put("yesterdayHourNum",yesterdayHourNum);
        return map;
    }


}
