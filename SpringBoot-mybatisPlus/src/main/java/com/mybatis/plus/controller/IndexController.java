package com.mybatis.plus.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerColorImpl;
import com.mybatis.plus.dto.MsgClientDto;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/25 21:56
 * @Version 1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String test1(){

        return "index";
    }





}
