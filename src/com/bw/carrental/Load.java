package com.bw.carrental;

public class Load extends Car {
	int load;
	public Load(String name,int price,int load){
		this.price=price;
		this.load=load;
		this.name=name;
	}
	public void CarInfo() {
		// TODO Auto-generated method stub
		System.out.println(name+"\t"+price+"元/天\t载货："+load+"吨");
	}

}
