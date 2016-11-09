

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;





import java.util.Set;

import org.joda.time.DateTime;
import sun.tools.java.BinaryCode;


public class M {
	
	public static void main(String[] args) {

		int x=9999;
		int count=0;
		while(x!=0){
			if(x%2==1)
				count++;
			x/=2;
		}
		System.out.println(count);
	}
}
