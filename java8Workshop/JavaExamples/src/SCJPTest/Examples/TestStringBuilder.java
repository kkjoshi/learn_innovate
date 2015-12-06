package SCJPTest.Examples;

public class TestStringBuilder {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder("abc");
		StringBuilder sa = sb.reverse();
		StringBuilder sc = new StringBuilder(sb.toString());
		
		System.out.println(" sb Capicity: " + sb.capacity() + " sa Capicity: " + sa.capacity());
		System.out.println(" sb " + sb.toString()+ " sa "  + sa.toString());
		
		System.out.println("String builder reference equality, sa==sb " + (sa==sb));
		System.out.println("String builder equality: Same ref: sa.equals(sb) " + sa.equals(sb));
		System.out.println("String builder equality: Diff ref same value: sa.equals(sc) " + sa.equals(sc)); //equals not implemented for StringBuilder so it checks for ref equality
	}

}
