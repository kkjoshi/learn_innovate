package SCJPTest.Examples;

public class TestPrivateConstructor {
	private TestPrivateConstructor(){
		System.out.println("from private constructor");
	}
	public static void main(String[] args)
	{
		new TestPrivateConstructor();
	}
}
