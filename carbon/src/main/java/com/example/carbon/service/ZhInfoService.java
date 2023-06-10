package com.example.carbon.service;

import com.example.carbon.domain.Gcjm;
import com.example.carbon.domain.Nxyj;
import com.example.carbon.domain.Processmodel;
import com.example.carbon.domain.Xmwh;
import com.example.carbon.util.ResponseResult;

import java.util.Date;
import java.util.List;


public interface ZhInfoService {

    public int addwaring(Nxyj nxyj);
    public int updateNxyj(Nxyj nxyj);
    public int deleteNxyj(Integer id);

    public List<Nxyj> getNxyjInfoList(int pageNow, int pageSize);

    public List<Nxyj> getNxyjcz(String pointname,String pointaddress,String state,int pageNum,int pageSize);
    public List<Xmwh> getXmwhcz(String name, Date start, Date end, String status,int pageNum,int pageSize);
    public int insertXmwh(Xmwh xmwh);
    public int updateXmwh(Xmwh xmwh);
    public int deleteXmwh(Integer id);

    public List<Gcjm> getGcjm(String scxname,int pageNum,int pageSize);
    public int insertGcjm(Gcjm gcjm);
    public int updateGcjm(Gcjm gcjm);
    public int deleteGcjm(Integer id);
    public List<Processmodel> getpr(String name,int pageNum,int pageSize );
    public int insertpr(Processmodel processmodel);
    public int updatepr(Processmodel processmodel);
    public int deletepr(Integer id);
}
