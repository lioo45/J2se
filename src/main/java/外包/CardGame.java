package 外包;


import java.util.Random;
import java.util.Scanner;

/**
 * Created by pro on 17/4/7.
 */
public class CardGame {

    public static void main(String[] args) {
        String cards[]=getCards();
        while(true) {
            //get random integer
            Random rand = new Random();
            //get the first card and the value
            int random = rand.nextInt(52);
            String selectedCard = cards[random];
            int selectedValue = cardToValue(selectedCard);

            System.out.println("the first card is :" + selectedCard);
            System.out.println("the next card will be higher or lower than the last card?(input higher/lower ,empty to quit)");
            //user input
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            //input is empty
            if (choice == null || choice.length() <= 0 || choice.isEmpty())
                return;
            while (!inputIsValid(choice)) {
                System.out.println("input is valid.please input  higher or lower and ends with \"Enter\" ");
                choice = sc.nextLine();
            }
            //get next card's value
            String nextCard = selectedCard;
            int nextValue = selectedValue;
            while (nextValue == selectedValue) {
                int random2 = rand.nextInt(52);
                nextCard = cards[random2];
                nextValue = cardToValue(nextCard);
            }
            String result = nextValue > selectedValue  ? "higher".equals(choice)? "You win" : "You lose"
                    :"lower".equals(choice)?  "You win" : "You lose" ;
            System.out.println("the next card is :"+nextCard);
            System.out.println(result);
            System.out.println();
        }



    }

    public static boolean inputIsValid(String input){
        if("higher".equals(input)||"lower".equals(input))
            return true;
        return false;
    }
    private static int cardToValue(String card){
        String value=card.substring(2);
        if(value.length()>1)
            return 10;
        char c=value.charAt(0);
        switch (c){
            case 'A':
                return 1;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            default:
                return c-'0';

        }
    }


    public static String[] getCards(){
        String[] cards=new String[52];
        for (int i = 1, j=0; i <=13 ; i++) {
            String c=integerToStr(i);
            cards[j]="H-"+c;j++;
            cards[j]="D-"+c;j++;
            cards[j]="S-"+c;j++;
            cards[j]="C-"+c;j++;


        }
        return cards;
    }

    private static String integerToStr(int i) {
        if(i==1)
            return "A";
        else if(i<10)
            return String.valueOf(i);
        else  if(i==10)
            return "10";
        else if(i==11)
            return "J";
        else if(i==12)
            return "Q";
        else if(i==13)
            return "K";

        //invalid input
        return "false";
    }
}
