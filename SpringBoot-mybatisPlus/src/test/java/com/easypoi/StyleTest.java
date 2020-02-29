package com.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerColorImpl;
import com.mybatis.plus.dto.MsgClientDto;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/16 23:52
 * @Version 1.0
 */
public class StyleTest {

    public static void main(String[] args) throws  Exception{


        List<MsgClientDto> msgClientDtos = new ArrayList<>();

        MsgClientDto dto1 = new MsgClientDto();

        dto1.setId("1");
        dto1.setBirthday(new Date());
        dto1.setClientName("小明192");
        dto1.setClientPhone("测试192");
        dto1.setGroup("测试193");
        dto1.setRemark("18797192");

        msgClientDtos.add(dto1);


        ExportParams exportParams = new ExportParams();
//        exportParams.setStyle(StylerColorImpl.class);
        exportParams.setStyle(ExcelStyleUtil.class);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, MsgClientDto.class, msgClientDtos);
        FileOutputStream fos = new FileOutputStream("D:/read/excel.xls");
        workbook.write(fos);
        fos.close();
    }
}
