package com.example.carbon.controller;

import com.example.carbon.domain.Inviteyg;
import com.example.carbon.service.PtdtInfoService;
import com.example.carbon.util.PageUtil;
import com.example.carbon.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/ptdt")
public class PtController {
    @Resource
    private PtdtInfoService ptdtInfoService;
    @RequestMapping("/findgg")
    public ResponseResult findivgg(){
        return ResponseResult.SUCCESS(ptdtInfoService.findInvitegg());
    }
    @RequestMapping("/findqi")
    public ResponseResult findQiyegg(){
        return ResponseResult.SUCCESS(ptdtInfoService.findQiyegg());
    }
    @RequestMapping("/findzb")
    public ResponseResult findzbgg(){
        return ResponseResult.SUCCESS(ptdtInfoService.findzbgg());
    }

    @RequestMapping("/findyg")
    public ResponseResult findInviteyg(){
        return ResponseResult.SUCCESS(ptdtInfoService.findInviteyg());
    }
    @RequestMapping("/findygall")
    public ResponseResult findInviteygall(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                                          PageUtil page){
        try{
            List<Inviteyg> inviteygs=ptdtInfoService.findInviteygall(pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(inviteygs,pageSize);
            page.setPageNum(pageNum);
            page.setList(pageInfo.getList());
            page.setTotal((int) pageInfo.getTotal());
            page.setPageSize(pageSize);
        }
       finally {
            PageHelper.clearPage();
        }
        return ResponseResult.SUCCESS(page);
    }
    @RequestMapping("/update")
    public ResponseResult updateInviteyg(@RequestParam(value = "title")String title,
                                         @RequestParam(value = "time")String time,
                                         @RequestParam(value = "id")Integer id) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        TimeZone zone = TimeZone.getTimeZone("GMT");
        format.setTimeZone(zone);
        Date timedate=format.parse(time);
        return ResponseResult.SUCCESS(ptdtInfoService.updateInviteyg(id,title,timedate));
    }
    @RequestMapping("/insert")
    public ResponseResult updateInviteyg(@RequestParam(value = "title")String title,
                                         @RequestParam(value = "time")String time
                                        ) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        TimeZone zone = TimeZone.getTimeZone("GMT");
        format.setTimeZone(zone);
        Date timedate=format.parse(time);
        return ResponseResult.SUCCESS(ptdtInfoService.insertInviteyg(title,timedate));
    }
    @RequestMapping("/delete")
    public ResponseResult updateInviteyg(@RequestParam(value = "id")Integer id) {
        return ResponseResult.SUCCESS(ptdtInfoService.deleteInviteyg(id));
    }
}
