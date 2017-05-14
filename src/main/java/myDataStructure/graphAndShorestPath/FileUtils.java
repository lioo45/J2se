package myDataStructure.graphAndShorestPath;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pro on 23/4/4.
 */
public class FileUtils {

    /**
     *
     * @param filePath the file path
     * @return null,if an exception occur .
     *
     * @return the list<String> ,the element of list represent a line string of the file.
     * for example,list.get(0) is the first line string of the file.
     * list.get(x) is the (x+1)th line string of the file.
     */
    public static List<String> readFile(String filePath){
        List<String> list=null;
        try {
            list=Files.readAllLines(Paths.get(filePath),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //test
        boolean b=false;
        if(b) {
            System.out.println();
            System.out.println();
        }
        return list;
    }

    /**
     * Read json file and parse to a list of complete json data by matching braces
     *
     * @param filePath the file path
     * @return the list<String> ,
     * list.get(x) is the complete json data of a tweet.
     * if an exception occur ,return null.
     */
    public static List<String> readJosnFile(String filePath){
        List<String> list=new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            Stack<Character> stack=new Stack<Character>();
            bufferedReader=new BufferedReader(new FileReader(filePath));
            String s=null;
            String str="";
            while((s=bufferedReader.readLine())!=null){
                str+=s;
                for (int i = 0; i <s.length() ; i++) {
                    if(s.charAt(i)=='{')
                        stack.push(s.charAt(i));
                    if(s.charAt(i)=='}'){
                        if(stack.isEmpty()) {
                            System.out.println("json fomat is wrong!!!");
                            return null;
                        }
                        char c=stack.pop();
                        if(c=='{') {
                            if(stack.isEmpty()) {
                                list.add(str);
                                str="";
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void writeFile(String filePath,String info){
        BufferedWriter writer = null;
        try {
            writer=new BufferedWriter(new FileWriter(new File(filePath)));
            writer.write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
