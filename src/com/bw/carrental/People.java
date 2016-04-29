package com.bw.carrental;

public class People extends Car {
	int people;
	public People(String name,int price,int people){
		this.name=name;
		this.price=price;
		this.people=people;
	}
	@Override
	public void CarInfo() {
		// TODO Auto-generated method stub
		System.out.println(name+"\t"+price+"元/天\t载人："+people+"人");
	}

}
