package SCJPTest.Examples;

public class UnreachableCode {

	public static void main(String[] args){
		new IfWhileTest().checkIfUnreachableCode();
		new IfWhileTest().checkWhileUnreachableCode();
		
	}
}
class IfWhileTest{
	static boolean b123 = false;
	void checkIfUnreachableCode(){
	      if (true)
	      if (false)
	      System.out.println("True False");
	      else
	      System.out.println("True True");
	}

	void checkWhileUnreachableCode(){
	      if (b123)
	      while (b123){
	    	  System.out.println("True False");
	      }
	      
	      else
	      System.out.println("True True");
	      if (false){
	    	  System.out.println("True False");
	      }
	}

}

