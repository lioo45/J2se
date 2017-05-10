package yeli.exercise4;

import java.util.Scanner;

//���ڹؼ���ֻ��0��1 �Ҳ�Ҫ���㷨�ȶ� ����ֱ�Ӷ�0��1���м���������������
public class b 
{
	public static void sortA(int[] arr)
	{
		int[] count = new int[2];
		
		for(int i = 0 ;i < arr.length;i++)
		{
			count[arr[i]]++;
		}
		int i;
		for( i = 0 ; i < count[0] ;i++)
		{
			arr[i] = 0;
		}
		for( i = count[0] ; i < arr.length ;i++)
		{
			arr[i] = 1;
		}
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num = sc .nextInt();
		int[] arr = new int [num];
		for(int i = 0; i < num ;i++)
			arr[i] = sc.nextInt();
		
		sortA(arr);
		
		for(int temp : arr)
			System.out.print(temp+ " ");
	}
}
