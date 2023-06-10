package com.example.carbon.service;

import com.example.carbon.domain.Invitegg;
import com.example.carbon.domain.Inviteyg;
import com.example.carbon.domain.Qiyegg;
import com.example.carbon.domain.Zhongbgg;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface PtdtInfoService {
    public List<Invitegg> findInvitegg();
    public List<Inviteyg> findInviteyg();
    public List<Inviteyg> findInviteygall(int pageNow, int pageSize);
    public List<Qiyegg> findQiyegg();
    public List<Zhongbgg> findzbgg();
    public int updateInviteyg(Integer id,String title, Date time);
    public int insertInviteyg(String title, Date time);
    public int deleteInviteyg(Integer id);
}
