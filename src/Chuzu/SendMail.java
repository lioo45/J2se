package Chuzu;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	public static void send(String subject,String content)
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
	        Address[] addresses = new InternetAddress[1];
	        addresses[0]= new InternetAddress("lioo45@qq.com");
//	        addresses[1]= new InternetAddress("2234933753@qq.com");
            //发送给：  
        	msg.setRecipients(RecipientType.TO,addresses); 
            //抄送给：  
//            msg.setRecipients(RecipientType.CC,"to2@vip.qq.com") ;  
//            //暗送给：  
//            msg.setRecipients(RecipientType.BCC,"to3@126.com") ;  
            //设置主题：  
            msg.setSubject(subject);
            //设置内容：  
//            msg.setContent("你好，收到请回复！!!!!", "text/html;charset=utf-8") ;  msg.setContent("你好，收到请回复！!!!!", "text/html;charset=utf-8") ;  
            msg.setContent(content, "text/html;charset=utf-8") ;  
            Transport.send(msg); 
        }catch(Exception e){
        	e.printStackTrace();
        }
       }
}
