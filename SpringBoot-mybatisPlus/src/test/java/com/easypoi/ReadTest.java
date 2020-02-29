package com.easypoi;

import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.csv.entity.CsvImportParams;
import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * author:徐磊
 * Date:2020/1/16
 * Time:19:08
 */
public class ReadTest {


    public static void main(String[] args) throws  Exception{

//        ‪D:\read\01.csv


        File file = new File("D:\\read\\18.csv");
        CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);
//        // 标题
//        params.setHeadRows(0);
//        // 分隔符
//        params.setSpiltMark(",");
//        // 表格头,忽略
//        params.setTitleRows(0);
//        // 标题起忽略行数
//        params.setStartRows(0);
        FileInputStream stream = new FileInputStream(file);
        List<ReadDto> readDtos = CsvImportUtil.importCsv(stream, ReadDto.class, params);
        System.out.println(JSON.toJSONString(readDtos));
        System.out.println(readDtos.size());
    }
}
