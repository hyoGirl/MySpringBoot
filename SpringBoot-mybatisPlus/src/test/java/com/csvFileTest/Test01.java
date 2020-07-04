package com.csvFileTest;

import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.easypoi.Big20;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XULEI
 * @ClassName Test01
 * @description TODO
 * @Date 2020/6/20 9:53
 * @Version 1.0
 */
public class Test01 {


    @Test
    public void utilTest()throws  Exception{
        long start=System.currentTimeMillis();
        File file = new File("D:\\read\\test\\2000util.csv");
        List<CsvTest> data=new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            CsvTest csvTest=new CsvTest();
            csvTest.setClientPhone("12345678-"+i);
            data.add(csvTest);
        }
        FileOutputStream fos = new FileOutputStream(file);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),CsvTest.class, data);
        workbook.write(fos);
        System.out.println("耗时："+(System.currentTimeMillis()-start));
    }

    @Test
    public void streamTest()throws  Exception{

        long start=System.currentTimeMillis();
        File file = new File("D:\\read\\test\\2000stream.csv");
        List<CsvTest> data=new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            CsvTest csvTest=new CsvTest();
            csvTest.setClientPhone("87654321-"+i);
            data.add(csvTest);
        }
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        int size = data.size();
        for (int i = 0; i < size; i++) {
            writer.write(data.get(i).getClientPhone());
            writer.newLine();
        }
        writer.flush();
        writer.close();
        System.out.println("耗时："+(System.currentTimeMillis()-start));


//        FileOutputStream fos = new FileOutputStream(file);
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),CsvTest.class, data);
//        workbook.write(fos);
    }

}
