package com.easypoi;

import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.csv.entity.CsvImportParams;
import cn.afterturn.easypoi.handler.inter.IReadHandler;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/16 22:56
 * @Version 1.0
 */
public class CsvDataRead {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvDataRead.class);







    @Test
    public void test() {

        File file = new File("D:\\read\\big.csv");
        try {
            Date start = new Date();
            LOGGER.debug("start");
            CsvImportParams params = new CsvImportParams(CsvImportParams.GBK);
            params.setTitleRows(1);
//            CsvImportUtil.importCsv(new FileInputStream(
//                            file),
//                    MsgClient.class, params, new IReadHandler() {
//                        @Override
//                        public void handler(Object o) {
//
//                        }
//
//                        @Override
//                        public void doAfterAll() {
//
//                        }
//                    });
            List<MsgClient> msgClients = CsvImportUtil.importCsv(new FileInputStream(file), MsgClient.class, params);

            System.out.println(JSON.toJSONString(msgClients));
            System.out.println(msgClients.size());

            LOGGER.debug("end,time is {}", ((new Date().getTime() - start.getTime()) / 1000));
        } catch (Exception e) {
        }
    }


    @Test
    public void testUtf8Bom() {

        File file = new File("D:\\read\\2018.csv");
        try {
            Date start = new Date();
            LOGGER.debug("start");
            CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);
//            CsvImportUtil.importCsv(new FileInputStream(file),
//                    Map.class, params, new IReadHandler<Map>() {
//                        @Override
//                        public void handler(Map o) {
//
//                        }
//
//                        @Override
//                        public void doAfterAll() {
//
//                        }
//                    });
            List<Object> objects = CsvImportUtil.importCsv(new FileInputStream(file),
                    Map.class, params);
            System.out.println(JSON.toJSONString(objects));
            System.out.println(objects.size());
            LOGGER.debug("end,time is {}", ((new Date().getTime() - start.getTime()) / 1000));
        } catch (Exception e) {
        }
    }



    @Test
    public void test3() {

        File file = new File("D:\\read\\big20.csv");
        try {
            Date start = new Date();
            LOGGER.debug("start");
            CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);

            List<Object> objects = CsvImportUtil.importCsv(new FileInputStream(file),
                    Big20.class, params);
            System.out.println(JSON.toJSONString(objects));
            System.out.println(objects.size());
            LOGGER.debug("end,time is {}", ((new Date().getTime() - start.getTime()) / 1000));
        } catch (Exception e) {
        }
    }

    @Test
    public void test4() {

        File file = new File("D:\\read\\18.csv");
        try {
            Date start = new Date();
            LOGGER.debug("start");
            CsvImportParams params = new CsvImportParams(CsvImportParams.UTF8);
//            titleRows	int	0	表格头,忽略
//            params.setTitleRows(-1);
//            headRows	int	1	标题
            params.setHeadRows(0);
            List<Object> objects = CsvImportUtil.importCsv(new FileInputStream(file),
                    ReadDto.class, params);
//            System.out.println(JSON.toJSONString(objects));
            System.out.println(objects.size());
            LOGGER.debug("end,time is {}", ((new Date().getTime() - start.getTime()) / 1000));
        } catch (Exception e) {
        }
    }
}
