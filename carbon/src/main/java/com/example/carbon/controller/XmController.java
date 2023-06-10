package com.example.carbon.controller;


import com.example.carbon.domain.Xmwh;
import com.example.carbon.service.ZhInfoService;
import com.example.carbon.util.FileUtil;
import com.example.carbon.util.PageUtil;
import com.example.carbon.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/ject")
public class XmController {
    @Resource
    private ZhInfoService zhInfoService;
    @Value("${web.upload-path}")
    private String path;
    @Value("${web.image-path}")
    private String imagePath;
    @RequestMapping("/pageList")
    public ResponseResult getXmwhcz(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                                    @RequestParam(value = "name",defaultValue = "") String name,
                                    @RequestParam(value = "start",defaultValue = "1923-01-01") String start,
                                    @RequestParam(value = "end",defaultValue = "9999-12-31") String end,
                                    @RequestParam(value = "status",defaultValue = "")String status, PageUtil page){
        try{
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            TimeZone zone = TimeZone.getTimeZone("GMT");
            format.setTimeZone(zone);
            Date start0=format.parse(start);
            format.setTimeZone(zone);
            Date end0=format.parse(end);
            List<Xmwh> nxyj=zhInfoService.getXmwhcz(name,start0,end0,status,pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(nxyj,pageSize);
            page.setPageNum(pageNum);
            page.setList(pageInfo.getList());
            page.setTotal((int) pageInfo.getTotal());
            page.setPageSize(pageSize);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            PageHelper.clearPage();
        }
        return ResponseResult.SUCCESS(page);

    }
    @RequestMapping("/insert")
    public ResponseResult addXmwhc(
                                    @RequestParam(value = "name",defaultValue = "") String name,
                                    @RequestParam(value = "header",defaultValue = "")String header,
                                    @RequestParam(value = "start",defaultValue = "1923-01-01") String start,
                                    @RequestParam(value = "end",defaultValue = "9999-12-31") String end,
                                    @RequestParam(value = "status",defaultValue = "")String status,
                                    @RequestParam(value = "duction", required = false) MultipartFile duction
                                    ) throws ParseException {
        Xmwh xmwh=new Xmwh();
        if (duction != null){
            String fileName = FileUtil.upload(duction, path, duction.getOriginalFilename());
            if (fileName!=null){
                xmwh.setDuction(fileName);
            }
    }
        xmwh.setName(name);
        xmwh.setHeader(header);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        TimeZone zone = TimeZone.getTimeZone("GMT");
        format.setTimeZone(zone);
        Date start0= null;
        Date end0= null;
        try {
            start0 = format.parse(start);
            end0=format.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        xmwh.setStart(start0);
        xmwh.setEnd(end0);
        xmwh.setStatus(status);
        return ResponseResult.SUCCESS(zhInfoService.insertXmwh(xmwh));
    }


    @RequestMapping("/update")
    public ResponseResult updateXmwhc(
            @RequestParam(value = "id",defaultValue = "") int id,
            @RequestParam(value = "name",defaultValue = "") String name,
            @RequestParam(value = "header",defaultValue = "")String header,
            @RequestParam(value = "start",defaultValue = "1923-01-01") String start,
            @RequestParam(value = "end",defaultValue = "9999-12-31") String end,
            @RequestParam(value = "status",defaultValue = "")String status,
            @RequestParam(value = "duction", required = false) MultipartFile duction
    ) throws ParseException {
        Xmwh xmwh=new Xmwh();
        if (duction != null){
            String fileName = FileUtil.upload(duction, path, duction.getOriginalFilename());
            if (fileName!=null){
                xmwh.setDuction(fileName);
            }
        }
        xmwh.setName(name);
        xmwh.setHeader(header);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        TimeZone zone = TimeZone.getTimeZone("GMT");
        format.setTimeZone(zone);
        Date start0= null;
        Date end0= null;
        try {
            start0 = format.parse(start);
            end0=format.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        xmwh.setStart(start0);
        xmwh.setEnd(end0);
        xmwh.setStatus(status);
        xmwh.setId(id);
        return ResponseResult.SUCCESS(zhInfoService.updateXmwh(xmwh));
    }
    @DeleteMapping("/remove")
    public ResponseResult remove(Integer id) {
        return ResponseResult.SUCCESS(zhInfoService.deleteXmwh(id));
    }
}
