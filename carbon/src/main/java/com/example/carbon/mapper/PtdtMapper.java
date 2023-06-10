package com.example.carbon.mapper;

import com.example.carbon.domain.Invitegg;
import com.example.carbon.domain.Inviteyg;
import com.example.carbon.domain.Qiyegg;
import com.example.carbon.domain.Zhongbgg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface PtdtMapper {
    @Select("select * from invitegg order by time desc limit 5")
    public List<Invitegg> findInvitegg();
    @Select("select * from qiyegg order by time desc limit 5")
    public List<Qiyegg> findQiyegg();
    @Select("select * from zhongbgg order by time desc limit 5")
    public List<Zhongbgg> findzbgg();

    @Select("select * from inviteyg order by time desc limit 5")
    public List<Inviteyg> findInviteyg();
    @Select("select * from inviteyg order by time desc")
    public List<Inviteyg> findInviteygall();

    @Update("update inviteyg set title=#{title},time=#{time} where id=#{id}")
    public int updateInviteyg(Integer id,String title, Date time);
    @Insert("insert into inviteyg(title,time) values(#{title},#{time})")
    public int insertInviteyg(String title, Date time);
    @Delete("delete from inviteyg where id=#{id}")
    public int deleteInviteyg(Integer id);
}

