package interview;

import com.sun.javafx.scene.traversal.Algorithm;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

import java.util.*;

/**5
 * Created by pro on 17/2/14 28 49 11 35 40 17 57 4 6.
 */
public class Main {
    static class Error implements Comparable{
        int errorNum=0;
        String recordName;
        String fileName;
        String rowNum;

        public Error(int errorNum, String recordName, String fileName, String rowNum) {
            this.errorNum = errorNum;
            this.recordName = recordName;
            this.fileName = fileName;
            this.rowNum = rowNum;
        }

        @Override
        public int compareTo(Object o) {
            Error other=(Error)o;
            if(this.errorNum==other.errorNum)
                return 0;
            else
                return this.errorNum>other.errorNum?1:-1;
        }
    }
    public static void main(String[] args) {
        Map<String,Error> map=new HashMap<String, Error>();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String rowNum=s.substring(s.lastIndexOf(" ")+1,s.length());
            String fileName=s.substring(0,s.lastIndexOf(" "));
            String recordName=fileName.length()<=16?fileName:s.substring(s.length()-15,s.length());

            if(map.containsKey(fileName)&&map.get(fileName).rowNum.equals(rowNum)){
                Error error=map.get(fileName);
                error.errorNum=error.errorNum+1;
                map.put(fileName,error);
            }
            else{
                map.put(fileName,new Error(1,recordName,fileName,rowNum));
            }
        }
        Error errors[]=new Error[map.size()];
        map.values().toArray(errors);
        int outputLen=map.size()>8?8:map.size();
        if(map.size()<=8)
            Arrays.sort(errors);
        else {
            for (int i = 0; i <8 ; i++) {
                for (int j = i+1; j <map.size() ; j++) {
                    if(errors[j].compareTo(errors[i])>0){
                        Error t=errors[i];
                        errors[i]=errors[j];
                        errors[j]=t;
                    }
                }
            }
        }
        for (int i = 0; i <outputLen ; i++) {
            System.out.println(errors[i].fileName+" "+errors[i].rowNum+" "+" "+errors[i].errorNum);

        }

    }

}
