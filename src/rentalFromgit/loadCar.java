/*
这是一个车的子类，叫做载货车，继承车的属性，
同时也拥有自己的特殊属性载货量。
*/
package rentalFromgit;
public class loadCar extends ACar{
	int load;
	public loadCar(String name,int price,int load){
		this.name=name;
		this.price=price;
		this.load=load;
	}
	public void info(){
		System.out.println(name+"\t\t"+price+"元/天\t载人："+load+"吨");
	}
}
