/**
 * Created by joshika on 9/19/2014.
 */

public class QuizOver {
    public static void main(String args[]){
        Tester.javabeanExam2_11();
        //Apple appl = new Apple();
       // appl.toString();
       // int[] a = new int[5];
        //test(a);
        //System.out.print(a.length);
        //lengthTest();
       // testArraybound();
      //  byteMismatch();
       // Tester.main1();

    }
    static void byteMismatch()
    {
        byte b1= 25;

        byte b2=45;

        byte b3= (byte)(b1+b2);//b1+b2 gets converted to int so this compilation error
        int i = b3;
    }
    static void lengthTest()
    {
        int[] a = new int[0];
        System.out.print(a.length);
    }
    static void test(int[] a)
    {
        int[] b = new int[2];
        a = b;
        a[0] = 2;
        System.out.print(b.length);
        System.out.print(a.length);

        System.out.println("First element");
        System.out.println("a first element" + a[0]);
        System.out.println("b first element" + b[0]);

    }
    public static void testArraybound() {

        String entries[] = {"entry1","entry2"};
        int count=0;
        while (entries [count++]!=null){
            System.out.println(count);
        }
        System.out.println(count);
    }

}
class Tester {
    final static int x[] = new int[5];
    public static void main1() {
        final int x = new Tester().x[5];
        if (x <= 10)
            System.out.println("javachamp");
    }
    public static void javabeanExam2_11(){
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        Long l = new Long(127);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(l));
    }
}
