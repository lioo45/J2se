package beautyOfCoding;

import java.util.BitSet;

/**
 * Created by pro on 16/12/27.
 */
public class TheSecond {

    public static void main(String[] args) {
        byte b=0;
        //  0000 0000  高4位代表A 低四位代表B
        for(b=16;((b&240))<=144;b+=16)
            for(b= (byte) ((b&240)+1); (b&15)<=9; b+=1)
                if(((b&240)>>4)%3!=(b&15)%3)
                    System.out.println("A" + ((b & 240) >> 4) + "B" + (b & 15));

    }
}
