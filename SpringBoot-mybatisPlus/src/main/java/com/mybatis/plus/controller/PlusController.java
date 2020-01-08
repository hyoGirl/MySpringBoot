package com.mybatis.plus.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.dto.PlusDto;
import com.mybatis.plus.entity.Plus;
import com.mybatis.plus.service.PlusService;
import com.mybatis.plus.utils.ExcelUtil;
import com.mybatis.plus.utils.PageInfoTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PlusController {

    @Autowired
    private PlusService plusService;


    @PostMapping("/add")
    public void add(@RequestBody Plus plus) {

        plusService.insertPlus(plus);
    }

    @PostMapping("/del")
    public void del(@RequestParam("id") int id) {
        plusService.deletePlus(id);
    }


    /**
     * 测试获取一个
     */

    @GetMapping("/get/{id}")
    public Plus getOne(@PathVariable("id") int id) {

        return plusService.getPlus(id);
    }


    /**
     * 测试分页
     */
    @GetMapping("/page")
    public PageInfoTable<Plus> page(@RequestParam(defaultValue = "1") Integer pageNumber,
                                    @RequestParam(defaultValue = "6") Integer pageSize) {
        Page<Plus> page = new Page<Plus>(pageNumber, pageSize);
        Page<Plus> result = plusService.findAllPlusPage(page);
        PageInfoTable<Plus> pageTable = new PageInfoTable<Plus>();
        pageTable.setRows(result.getRecords());
        pageTable.setTotal(result.getSize());
        return pageTable;
    }

    @GetMapping("/download")
    public void down(HttpServletResponse response) {
        log.info("{}","测试日志");

        List<PlusDto> list = new ArrayList<>();

//		ExportParams exportParams = new ExportParams("模板数据", "学生001");
        ExportParams exportParams = new ExportParams();
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
                PlusDto.class, list);
        String fileName = "test-" + LocalDate.now() ;
        ExcelUtil.dowload(fileName,response,workbook);
    }


}
