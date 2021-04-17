package com.post.db.service;
import com.post.db.entity.Package;
import com.post.db.mapper.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-01-21:59
 */
@Service
public class PackageServiceImpl implements PackageService{
    @Autowired
    PackageMapper packageMapper;

    @Override
    public void save(Package pack) {
        packageMapper.save(pack);
    }

    @Override
    public List<Package> findByPhoneUnToken(String receiverPhone) {
        return packageMapper.findByPhoneUnToken(receiverPhone);
    }

    @Override
    public List<Package> findByPhoneToken(String receiverPhone) {
        return packageMapper.findByPhoneToken(receiverPhone);
    }

    @Override
    public List<Package> findByPageByPhoneToken(Integer pageNow, Integer rows,String receiverPhone) {
        int start=(pageNow-1)*rows;//由当前页及每页的条数，得到当前查询的起始条数位置
        return packageMapper.findByPageByPhoneToken(start,rows,receiverPhone);
    }

    @Override
    public List<Package> findUninformedByPage(Integer pageNow, Integer rows) {
        int start=(pageNow-1)*rows;//由当前页及每页的条数，得到当前查询的起始条数位置
        return packageMapper.findUninformedByPage(start,rows);
    }

    @Override
    public long uninformedTotals() {
        return packageMapper.uninformedTotals();
    }


    @Override
    public long findTotalsByPhoneToken(String receiverPhone) {
        return packageMapper.findTotalsByPhoneToken(receiverPhone);
    }

    @Override
    public Integer myUnTokenNum(String receiverPhone) {
        return packageMapper.myUnTokenNum(receiverPhone);
    }

    @Override
    public Integer myTokenNum(String receiverPhone) {
        return packageMapper.myTokenNum(receiverPhone);
    }

    @Override
    public Integer myProblemNum(String receiverPhone) {
        return packageMapper.myProblemNum(receiverPhone);
    }

    @Override
    public Package findByPackId(String packId) {
        return packageMapper.findByPackId(packId);
    }


    @Override
    public Package findById(String id){
        return packageMapper.findById(id);
    }

    @Override
    public void deleteById(String packId) {
        packageMapper.deleteByPackId(packId);
    }

    @Override
    public List<Package> findUnToken() {
        return packageMapper.findUnToken();
    }

    @Override
    public List<Package> findToken() {
        return packageMapper.findToken();
    }

    @Override
    public List<Package> findDetained() {
        return packageMapper.findDetained();
    }

    @Override
    public Integer detainedNum(){
        return packageMapper.detainedNum();
    }

    @Override
    public List<Package> findProblem() {
        return packageMapper.findProblem();
    }

    @Override
    public Integer problemNum() {
        return packageMapper.problemNum();
    }

    @Override
    public List<Package> findUninformed() {
        return packageMapper.findUninformed();
    }


    @Override
    public Integer tokenNum() {
        return packageMapper.tokenNum();
    }

    @Override
    public Integer unTokenNum() {
        return packageMapper.unTokenNum();
    }

    @Override
    public void updateStatusPicked(String packId) {
        packageMapper.updateStatusPicked(packId);
    }

    @Override
    public void updateStatusProblem(String packId) {
        packageMapper.updateStatusProblem(packId);
    }

    @Override
    public void updateStatusInformed() {
        packageMapper.updateStatusInformed();
    }

    @Override
    public List<Integer> todayHourNum() {
        return packageMapper.todayHourNum();
    }

    @Override
    public List<Integer> yesterdayHourNum() {
        return packageMapper.yesterdayHourNum();
    }
}
