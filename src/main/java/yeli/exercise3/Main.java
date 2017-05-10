package yeli.exercise3;

import java.util.Scanner;

//Implement Quicksort and Randomized Quicksort. 
public class Main {
	public static int partion(int[] arr ,int p ,int r)
	{	
		int temp = arr[r];
		int i,j;
		for(j = p,i = j-1 ; j < r ; j++)
		{
			if(arr[j] <=  temp ) 
				{
					i++;
					int exchange;
					exchange = arr[j];			//�����һ����Ԫ�ر�arr[r-1]С
					arr[j] = arr[i];			//�ͽ���arr[i] arr[j]
					arr[i] = exchange;			//����i����
				}
		}
		arr[r] = arr[i+1];
		arr[i+1] = temp;
		
		return i+1;
	}
	
	public static int randomPortion(int[] arr,int p,int r)
	{
		int random = (int)Math.random()*(r-p)+p;								//��һ������滻arr[r] Ϊarr[random]
		if(random > r || random < p) System.out.println("���Խ��");
		int temp = arr[r];
		arr[random] = arr[r];
		arr[r] = temp;
		return partion(arr, p, r);
	}
	public static void  quickSort(int [] arr,int p ,int r)
	{
		if(p < r)
		{
		int q = partion(arr,p,r);
		quickSort(arr, p, q-1);
		quickSort(arr, q+1, r);
		}
	}
	public static void randomSort(int[] arr,int p,int r)
	{
		if(p < r)
		{
			int q = randomPortion(arr, p, r);
			randomSort(arr, p, q-1);
			randomSort(arr, q+1, r);
		}
	}
	public static void main(String[] args) 
	{		Scanner sc = new Scanner( System.in);
			int[] arr = new int [10];
			for(int i = 0 ; i < 10 ;i++) arr[i] = sc.nextInt();
			
			randomSort(arr, 0, 9);
			
			for(int temp : arr) System.out.print(temp+" ");
			System.out.println();
			quickSort(arr, 0, 9);
			
			for(int temp : arr) System.out.print(temp+" ");
	}
}
