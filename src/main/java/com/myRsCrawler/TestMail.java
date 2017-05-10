package com.myRsCrawler;
import java.io.File;  
import java.util.Properties;  
  

import javax.mail.Address;
import javax.mail.Authenticator;  
import javax.mail.Message.RecipientType;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;  
import javax.mail.internet.MimeMessage;  
import javax.mail.internet.MimeMultipart;  
import javax.mail.internet.MimeUtility;  
  

public class TestMail {  
  
    /** 
     * 不带附件的普通邮件 
     *  
     * @throws Exception 
     */  
    
    public static void main(String[] args)
    {
        Properties props = new Properties() ;  
        props.setProperty("mail.smtp.auth", "true") ;  
        props.setProperty("mail.host", "smtp.163.com") ;  
//    	props.setProperty("mail.debug", "true");					// 调试模式
       
          
        Authenticator authenticator = new Authenticator(){  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                //lzy_lionel：对应你自己的用户名，后面没有@.xxx  ; password 对应你自己的邮箱密码  
            	return new PasswordAuthentication("liwanzhi1995", "rriloveyou123") ;  
                  
            }  
        };  
        Session session = Session.getInstance(props, authenticator) ;  
          
        MimeMessage msg = new MimeMessage(session) ;  
        try{
        	msg.setFrom(new InternetAddress("liwanzhi1995@163.com"));      
            
            //发送给：  
        	msg.setRecipients(RecipientType.TO,"lioo45@qq.com") ;  
            //抄送给：  
//            msg.setRecipients(RecipientType.CC,"to2@vip.qq.com") ;  
//            //暗送给：  
//            msg.setRecipients(RecipientType.BCC,"to3@126.com") ;  
            //设置主题：  
            msg.setSubject("有点郁闷 ");
            //设置内容：  
//            msg.setContent("你好，收到请回复！!!!!", "text/html;charset=utf-8") ;  msg.setContent("你好，收到请回复！!!!!", "text/html;charset=utf-8") ;  
            msg.setContent("宝宝 你知道我有多郁闷吗?4.sku最小库存量单位,其实就是商品id,是商品最细粒度的划分,每个sku唯一对应一件商品+", "text/html;charset=utf-8") ;  
            Transport.send(msg);  
        }catch(Exception e){
        	e.printStackTrace();
        }
       }
   }
