/*
这是一个车的子类，叫做载人车，除了继承车的特性之外，
它还有一个特殊的属性，叫做载客量。
*/
package rentalFromgit;
public class mannedCar extends ACar{
	int manned;
	public mannedCar(String name,int price, int manned){
		this.name=name;
		this.price=price;
		this.manned=manned;
	}
	public void info(){
		System.out.println(name+"\t\t"+price+"元/天\t载人："+manned+"人");
	}
}
