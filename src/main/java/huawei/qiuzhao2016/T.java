package huawei.qiuzhao2016;

import sun.jvm.hotspot.runtime.solaris_sparc.SolarisSPARCJavaThreadPDAccess;

/**
 * Created by pro on 17/3/23.
 */
public class T {
    public static void main(String[] args) {
//        String  file= "abc.c 123";
//        String s=file.substring(file.lastIndexOf("\\")+1);
//
//        String s2=s.substring(s.indexOf(" ")+1);
//
//        String s3=s.substring(0,s.indexOf(" "));
//        System.out.println(s);
//        System.out.println(s2);
//        System.out.println(s3);

//        String realName="aaaaaaaaaaaa3.txt";
//        System.out.println(realName.length());
//        String name = realName.length() > 16 ? realName.substring(realName.length() - 16) : realName;
//        System.out.println(name);
//        System.out.println(name.length());

        String s="4 4 4 4-jo jo";
        String[] ss=s.split("-");
        String s1=ss[0];
        System.out.println(s1.replace(" ",""));
//        for (String s1:ss)
//            System.out.println(s1);
    }
}
