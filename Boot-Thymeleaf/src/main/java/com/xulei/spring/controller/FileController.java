package com.xulei.spring.controller;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author XULEI
 * @ClassName FileController
 * @description TODO
 * @Date 2020/7/4 9:41
 * @Version 1.0
 */
@Controller
public class FileController {

    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    // 跳转上传页面
    @GetMapping("test")
    public String test() {
        return "pages/file";
    }

    // 跳转上传页面
    @GetMapping("test2")
    public String test2() {
        return "pages/file2";
    }



    // 执行上传
    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {

        String property = System.getProperty("user.dir");

        property=property+File.separator;

        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
//        String path = filePath+"rotPhoto/";   // F://images/
        String path = property+"rotPhoto/";
        // 新建文件
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将src路径发送至html页面
        model.addAttribute("filename", "/images/rotPhoto/"+filename);
//        model.addAttribute("filename", path+"/"+filename);
        return "pages/file";
    }


    @GetMapping("stream")
    public void getStreamData(HttpServletResponse response) {
        File file=new File("F:\\ideaspace\\MySpringBoot\\rotPhoto\\打卡.jpg");
        ServletOutputStream out=null;
        try {
            FileInputStream instream=new FileInputStream(file);
            byte[] b=new byte[1024];
            int length=0;
            BufferedInputStream buf=new BufferedInputStream(instream);
            out=response.getOutputStream();
            BufferedOutputStream bot=new BufferedOutputStream(out);
            while((length=buf.read(b))!=-1) {
                bot.write(b,0, b.length);
            }
        } catch (Exception  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @GetMapping("/excel")
    public void toHtmlOf07Base(HttpServletResponse response) throws Exception {
        String name="F:\\ideaspace\\MySpringBoot\\rotPhoto\\tk_prescription_copy1.xls";
//        ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(POICacheManager.getFile("exceltohtml/testExportTitleExcel.xlsx")));
        ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(POICacheManager.getFile(name)));
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());




//        File file=new File("F:\\ideaspace\\MySpringBoot\\rotPhoto\\打卡.jpg");
//        File file=new File(name);
//        ServletOutputStream out=null;
//        try {
//            FileInputStream instream=new FileInputStream(file);
//            byte[] b=new byte[1024];
//            int length=0;
//            BufferedInputStream buf=new BufferedInputStream(instream);
//            out=response.getOutputStream();
//            BufferedOutputStream bot=new BufferedOutputStream(out);
//            while((length=buf.read(b))!=-1) {
//                bot.write(b,0, b.length);
//            }
//        } catch (Exception  e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}
