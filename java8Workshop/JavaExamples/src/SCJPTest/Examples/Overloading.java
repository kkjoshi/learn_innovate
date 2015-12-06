package SCJPTest.Examples;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Overloading {

	    void probe(Object x) { System.out.println("In Object"); } //3 
	    void probe(Number x) { System.out.println("In BigDecimal"); } //2

	    void probe(BigDecimal x) { System.out.println("In BigDecimal"); } //2
	    void probe(BigInteger x) { System.out.println("In BigInteger"); } //2

	    void probe(Integer x) { System.out.println("In Integer"); } //2
	    
	    void probe(Long x) { System.out.println("In Long"); } //4
	    
	    public static void main(String[] args){
	        double a = 10; 
	        new Overloading().probe(a); 
	    }
}
