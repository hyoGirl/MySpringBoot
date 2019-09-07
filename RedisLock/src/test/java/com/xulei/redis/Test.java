package com.xulei.redis;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/17 0:28
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
       final ConfigService configService=new ConfigService();
        for (int i = 0; i < 20; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        configService.kill();
                    }
                }).start();
        }
    }
}
