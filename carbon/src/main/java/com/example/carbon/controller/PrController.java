package com.example.carbon.controller;

import com.example.carbon.domain.Processmodel;
import com.example.carbon.service.ZhInfoService;
import com.example.carbon.util.PageUtil;
import com.example.carbon.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("cess")
public class PrController {
    @Resource
    private ZhInfoService zhInfoService;
    @RequestMapping("/pageList")
    public ResponseResult getpr(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                                @RequestParam(value = "name",defaultValue = "")String name,
                                PageUtil page)throws ParseException {
        try {
        List<Processmodel> processmodel=zhInfoService.getpr(name,pageNum,pageSize);
        PageInfo pageInfo=new PageInfo<>(processmodel,pageSize);
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
    public ResponseResult insertpr(@RequestParam(value = "name",defaultValue = "")String name,
                                   @RequestParam(value = "product",defaultValue = "")String product,
                                   @RequestParam(value = "prow",defaultValue = "")Integer prow,
                                   @RequestParam(value = "notes",defaultValue = "")String notes,
                                   @RequestParam(value = "description",defaultValue = "")String description){
        Processmodel processmodel=new Processmodel();
        processmodel.setDescription(description);
        processmodel.setName(name);
        processmodel.setProduct(product);
        processmodel.setProw(prow);
        processmodel.setNotes(notes);
        return ResponseResult.SUCCESS(zhInfoService.insertpr(processmodel));
    }
    @RequestMapping("update")
    public ResponseResult updatepr(
            @RequestParam(value = "id",defaultValue = "")Integer id,
            @RequestParam(value = "name",defaultValue = "")String name,
                                   @RequestParam(value = "product",defaultValue = "")String product,
                                   @RequestParam(value = "prow",defaultValue = "")Integer prow,
                                   @RequestParam(value = "notes",defaultValue = "",required = false)String notes,
                                   @RequestParam(value = "description",defaultValue = "",required = false)String description){
        Processmodel processmodel=new Processmodel();
        processmodel.setDescription(description);
        processmodel.setName(name);
        processmodel.setProduct(product);
        processmodel.setProw(prow);
        processmodel.setNotes(notes);
        processmodel.setId(id);
        return ResponseResult.SUCCESS(zhInfoService.updatepr(processmodel));
    }

    @DeleteMapping("/c")
    public ResponseResult remove(Integer id) {
        return ResponseResult.SUCCESS(zhInfoService.deletepr(id));
    }
}
