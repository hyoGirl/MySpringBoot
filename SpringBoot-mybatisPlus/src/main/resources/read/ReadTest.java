package com.yd.tk.csv;

import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.csv.entity.CsvImportParams;
import cn.afterturn.easypoi.csv.imports.CsvImportService;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.yd.tk.modular.dto.PickDelvDetailDto;

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



//        ImportParams params = new ImportParams();
//        params.setTitleRows(0);
//        params.setHeadRows(0);
//        List<ReadDto> objects = ExcelImportUtil.importExcel(file, ReadDto.class, params);


//        CsvImportUtil.importCsv(InputStream inputstream, Class<?> pojoClass,CsvImportParams params);


//        encoding	String	UTF8	文件编码
//        spiltMark	String	,	分隔符
//        textMark	String	"	字符串识别,可以去掉,需要前后一致
//        titleRows	int	0	表格头,忽略
//        headRows	int	1	标题
//        startRows	int	0	标题起忽略行数

        File file = new File("D:\\read\\17.csv");
        CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);
        // 标题
        params.setHeadRows(0);
        // 分隔符
        params.setSpiltMark(",");
        // 表格头,忽略
        params.setTitleRows(0);
        // 标题起忽略行数
        params.setStartRows(1);
        FileInputStream stream = new FileInputStream(file);
        List<ReadDto> readDtos = CsvImportUtil.importCsv(stream, ReadDto.class, params);
//        List<Object> objects = CsvImportUtil.importCsv(stream, ReadDto.class, params);

        System.out.println(JSON.toJSONString(readDtos));
        System.out.println(readDtos.size());


//        if (StringUtils.isBlank(filePath)){
//            return null;
//        }
//        ImportParams params = new ImportParams();
//        params.setTitleRows(titleRows);
//        params.setHeadRows(headerRows);
//        List<T> list = null;
//        try {
//            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
//        }catch (NoSuchElementException e){
//            throw new NormalException("模板不能为空");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new NormalException(e.getMessage());
//        }

    }
}
