package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * @Auther: Administrator
 * @Date: 2018/7/11 0011 10:48
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=EmailApp.class)
public class mail {


    @Autowired
    private JavaMailSender mailSender;



    @Test
    public void sendSimpleMail() throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xulei@rongzi.com");
        message.setTo("2355735457@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("第二次测试邮件内容");

        mailSender.send(message);


        //测试邮件发送情况。
        Properties props = new Properties();
        props.setProperty("mail.debug", "true");
        Session instance = Session.getInstance(props);
        instance.setDebug(true);


        String getenv =System.getProperty("user.dir")+File.separator+"emial.log";
        File file=new File(getenv);

        PrintStream ps=new PrintStream(new FileOutputStream(file));

        instance.setDebugOut(ps);

        byte[] bs=new byte[1024];

        try {
            ps.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            ps.close();
        }


    }

}
