package pratice.第一次上机.内容三;

import util.FileUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pro on 17/4/10.
 */
public class Main {
    public static void main(String[] args) {
                //读取学生成绩文件
        List<String> stuLists= FileUtil.readFile("/Users/pro/Documents/作业/mathScore.txt");

        Student students[]=new Student[stuLists.size()];
        int i=0;
        for(String s:stuLists){
            String[] ss=s.split(" ");
            if("本科生".equals(ss[2])) {
                Undergraduate undergraduate=new Undergraduate();
                undergraduate.setName("数学");
                undergraduate.setName(ss[0].trim());
                undergraduate.setScore(new Float(ss[1].trim()));
                students[i]=undergraduate;
            }else{
                Postgraduate postgraduate=new Postgraduate();
                postgraduate.setName("数学");
                postgraduate.setName(ss[0].trim());
                postgraduate.setScore(new Float(ss[1].trim()));
                students[i]=postgraduate;
            }
            ++i;
        }
        for(Student student:students)
            student.scoreToLevel();
        //按照某个科目的成绩排序
        List<Student> listStu=Arrays.asList(students);
        Collections.sort(listStu);

        for(Student student:listStu) {
            //身份
            String s=student instanceof Undergraduate?"本科生":"研究生";
            System.out.println("姓名:" + student.getName()
                    + " 成绩:" + student.getScore() + " 等级:" + student.levelToString()
                    + " 身份:" +s);
        }

        //
    }
}
