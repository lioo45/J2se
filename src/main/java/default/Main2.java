import java.util.Scanner;

/**
 * Created by pro on 16/11/9.
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s=null;
        while((s=sc.nextLine())!=null) {
            char str[] = s.toCharArray();
            int sum = 0;
            int j = 1;
            for (int i = 0; i < str.length - 2; i++) {
                if (str[i] >= '0' && str[i] <= '9') {
                    int num = str[i] - '0';
                    num = num * j;
                    ++j;
                    sum += num;
                }
            }
            sum = sum % 11;
            if (sum == 10)
                sum = 'X';
            else
                sum = sum + '0';
            if (sum == (str[str.length - 1]))
                System.out.println("Right");
            else {
                str[str.length - 1] = (char) (sum);
                System.out.println(new String(str));
            }
        }
    }

}

