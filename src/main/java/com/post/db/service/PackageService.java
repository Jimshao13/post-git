package com.post.db.service;

import com.post.db.entity.Package;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-01-21:59
 */
public interface PackageService {
    //入库，保存入库快递信息
    void save(Package pack);

    //根据手机号码查询个人全部待取快递
    List<Package> findByPhoneUnToken(String receiverPhone);

    //根据手机号码查询个人全部已取快递
    List<Package> findByPhoneToken(String receiverPhone);

    //分页查询
    List<Package> findByPageByPhoneToken(Integer pageNow, Integer rows,String receiverPhone);

    //分页查询待短信通知的快递
    List<Package> findUninformedByPage(Integer pageNow, Integer rows);

    //查询待短信通知的快递数量
    long uninformedTotals();

    //查询个人全部已取快递数量
    long findTotalsByPhoneToken(String receiverPhone);

    //根据手机号查询个人剩余待取件数量
    Integer myUnTokenNum(String receiverPhone);

    //根据手机号查询个人今日已取件数量
    Integer myTokenNum(String receiverPhone);

    //根据手机号查询个人问题件量
    Integer myProblemNum(String receiverPhone);

    //根据快递单号查询某个快递
    Package findByPackId(String packId);

    //根据id查询快递
    Package findById(String id);

    //根据id删除快递
    void deleteById(String id);


    //查看当天的待取件快递列表
    List<Package> findUnToken();

    //查看当天已取件的快递列表
    List<Package> findToken();

    //查看滞留件
    List<Package> findDetained();

    //查询滞留件数量
    Integer detainedNum();

    //查询今日的问题件
    List<Package> findProblem();

    //查询今日的问题件数量
    Integer problemNum();

    //查询今日未短信通知的快递
    List<Package> findUninformed();


    //查看当天的快递已取件数量
    Integer tokenNum();

    //查看当天的待取件数量
    Integer unTokenNum();

    //修改指定快递状态为已取
    void updateStatusPicked(String packId);

    //修改快递状态为问题件
    void updateStatusProblem(String packId);

    //修改快递状态为已通知
    void updateStatusInformed();

    //查询当日每小时内的取件量
    List<Integer> todayHourNum();

    //错峰取件：查询昨日每小时的取件量，以图的形式展示
    List<Integer> yesterdayHourNum();

}
