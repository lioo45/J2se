package test.testCharset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by pro on 16/11/13.
 * 编码是将 表达 用相应的字符集来表示.
 * 解码是 将表示 按某种字符集来识别
 * 现在讨论 utf-8 gbk 与ios-8859-1
 * 知识点
 * java默认字符集是是根据操作系统来确定的
 * utf-8 与gbk不兼容 他们是两种表示
 * java网络传输
 * URLEncoder可以将 一种字符集的表示 用另外一种字符集来表示s
 */
public class Utf8AndgbkAndIso {
    public static void main(String[] args) throws Exception {
        String s="你好";

        //编码
        byte[] utf=s.getBytes("utf-8");
        byte[] gbk=s.getBytes("gbk");
        byte[] iso=s.getBytes("iso-8859-1");
        byte[] df=s.getBytes(Charset.defaultCharset());

        System.out.println("你好用utf-8编码表示:"+ Arrays.toString(utf));
        System.out.println("你好用gbk编码表示:"+Arrays.toString(gbk));
        //不能表示中文 63表示的是?
        System.out.println("你好用iso-8858-1编码表示:"+Arrays.toString(iso));

        //解码
        String s1=new String(utf,"utf-8");
        String s2=new String(gbk,"utf-8");
        String s3=new String(utf,"gbk");
        String s4=new String(gbk,"gbk");

        String s5=new String(s4.getBytes("utf-8"),"utf-8");

        System.out.println("s5="+s5);
        System.out.println(s1);
        //乱码
        System.out.println(s2);
        //乱码
        System.out.println(s3);

//        System.out.println(s5);

        System.out.println(s4);

        System.out.println(System.getProperty("file.encoding"));

    }

}
