package huawei.qiuzhao2016;

import java.util.*;

/**
 * Created by pro on 17/3/23.
 */
public class Main2 {
    static class Error implements Comparable{
        String realName;
        String name;
        int errorNum;
        int order;
        int line;

        public Error(String realName, String name, int errorNum, int order, int line) {
            this.realName = realName;
            this.name = name;
            this.errorNum = errorNum;
            this.order = order;
            this.line = line;
        }

        @Override
        public int compareTo(Object o) {
            Error e=(Error)o;
            if(e.errorNum<this.errorNum)
                return -1;
            else if(e.errorNum==this.errorNum){
                if(e.order==this.order)
                    return 0;
                else if(e.order<this.order)
                    return 1;
                else
                    return -1;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一个计数值
        Map<String, Error> map = new HashMap<String, Error>();
        int order = 1;
        while (sc.hasNext()) {
//            for (int i = 0; i < 20; i++) {

                String file = sc.nextLine();

                String s = file.substring(file.lastIndexOf("\\") + 1);

                //获得真名
                String realName = s.substring(0, s.indexOf(" "));
                //获得假名
                String name = realName.length() > 16 ? realName.substring(realName.length() - 16) : realName;
                //获得错误行号
                int line = new Integer((s.substring(s.lastIndexOf(" ") + 1)).trim());

                String key = realName + line;

                //去Map里找并计数 key为文件名加行号
                Error e = map.get(key);
                if (e == null) {
                    map.put(key, new Error(realName, name, 1, order, line));
                    order++;
                } else {
                    e.errorNum++;
                    map.put(key, e);
                }

            }

            //输出结果
            //将Map的元素放入List

            List<Error> list = new ArrayList<Error>(map.size());
            for (String key1 : map.keySet()) {
                list.add(map.get(key1));
            }

            //再调用Collection排序输出
            Collections.sort(list);
            int len = list.size() > 8 ? 8 : list.size();
            for (int i = 0; i < len; i++) {
                Error e1 = list.get(i);
                System.out.println(e1.name + " " + e1.line + " " + e1.errorNum);
            }

    }
}
