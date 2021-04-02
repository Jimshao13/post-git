package com.post.db.controller;

import com.alibaba.druid.util.StringUtils;
import com.post.db.entity.Station;
import com.post.db.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 邵鹏泽
 * @create 2021-02-21:23
 */
@RestController
@CrossOrigin//允许跨域
@RequestMapping("/station")
@Slf4j//利用@Sel4j注解，快速打印日志信息
@Api(tags="驿站查询添加相关接口")
public class StationController {
    @Autowired
    StationService stationService;

    //查询所有驿站信息
    @GetMapping("/findAll")
    public List<Station> findAll() {
        return stationService.findAll();
    }

    //分页查询方法
    @GetMapping("/findByPage")
    public Map<String, Object> findByPage(Integer pageNow, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();

        pageNow = pageNow == null ? 1 : pageNow;
        pageSize = pageSize == null ? 6 : pageSize;

        List<Station> stations = stationService.findByPage(pageNow, pageSize);
        Long totals = stationService.findTotals();
        result.put("total", totals);
        result.put("stations", stations);

        return result;
    }

    //添加驿站或修改驿站信息
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody Station station){
        Map<String, Object> map = new HashMap<>();
        try {
            if (StringUtils.isEmpty(station.getId())) {
                stationService.save(station);
                map.put("msg", "驿站信息保存成功");
                map.put("status", true);
            } else {
                stationService.update(station);
                map.put("msg", "驿站信息修改成功");
                map.put("status", true);
            }
        }catch(Exception e){
                map.put("status",false);
                map.put("msg","系统错误，保存驿站信息失败，请稍后再试");
        }
        return map;

    }


    @GetMapping("/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="驿站id",dataType = "String",defaultValue = "1")
    })
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            stationService.delete(id);
            map.put("status", true);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
            map.put("msg", "删除失败");
        }
        return map;
    }

}
