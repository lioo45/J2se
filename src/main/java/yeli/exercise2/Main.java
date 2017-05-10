package yeli.exercise2;

import java.util.Scanner;

//��Implement priority queue.
//	���ȼ������ô󶥶�ʵ��  �ѵĻ������� ��ʼ���󶥶� ��ȡ���\
class heap
{	
	int[] arr; 
	int size;
	heap(int num)								//��ʼ����
	{
		arr = new int[num];
		size = 0;
	}
	public void addElement(int num)				//Ϊ�����Ԫ��
	{	
		if(size <= arr.length -1 )
			{
				arr[size+1] = num;
				size++;
			}
		else 
			{
				System.out.println("��������");	
			}
	}
	public void initMaxHeap()					//����󶥶�		
	{	int max;
		for(int i = this.size/2 -1 ; i >= 1 ; i--)
		{	
			max = i;
			if(arr[2*i] > arr[i]) max = 2 * i;
			if(arr[2*i + 1] > arr[max]) max = 2 * i + 1;
			
			if(max != i)
			{
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}
	}
	public  int getMax()				//�ó�����Ԫ�� �������һ��Ԫ�ر�ɵ�һ��Ԫ��
	{
		int temp = arr[1];
		arr[1] = arr[size];
		size--;
		return temp;
	}
}
public class Main
{
	public static void main(String[] args) 
	{	int temp;
		heap priorityQueue ;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		priorityQueue  = new heap(num+1);
		for(int i = 0 ; i < num ;i++)
		{
			temp = sc.nextInt();
			priorityQueue.addElement(temp);
		}
		priorityQueue.initMaxHeap();
		int max = priorityQueue.getMax();
		System.out.println(max);
	}
}
