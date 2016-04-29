/*
这就是主函数，run这个class程序就能运行啦！欢迎各路达人批评，修改，提意见！
有技术上的指导或者问题请联系我。
目前存在的bug：如果在要求输入数字时输入的其他符号，系统会报错，抛出异常就可以解决了
这里为了省事就没有写。
*/
package rentalFromgit;
import java.util.*;
public class initial{
	public static void printInfo(ACar[] cars){
		for(int i =0;i<cars.length;i++){
		System.out.print((i+1)+".\t");
		cars[i].info();
		}
	}
	public static void main(String[] args){
		ACar[] cars={new mannedCar("奥迪A4",500,4),new mannedCar("马自达6",400,4),new specialCar("皮卡雪6",450,4,2),new mannedCar("金龙",800,20),new loadCar("松花江",400,4),new loadCar("依维柯",1000,20)};
		System.out.println("欢迎使用哒哒租车系统：\n您是否要租车：1=是 0=否");
		Scanner scan=new Scanner(System.in);
		while(true){
			String input = scan.next();
			if(input.equals("1")){
				System.out.println("序号\t汽车名称\t租金\t\t容量");
				printInfo(cars);
				System.out.println("请输入您要租汽车的数量：");
				while(true){
					int num = scan.nextInt();
					if(num>0&&num<=cars.length){
						int[] no=new int[num];
						for(int i=0;i<num;i++){
							System.out.println("请输入第"+(i+1)+"辆车的序号：");
							while(true){
								no[i]=scan.nextInt()-1;
								if(no[i]<0||no[i]>=cars.length)
									System.out.println("只能输入上面显示的车辆序号，请重新输入：");
								else
									break;//这里有点别扭，不能用return跳出内层的while循环，用return的话默认跳出for循环...尴尬...
							}
						}
						System.out.println("请输入租车天数：");
						int day = 0;//这个地方也有点奇葩，不知道为什么不能把day定义到while里。
						while(true){
							day = scan.nextInt();
							if(day<0||day>31)
								System.out.println("亲，么么哒，只能租1-31天呦，重新输吧：");
							else
								break;
						}
						System.out.println("您的账单：\n***可载人的车有：");
						int sumPeo=0;
						int sumLoad=0;
						int sumPrice=0;
						for(int i=0;i<num;i++){
							if(cars[no[i]] instanceof mannedCar){
								mannedCar car = (mannedCar)cars[no[i]];
								sumPeo+=car.manned;
								sumPrice+=(car.price*day);
								System.out.print(car.name+" ");
							}
							if(cars[no[i]] instanceof specialCar){
								specialCar car = (specialCar)cars[no[i]];
								sumPeo+=car.manned;
								sumPrice+=(car.price*day);
								System.out.print(car.name+" ");
							}
						}
						System.out.println("共载人："+sumPeo+"人");
						System.out.println("***载货的车有：");
						for(int i=0;i<num;i++){
							if(cars[no[i]] instanceof loadCar){
								loadCar car = (loadCar)cars[no[i]];
								sumLoad+=car.load;
								sumPrice+=(car.price*day);
								System.out.print(car.name+" ");
							}
							if(cars[no[i]] instanceof specialCar){
								specialCar car = (specialCar)cars[no[i]];
								sumLoad+=car.load;
								//这里不需要再次计算价格，因为这类车既能载人又能载物，所以遍历载人的车时已经计算过了，不需要重复计算。
								System.out.print(car.name+" ");
							}
						}
						System.out.println("共载货："+sumLoad+"吨");
						System.out.println("\n租车总价格："+sumPrice+"元");
						return;
					}
					else
						System.out.println("您输入的数量有误呦,输入的数量不能超过车类的数量！请重新输入：");
				}
			}
			else if(input.equals("0")){
				System.out.println("23333，欢迎下次继续使用哒哒租车系统！");
				return;
			}
			else
				System.out.println("亲，只能输入1或者0,请重新输入：");
		}	
	
	}	
}
