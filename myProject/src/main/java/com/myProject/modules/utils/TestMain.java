package com.myProject.modules.utils;

public class TestMain {

	
	public static void main(String[] args) {
		//�ر�ʱ 0   //������1
		int [] a = new int[10000];
		
		for(int i=1;i<=10000;i++)
		{
			a = getResult(a,i);
		}
		int num = 0;
		for(int i=0;i<a.length;i++)
		{
			num+=a[i];
			if(a[i] == 1)
			{
				System.out.println("��"+(i+1)+"������");
			}
		}
		System.out.println("�����ǣ�"+num);
		

	}
	
	//num  ��ǰ�ڼ��� ����  
	public static int [] getResult(int [] a,int num)
	{
		for(int i= 0;i<a.length;i++)
		{
			if((i+1)%num == 0)
			{
				a[i] = a[i]==0?1:0;
			}
		}
		return a;
	}
	
}
