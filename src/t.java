import java.io.File;  
import java.util.Properties;  
  

import javax.mail.Address;
import javax.mail.Authenticator;  
import javax.mail.Message.RecipientType;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  

import javax.mail.internet.MimeMessage;  

public class t {
    public static void main(String[] args)
    {  
        Properties props = new Properties() ;  
        props.setProperty("mail.smtp.auth", "true") ;  
        props.setProperty("mail.host", "smtp.163.com") ;  
    	props.put("mail.smtp.auth", "true");				// 用户密码认证
    	props.put("mail.debug", "true");					// 调试模式
       
        Authenticator authenticator = new Authenticator(){  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                //lzy_lionel：对应你自己的用户名，后面没有@.xxx  ; password 对应你自己的邮箱密码  
//                return new PasswordAuthentication("from", "password") ;  
            	return new PasswordAuthentication("liwanzhi1995", "rriloveyou123") ;  
                  
            }  
        };  
        Session session = Session.getInstance(props, authenticator) ;  
        
        MimeMessage msg = new MimeMessage(session) ;  

        try{
        	msg.setFrom(new InternetAddress("liwanzhi1995@163.com"));      
			
//发送给：  
	        msg.setRecipients(RecipientType.TO,"2234933753@qq.com");

	        //设置主题：  
	        msg.setSubject("!!!出租 测试,!!!!");  
	        //设置内容：  
	        msg.setContent("!!!！!!", "text/html;charset=utf-8") ;  
	        Transport.send(msg);

//	       
        }catch(Exception e){
        	e.printStackTrace();
        	
        }
        
    }
}
