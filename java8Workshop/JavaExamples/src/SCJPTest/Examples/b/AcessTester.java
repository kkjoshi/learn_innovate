package SCJPTest.Examples.b;

import SCJPTest.Examples.a.AccessTest;  

public class AcessTester extends AccessTest{
	public static void main(String[] args){
		//new AccessTest().c();
		AcessTester ref = new AcessTester();
		ref.c();
		new SubAcessTester().c();
	} 
}

class SubAcessTester extends AcessTester{
	public void func(){
		
	}
}
