package com.bw.carrental;

import java.lang.reflect.Array;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;
class Details{
	//public String list[]={"序号","名称","租金","载量"};
	public String[][] detail={{"1","奥迪","500","4","0"},{"2","马自达","500","4","0"},{"3","皮卡雪","450","4","2"},{"4","金龙","800","20","0"},
			{"5","松花江","400","0","4"},{"6","依维柯","1000","0","20"}};
	public void printPrice() {
		System.out.println("价目表：");
		System.out.println("序号 名称 租金 载量");
		for(int i=0;i<detail.length;i++){
			for(int j=0;j<detail[i].length;j++){
				if(j<3){
					System.out.print(detail[i][j]+" ");	
				}
				else {
					if(j==3){
						if(detail[i][3]=="0"){
							System.out.print("");
						}else{
							System.out.print("载人"+detail[i][j]);	
						}
					}else if(j==4){
						if(detail[i][4]=="0"){
							System.out.print("");
						}else {
							System.out.print("载货"+detail[i][j]);
						}	
					}
				}
			}
			System.out.println("");
		}													
	}
	public void printBill(int[] num,int days) {
		int[] num1=num;
		int day=days;
		
		Details billdetail=new Details();
		String[][] bill =billdetail.detail;
		int price=0;//每辆单价
		int sum=0;//总价
		StringBuffer person = new StringBuffer();
		StringBuffer object1 = new StringBuffer();
		//String person=null;//载人的车
		//String object=null;//载货的车
		for(int i=0;i<num1.length;i++){			
			price=Integer.parseInt(bill[num1[i]-1][2]);
			sum+=price*day;
			if(!(bill[num1[i]-1][3]=="0")){
				person.append(" "+bill[num1[i]-1][1]);
			}
			if(!(bill[num1[i]-1][4]=="0")){
				object1.append(" "+bill[num1[i]-1][1]);
			}
		}
		System.out.println("可载人的车有："+person);
		System.out.println("可载货的车有："+object1);
		System.out.println("总价："+sum);
	}
}


public class Rental {
	//public final int[] num;
	//public final String a;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int num[];
		// TODO Auto-generated method stub
		System.out.println("欢迎使用租车系统：");
		System.out.println("您是否要租车：1是，0否");
		Scanner flag=new Scanner(System.in);
		if(flag.nextInt()==1){
			//下面执行打印车辆信息的方法
			Details details=new Details();
			details.printPrice();
			
			//把租车的序号存入数组num
			System.out.println("请输入租车数量：");			
			Scanner flag2=new Scanner(System.in);
			int x1=flag2.nextInt();
			int num[] = new int[x1];			
			for(int i=0;i<x1;i++){
				System.out.println("请输入第"+(i+1)+"辆车的序号");
				Scanner flag3=new Scanner(System.in);
				int y=flag3.nextInt();
				num[i]=y;
			}
			
			//把租车天数赋值给x2
			System.out.println("请输入租车天数：");
			Scanner flag3=new Scanner(System.in);
			int x2=flag3.nextInt();
	
			//下面执行打印账单的方法
			System.out.println("您的账单：");
			
			details.printBill(num,x2);
			
			
			
			
		}else if(flag.nextInt()==0) {
			System.out.println("感谢您的浏览");
		}
			
	}

	@Override
	public String toString() {
		return "Rental [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


}

