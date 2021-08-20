package com.poi.uitls;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


/**
 * @author eisuto
 */
public class EmailUtils {





    public static void sendEmail(String toEmail, String code) {
        try {
            // 服务器地址:
            String smtp = "smtp.qq.com";
            // 登录用户名:
            String username = "1939853291@qq.com";
            // 登录口令:
            String password = "lobjvgxfqpjdegig";
            // 连接到SMTP服务器587端口:
            Properties props = new Properties();
            // SMTP主机名
            props.put("mail.smtp.host", smtp);
            // 主机端口号
            props.put("mail.smtp.port", "587");
            // 是否需要用户认证
            props.put("mail.smtp.auth", "true");
            // 启用TLS加密
            props.put("mail.smtp.starttls.enable", "true");
            // 获取Session实例:
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            // 设置debug模式便于调试:
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            // 设置发送方地址:
            message.setFrom(new InternetAddress(username));
            // 设置接收方地址:
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            // 设置邮件主题:
            message.setSubject(String.format("【Shmily】您的验证码是：%s", code), "UTF-8");
            // 设置邮件正文:
            message.setText(String.format("【Shmily】您的验证码是：%s 欢迎来到Shmily", code), "UTF-8");
            // 发送:
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        EmailUtils.sendEmail("eisuto@qq.com", "123456");
    }
}
