package SCJPTest.Examples;

public class TestSomething {
private static long getNum(){ return 5L;}
public static void main(String[] args){ 
	System.out.println(getNum());
	System.out.println(DerivedTestSomething.getNum());
}
}

class DerivedTestSomething extends TestSomething{
	public static int getNum(){ return new Integer(10);}
	
}
