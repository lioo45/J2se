package xiaozhao.qiuzhao2016;


import java.util.Scanner;

/**
 * Created by pro on 17/3/23.
 */
public class Main {
    static class Card  {
        String s;
        int num;
        //1 2 3 4 5 6
        int type;

        public Card(String s) {
            this.s = s;
            init(s);
        }

        public void init(String s) {
            String s1 = s.replace(" ", "");
            s1=s1.replace("0","");
            if (s1.length() > 5) {
                type = 6;
                return;
            } else if (s1.length() == 5) {
                if (s1.equals("joker")) {
                    type = 1;
                    num = 16;
                    return;
                }
                if (s1.equals("JOKER")) {
                    type = 1;
                    num = 17;
                    return;
                }
                type = 5;
                num = change(String.valueOf(s1.charAt(0)));
            } else {
                type = s1.length();
                num = change(String.valueOf(s1.charAt(0)));
            }
        }

        public int change(String s) {
            if (s.equals("A"))
                return 14;
            if (s.equals("2"))
                return 15;
            if (s.equals("j"))
                return 16;
            if (s.equals("J"))
                return 17;
            if(s.equals("J"))
                return 11;
            if(s.equals("Q"))
                return 12;
            if(s.equals("K"))
                return 13;
            if(s.equals("1"))
                return 10;
            return new Integer(s);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] ss = s.split("-");
            Card first = new Card(ss[0]);
            Card second = new Card(ss[1]);
            if(first.type!=second.type){
                if(first.type==6){
                    System.out.println(first.s);
                    continue;
                }
                if(second.type==6){
                    System.out.println(second.s);
                    continue;
                }
                if(first.type==4){
                    System.out.println(first.s);
                    continue;
                }
                if(second.type==4){
                    System.out.println(first.s);
                    continue;
                }
                System.out.println("ERROR");

            }else{
                if(first.num>second.num)
                    System.out.println(first.s);
                else
                    System.out.println(second.s);
            }

        }
        //

    }
}

