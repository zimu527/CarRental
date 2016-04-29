package com.bw.carrental;

public class Special extends Car {

	int people;
	int load;
	public Special(String name,int price,int people,int load){
		this.name=name;
		this.price=price;
		this.people=people;
		this.load=load;
	}
	@Override
	public void CarInfo() {
		// TODO Auto-generated method stub
		System.out.println(name+"\t"+price+"元/天\t载人："+people+"人 载货："+load+"吨");
	}
}
