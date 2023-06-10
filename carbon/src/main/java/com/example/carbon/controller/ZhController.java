package com.example.carbon.controller;

import com.example.carbon.domain.Nxyj;
import com.example.carbon.service.ZhInfoService;
import com.example.carbon.util.PageUtil;
import com.example.carbon.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/warn")
public class ZhController {
    @Resource
    private ZhInfoService zhInfoService;
    @RequestMapping("/pageList")
    public ResponseResult getNxyjInfoList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                                          PageUtil page){
        try{
            List<Nxyj> nxyj=zhInfoService.getNxyjInfoList(pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(nxyj,pageSize);
            page.setPageNum(pageNum);
            page.setList(pageInfo.getList());
            page.setTotal((int) pageInfo.getTotal());
            page.setPageSize(pageSize);
        }finally {
            PageHelper.clearPage();
        }
        return ResponseResult.SUCCESS(page);
  }
    @RequestMapping("/selectlike")
    public ResponseResult getNxyjcz(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                                    @RequestParam(value = "pointname",defaultValue = "") String pointname,
                                    @RequestParam(value = "pointaddress",defaultValue = "") String pointaddress,
                                    @RequestParam(value = "state",defaultValue = "")String state, PageUtil page){
        try{

            List<Nxyj> nxyj=zhInfoService.getNxyjcz(pointname,pointaddress,state,pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(nxyj,pageSize);
            page.setPageNum(pageNum);
            page.setList(pageInfo.getList());
            page.setTotal((int) pageInfo.getTotal());
            page.setPageSize(pageSize);
        }finally {
            PageHelper.clearPage();
        }
        return ResponseResult.SUCCESS(page);

    }


    @PostMapping("/update")
    public ResponseResult update(Nxyj nxyj) {
        nxyj.setReportingtime(new Date());
        return  ResponseResult.SUCCESS(zhInfoService.updateNxyj(nxyj));
    }
    @DeleteMapping("/remove")
    public ResponseResult remove(Integer id) {
        return ResponseResult.SUCCESS(zhInfoService.deleteNxyj(id));
    }
    @PostMapping("/addwarning")
    public ResponseResult addwarning( Nxyj nxyj) {
        nxyj.setReportingtime(new Date());
        System.out.println(nxyj);
        return ResponseResult.SUCCESS(zhInfoService.addwaring(nxyj));
    }

}
