package SCJPTest.Examples;

class Super{
	
}
public class CheckDownCast  extends Super{
void go(){
	go2(new Super(), new CheckDownCast());
	go2((CheckDownCast)new Super(), new CheckDownCast());
}
void go2(Super s1, CheckDownCast cd1){
	CheckDownCast cd2 = (CheckDownCast)s1; // ClassCastException, SCJPTest.Examples.Super cannot be cast to SCJPTest.Examples.CheckDownCast
	Super s2 = (Super)cd1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckDownCast().go();

	}

}
