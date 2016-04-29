/*
这是一类特殊的汽车，既可以载人又可以载货
不多说，就是比普通的说多了两个属性，载人量和载货量。
*/
package rentalFromgit;
public class specialCar extends ACar{
	int manned;
	int load;
	public specialCar(String name,int price,int manned,int load){
		this.name=name;
		this.price=price;
		this.manned=manned;
		this.load=load;
	}
	public void info(){
		System.out.println(name+"\t\t"+price+"元/天\t载人："+manned+" 载货："+load);
	}
}
                                                                                                       