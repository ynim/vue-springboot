package com.example.carbon.mapper;

import com.example.carbon.domain.Gcjm;
import com.example.carbon.domain.Nxyj;
import com.example.carbon.domain.Processmodel;
import com.example.carbon.domain.Xmwh;
import com.example.carbon.util.ResponseResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ZhMapper {
    public List<Nxyj> getNxyjInfoList();

    public int updateNxyj(Nxyj nxyj);
    public int deleteNxyj(Integer id);
    public int addwaring(Nxyj nxyj);
    public List<Nxyj> getNxyjcz(String pointname,String pointaddress,String state);
    public List<Xmwh> getXmwhcz(String name,Date start,Date end,String status);
    public int insertXmwh(Xmwh xmwh);
    public int  updateXmwh(Xmwh xmwh);
    public int deleteXmwh(Integer id);
    public List<Gcjm> getGcjm(String scxname);
    public int insertGcjm(Gcjm gcjm);
    public int updateGcjm(Gcjm gcjm);
    public int deleteGcjm(Integer id);

    public List<Processmodel> getpr(String name);
    public int insertpr(Processmodel processmodel);
    public int updatepr(Processmodel processmodel);
    public int deletepr(Integer id);
}

