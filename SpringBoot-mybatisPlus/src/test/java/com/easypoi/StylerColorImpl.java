package com.easypoi;

import cn.afterturn.easypoi.excel.export.styler.AbstractExcelExportStyler;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.ss.usermodel.*;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/16 23:56
 * @Version 1.0  IExcelExportStyler
 */
public class StylerColorImpl extends AbstractExcelExportStyler
        implements IExcelExportStyler {


    public StylerColorImpl(Workbook workbook) {
        super.createStyles(workbook);
    }
    @Override
    public CellStyle getHeaderStyle(short headerColor) {
        CellStyle titleStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 24);
        titleStyle.setFont(font);

//        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

//        titleStyle.setFillForegroundColor(headerColor);
        titleStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return titleStyle;
    }

    @Override
    public CellStyle getTitleStyle(short color) {
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(color);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setWrapText(true);
        return titleStyle;
    }
}
