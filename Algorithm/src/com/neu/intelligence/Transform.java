package com.neu.intelligence;

public class Transform {

	public void transform(int num,int n){
		//����numΪ�����ʮ������������nΪҪת���Ľ���
		int array[]=new int[100];
		int location=0;
		while(num!=0){//�����������Ϊ0ʱѭ��ִ������͸�ֵ
			int remainder=num%n;
			num=num/n;
			array[location]=remainder;//��������뵽������ȥ
			location++;
		}
		show(array,location-1);

	}
	private void show(int[] arr,int n){
		for(int i=n;i>=0;i--){
			if(arr[i]>9){
				System.out.print((char)(arr[i]+55));
			}
			else
				System.out.print(arr[i]+"");
		}
	}
	public static void main(String[] args)
	{
		// ��������
		Transform t=new Transform();
		t.transform(18, 4);

	}
}
