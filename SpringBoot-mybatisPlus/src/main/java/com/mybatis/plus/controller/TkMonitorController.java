package com.mybatis.plus.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.entity.TKMonitor;
import com.mybatis.plus.service.TKMonitorService;
import com.mybatis.plus.utils.ExcelStyleUtil;
import com.mybatis.plus.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author XULEI
 * @ClassName TkMonitorController
 * @description TODO
 * @Date 2020/4/11 15:07
 * @Version 1.0
 */
@Slf4j
@RestController
public class TkMonitorController {


    @Autowired
    TKMonitorService tKMonitorService;

    @GetMapping("/big")
    public void  downLoadxcel(HttpServletResponse response)throws  Exception{


        Date start = new Date();
        ExportParams params = new ExportParams("大数据测试", "测试");
        params.setStyle(ExcelStyleUtil.class);
        params.setMaxNum(10*10000);
        Workbook workbook = ExcelExportUtil.exportBigExcel(params, TKMonitor.class, new IExcelExportServer() {
            @Override
            public List<Object> selectListForExcelExport(Object queryParams, int page) {
                Page<TKMonitor> pageInfo = new Page(page, 50000);
                IPage iPage = tKMonitorService.page(pageInfo, null);
                List records = iPage.getRecords();
                return records;
            }
        }, 1);
        System.out.println(new Date().getTime() - start.getTime());
//        File savefile = new File("D:/read/excel/");
//        if (!savefile.exists()) {
//            savefile.mkdirs();
//        }
//        FileOutputStream fos = new FileOutputStream("D:/read/excel/test03.xlsx");
//        workbook.write(fos);
//        fos.close();

        String name="wq01.";
        ExcelUtil.dowloadBigbook(workbook,name,response);

    }

}
