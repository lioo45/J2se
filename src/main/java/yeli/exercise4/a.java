package yeli.exercise4;

import java.util.Scanner;

//CountSort ������ֻ������ 0 1 ֵ�������  ͨ����������֤����ʱ��ΪOn,ͨ����ǰ����ļ�����ʹ��ǰ��Ԫ�ظ��类������ʵ���ȶ�
public class a {
	public static int[] countSort(int[] A)
	{
		
		int[] B = new int[A.length];
		int[] C = new int[2];
		for(int i = 0; i < A.length;i++)
		{
			C[A[i]]++;
		}
		for(int i = 1 ;i < 2 ;i++)
		{
			C[i] += C[i-1];
		}
		for(int i = 0; i <= A.length-1;i++)
		{
			B[C[A[i]]-1] = A[i]; 
			C[A[i]]--;
		}
		return B;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num = sc .nextInt();
		int[] arr = new int [num];
		for(int i = 0; i < num ;i++)
			arr[i] = sc.nextInt();
		
		arr = countSort(arr);
		
		for(int temp : arr)
			System.out.print(temp+ " ");
	}
}
