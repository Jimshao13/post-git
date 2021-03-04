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
    public Package findByPackId(String packId) {
        return packageMapper.findByPackId(packId);
    }


    @Override
    public Package findById(String id){
        return packageMapper.findById(id);
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
    public void updateStatusPicked(Package pack) {
        packageMapper.updateStatusPicked(pack);
    }

    @Override
    public void updateStatusProblem(Package pack) {
        packageMapper.updateStatusProblem(pack);
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
