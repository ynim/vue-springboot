package com.example.carbon.service.impl;

import com.example.carbon.domain.Invitegg;
import com.example.carbon.domain.Inviteyg;
import com.example.carbon.domain.Qiyegg;
import com.example.carbon.domain.Zhongbgg;
import com.example.carbon.mapper.PtdtMapper;
import com.example.carbon.service.PtdtInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class PtdtInfoServiceImpl implements PtdtInfoService {

    @Resource
    private PtdtMapper ptdtMapper;

    @Override
    public List<Invitegg> findInvitegg() {
        return ptdtMapper.findInvitegg();
    }

    @Override
    public List<Inviteyg> findInviteyg() {
        return ptdtMapper.findInviteyg();
    }

    @Override
    public List<Inviteyg> findInviteygall(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        return  ptdtMapper.findInviteygall();
    }

    @Override
    public List<Qiyegg> findQiyegg() {
        return ptdtMapper.findQiyegg();
    }

    @Override
    public List<Zhongbgg> findzbgg() {
        return ptdtMapper.findzbgg();
    }

    @Override
    public int updateInviteyg(Integer id,String title, Date time) {
        return ptdtMapper.updateInviteyg(id,title,time);
    }

    @Override
    public int insertInviteyg(String title, Date time) {
        return ptdtMapper.insertInviteyg(title,time);
    }

    @Override
    public int deleteInviteyg(Integer id) {
        return ptdtMapper.deleteInviteyg(id);
    }


}
