package yeli.exercise1;

import java.util.Arrays;
import java.util.Scanner;

//1��Describe a ��(nlgn)-time algorithm that, given a set S of n integers and another integer x, determines
//whether or not there exist two elements in S whose sum is exactly x. (Implement exercise 2.3-7.)
//

public class Main
{
	public  static   boolean BiSearch(int[] arr,int target,int p, int r)			//���ѱ��ź��������
	{																		//���ж��ֲ���
		if(p < r)
		{
			int mid  = (p + r) /2 ;
			if(arr[mid] == target ) return true;
			if(arr[mid] > target) return BiSearch(arr, target, p, mid-1);
			if(arr[mid] < target) return BiSearch(arr, target, mid+1, r);
		}	
		
		return false;
	}
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
	public static void  quickSort(int [] arr,int p ,int r)
	{
		if(p < r)
		{
		int q = partion(arr,p,r);
		quickSort(arr, p, q-1);
		quickSort(arr, q+1, r);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int[] arr1 = new int[num];
		for(int i = 0 ;i < num ;i++)
		{
			arr[i] = sc.nextInt();
			
		}
		int target = sc.nextInt();
		quickSort(arr1, 0, num-1);
		for(int i = 0 ;i < num ;i++)
		{
			arr1[i] = target - arr[i] ;
			
		}
		boolean flag = false;
		for(int i = 0;i < num;i++)
			if(BiSearch(arr1,arr[i], 0, num))
			{	System.out.println(true);
				flag = true;
				break;
			}
		if(!flag)
		System.out.println(false);
	}
}
