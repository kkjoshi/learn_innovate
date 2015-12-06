package SCJPTest.Examples;
interface xyz{
	default void getName(){}
}
public class Deer {
	  public Deer() { System.out.print("I am Deer: "); }
	  public Deer(int age) { System.out.print("DeerAge: "); }
	  private boolean hasHorns() { return false; }
	  private void CanYouCallMefromStaticMethod()
	  {
		  System.out.println("yes I can be called from static method");
	  }
	  public static void main(String[] args) {
		  int i1 = 1_234;
		  double d1 = 1_23_4.0;
		  System.out.println("int i:" + i1 + "double d: " + d1);
	    Deer deer = new Reindeer(5);
	    System.out.println(","+deer.hasHorns());
	    new Deer().CanYouCallMefromStaticMethod();
	    
	    int x = 5, j = 0;
	    OUTER: for(int i=0; i<3; )
	      INNER: do {
	        i++; x++;
	        if(x > 10) break INNER;
	        x += 4;
	       j++;
	      } while(j <= 2);
	    System.out.println(x);
	  }
	 }
	 class Reindeer extends Deer {
	  public Reindeer(int age) { System.out.print("Reindeer"); }
	  public boolean hasHorns() { return true; }
	} 