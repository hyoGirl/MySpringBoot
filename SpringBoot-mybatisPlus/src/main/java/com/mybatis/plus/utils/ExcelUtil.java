package com.mybatis.plus.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.mybatis.plus.dto.PlusDto;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/2 23:02
 * @Version 1.0
 */
public class ExcelUtil {

    public static void dowload(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xls", "UTF-8"));
            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dowloadWorkbook(Workbook workbook, String fileName,HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")+".xls");
            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dowloadBigbook(Workbook workbook, String fileName,HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")+".xlsx");
            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void creatExcel(String filePth, ExportParams exportParams, Class obj, List<T> allList)throws Exception{

        String finalPath = filePth + "result_" + LocalDate.now() + ".xls";
        FileOutputStream fos = new FileOutputStream(finalPath);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, obj, allList);
        workbook.write(fos);


    }


}
