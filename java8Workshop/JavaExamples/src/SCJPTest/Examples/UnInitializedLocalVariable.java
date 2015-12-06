package SCJPTest.Examples;

public class UnInitializedLocalVariable {
	static final double percent=0; //1     
	int offset = 10, base= 50; //2     
	public static double calc(double value) { 
		int coupon, offset, base; //3         
	if(percent <10){ //4             
	coupon = 15;
	offset = 20;
	base = 10;
	}
	return coupon*offset*base*value/100; //5 
	}

	public static void main(String[] args) { 
		//System.out.println(calc(100));
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int counter = 3;
		for (int value : arr) {
			if (counter >= 0) {break;} else {continue;}
		if (value > 4) { arr[counter] = value + 1;} counter++;
		}
		System.out.println(arr[counter]);
	}
}


