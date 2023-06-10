package com.example.carbon.controller;

import com.example.carbon.domain.Gcjm;
import com.example.carbon.service.ZhInfoService;
import com.example.carbon.util.PageUtil;
import com.example.carbon.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/duct")
public class GcController {
    @Resource
    private ZhInfoService zhInfoService;

    @RequestMapping("/pageList")
    public ResponseResult getGcjmInfoList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                                          @RequestParam(value = "scxname", defaultValue = "") String scxname,
                                          PageUtil page) {
        try {
            List<Gcjm> gcjms = zhInfoService.getGcjm(scxname, pageNum, pageSize);
            PageInfo pageInfo = new PageInfo<>(gcjms, pageSize);
            page.setList(pageInfo.getList());
            page.setPageNum(pageNum);
            page.setTotal((int) pageInfo.getTotal());
            page.setPageSize(pageInfo.getPageSize());
        }finally {
            PageHelper.clearPage();
        }

        return ResponseResult.SUCCESS(page);
    }
 @RequestMapping("insert")
    public ResponseResult insertgc(@RequestParam(value = "product")String product,
                                   @RequestParam(value = "scxname")String scxname){
        Gcjm gcjm=new Gcjm();
        gcjm.setProduct(product);
        gcjm.setScxname(scxname);
        return ResponseResult.SUCCESS(zhInfoService.insertGcjm(gcjm));
 }
    @RequestMapping("update")
    public ResponseResult updategc(@RequestParam(value = "product",defaultValue = "")String product,
                                   @RequestParam(value = "scxname",defaultValue = "")String scxname,
                                   @RequestParam(value = "id")int id){
        Gcjm gcjm=new Gcjm();
        gcjm.setProduct(product);
        gcjm.setScxname(scxname);
        gcjm.setId(id);
        return ResponseResult.SUCCESS(zhInfoService.updateGcjm(gcjm));
    }
    @DeleteMapping("delete")
    public ResponseResult removegc(Integer id) {
        return ResponseResult.SUCCESS(zhInfoService.deleteGcjm(id));
    }
}