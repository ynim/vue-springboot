package com.example.carbon.service.impl;

import com.example.carbon.domain.Gcjm;
import com.example.carbon.domain.Nxyj;
import com.example.carbon.domain.Processmodel;
import com.example.carbon.domain.Xmwh;
import com.example.carbon.mapper.ZhMapper;
import com.example.carbon.service.ZhInfoService;
import com.example.carbon.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ZhInfoServiceImpl implements ZhInfoService {
    @Resource
    private ZhMapper ZhMapper;

    @Override
    public int addwaring(Nxyj nxyj) {
        return ZhMapper.addwaring(nxyj);
    }

    @Override
    public int updateNxyj(Nxyj nxyj) {
        return ZhMapper.updateNxyj(nxyj);
    }

    @Override
    public int deleteNxyj(Integer id) {
        return ZhMapper.deleteNxyj(id);
    }


    public List<Nxyj> getNxyjInfoList(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        return ZhMapper.getNxyjInfoList();
    }
    @Override
    public List<Nxyj> getNxyjcz(String pointname,String pointaddress,String state, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ZhMapper.getNxyjcz(pointname,pointaddress,state);
    }

    @Override
    public List<Xmwh> getXmwhcz(String name, Date start, Date end, String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ZhMapper.getXmwhcz(name,start,end,status);
    }

    @Override
    public int insertXmwh(Xmwh xmwh) {
        return ZhMapper.insertXmwh(xmwh);
    }

    @Override
    public int updateXmwh(Xmwh xmwh) {
        return ZhMapper.updateXmwh(xmwh);
    }

    @Override
    public int deleteXmwh(Integer id) {
        return ZhMapper.deleteXmwh(id);
    }

    @Override
    public List<Gcjm> getGcjm(String scxname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ZhMapper.getGcjm(scxname);
    }

    @Override
    public int insertGcjm(Gcjm gcjm) {
        return ZhMapper.insertGcjm(gcjm);
    }

    @Override
    public int updateGcjm(Gcjm gcjm) {
        return ZhMapper.updateGcjm(gcjm);
    }

    @Override
    public int deleteGcjm(Integer id) {
        return ZhMapper.deleteGcjm(id);
    }

    @Override
    public List<Processmodel> getpr(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ZhMapper.getpr(name);
    }

    @Override
    public int insertpr(Processmodel processmodel) {
        return ZhMapper.insertpr(processmodel);
    }

    @Override
    public int updatepr(Processmodel processmodel) {
        return ZhMapper.updatepr(processmodel);
    }

    @Override
    public int deletepr(Integer id) {
        return ZhMapper.deletepr(id);
    }

}
