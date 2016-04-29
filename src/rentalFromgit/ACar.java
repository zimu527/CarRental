package rentalFromgit;
/*这是一个抽象类，一般的车都有两个共同的属性，name和price，
这里我没有用到getter,setter方法，因为这个系统很简单，
不想搞的那么复杂。抽象方法info用来输出车辆信息，将在子类中override。
*/
public abstract class ACar{
	String name;
	int price;
	public abstract void info();
}
