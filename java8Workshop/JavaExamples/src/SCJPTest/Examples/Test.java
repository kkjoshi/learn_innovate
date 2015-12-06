package SCJPTest.Examples;

import java.io.Console;
import static java.lang.System.out;
class BaseTest{
	void getMyIntention(){
		out.println("I am basetest");
	}
}
public class Test extends BaseTest{
	
	public enum IceCream{
		Kajudraksh(100), BalckCurrent(150), Rajbhog(500){
			
			//constant specific class body
			String getCompanyName()	{
				
				return "Amul";
			}
		};
		
		private int _gms;
		 IceCream(int gms){
			this._gms = gms;
		}
		int getGms(){
			return _gms;
		}
		String getCompanyName()	{
			
			return "Maganlal";
		}
	}
	static public void main(String[] a)	{
		int x1 =0;
		for(int i=0;i<10;){
			x1 = i++;
			System.out.print(i + " x " + x1);
		}
		new Test().getMyIntention();
		IceCream ic = IceCream.BalckCurrent;
		IceCream ic1 = IceCream.Kajudraksh;
		IceCream ic2 = IceCream.Rajbhog;
		IceCream[] iceCreamBox = new IceCream[]{IceCream.BalckCurrent, IceCream.Kajudraksh, IceCream.Rajbhog};	
		out.println(ic);
		out.println(ic1);
		out.println(ic2);
		for(IceCream x:iceCreamBox){
			out.println("Name: " + x.name() + ", Ordinal: " + x.ordinal() + ", Weight: " + x.getGms() + ", Company: " +
						x.Rajbhog.getCompanyName());
			
		}
		for(IceCream x:IceCream.values()){
			out.println(x.getCompanyName());
		}
	//	IBouncable ibounce = new Ball();
	//	Ball bounce = new Ball();
		
	//	out.println(ibounce.getBounceCount());
	//	out.println(bounce.bollBouncedCount); // accessing default class and member from same package
	//	out.println(bounce.bollBouncedCount1); // illegal: accessing private class and member from same package
	//	exercise5_2();
	//	exitusinglabeledbreak();
	}
	private static void exitusinglabeledbreak() {
		int i =0;
		outer:
		while (i<=5){
			for (int j=0;j<5;++j){
				if(j >3)
					break outer;
				System.out.println("Value of j:" + j);
			}
			System.out.println("Value of i:" + i);
			++i;
		}
	}
private static void exercise5_2(){
	short age = 0;
	outer:
	while (age<=21){
		    ++age;
			if(age >=16){
				System.out.println("get driver license");
				continue outer;
			}
			else{
				System.out.println("another year");
			}
		}
	}
	
}
