package com.bw.carrental;

import java.util.Scanner;

public class Inital {

	/**
	 * @param args
	 */

	public static void printInfo(Car[] cars) {
		System.out.println("序号\t名称\t租金\t载量");
		for (int i = 0; i < cars.length; i++) {
			System.out.print(i+1+"\t");
			cars[i].CarInfo();
		}
	}
	public static void printBill(Car[] cars,int[] carsNo,int days) {
		int peopleNum=0;
		int loadNum=0;
		int sumMoney=0;
		StringBuffer peopleCar=new StringBuffer();
		StringBuffer loadCar=new StringBuffer();
		for(int i=0;i<carsNo.length;i++){
			try {
				if(cars[carsNo[i]] instanceof Special){
					Special car=(Special)(cars[carsNo[i]]);
					peopleCar.append(car.name+" ");
					loadCar.append(car.name+" ");
					peopleNum=peopleNum+car.people;
					loadNum=loadNum+car.load;
				}else if(cars[carsNo[i]] instanceof People){
					People car=(People)(cars[carsNo[i]]);
					peopleCar.append(car.name+" ");
					peopleNum=peopleNum+car.people;
				}else if(cars[carsNo[i]] instanceof Load){
					Load car=(Load)(cars[carsNo[i]]);
					loadNum=loadNum+car.load;
					loadCar.append(car.name+" ");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sumMoney+=cars[carsNo[i]].price*days;
		}
		System.out.println("可载人的车有："+peopleCar+" 共可载"+peopleNum+"人");
		System.out.println("可载货的车有："+loadCar+" 共可载"+loadNum+"吨");
		System.out.println("总价："+sumMoney);
		
	}
	

	public static void main(String[] args) {
		Car[] cars = { new People("奥迪", 500, 4), new People("马自达6", 400, 4),
				new Special("皮卡雪6", 450, 4, 2), new People("金龙", 800, 20),
				new Load("松花江", 400, 4), new Load("依维柯", 1000, 20) };
		// TODO Auto-generated method stub
		System.out.println("欢迎使用租车系统：");
		while (true) {
			System.out.println("您是否要租车：1是，0否");
			Scanner flag = new Scanner(System.in);
			int yes = flag.nextInt();
			if (yes == 1) {
				// 下面执行打印车辆信息的方法
				Inital.printInfo(cars);
				//用while (true)将代码一直执行下去直到结束，每次输入前都有一个while (true)
				while (true) {
					System.out.println("请输入租车数量：");
					int num = flag.nextInt();
					if (num > 0 && num <= cars.length) {
						int[] no = new int[num];
						for (int i = 0; i < num; i++) {							
							System.out.println("请输入第" + (i + 1) + "辆车的序号");
							int Carno=flag.nextInt();
							while(true){
								if(Carno>0&&Carno<=cars.length){
									no[i] = Carno-1;
									break;
								}else {
									System.out.println("您输入的序号有误呦,输入的xuhao不能超过车类的数量！请重新输入：");
								}	
							}
						}
							while (true) {
								System.out.println("请输入租车天数：");
								int days = flag.nextInt();
								if (days > 0 && days <= 31) {
									System.out.println("您的账单：");
									printBill(cars,no,days);
									System.out.println("欢迎下次继续使用哒哒租车系统！");
									return;
								}else {
									System.out.println("亲，么么哒，只能租1-31天呦，重新输吧：");
								}
							}
					} else {
						System.out.println("您输入的数量有误呦,输入的数量不能超过车类的数量！请重新输入：");
					}
				}
			} else if (yes == 0) {
				System.out.println("欢迎下次继续使用哒哒租车系统！");
				return;// 此处用return可以跳出20行开始的循环
			} else {
				System.out.println("亲，只能输入1或者0,请重新输入：");
			}
		}
	}
}
