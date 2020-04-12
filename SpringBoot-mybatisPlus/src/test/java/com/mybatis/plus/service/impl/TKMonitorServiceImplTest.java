package com.mybatis.plus.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.MybatisPlusApp;
import com.mybatis.plus.entity.TKMonitor;
import com.mybatis.plus.service.TKMonitorService;
import com.mybatis.plus.utils.ExcelStyleUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = MybatisPlusApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TKMonitorServiceImplTest {

    @Autowired
    TKMonitorService tKMonitorService;

    @Test
    public void test1() throws Exception {
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
        File savefile = new File("D:/read/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/read/excel/test03.xlsx");
        workbook.write(fos);
        fos.close();
    }
}