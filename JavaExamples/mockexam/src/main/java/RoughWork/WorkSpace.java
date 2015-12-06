package RoughWork;

/**
 * Created by joshika on 1/25/2015.
 */
public class WorkSpace {

    public static void main(String[] args)
    {
        wrapperClasses();
        byte b = 5;
        go(b);
    }
    static void go(Long x){
        System.out.println("Long: " + x);
    }
    static void go(Object x){
        System.out.println("Object: " + x);
    }
    public static void wrapperClasses(){
        Integer i = new Integer(5);
        Integer i1 = 127;
        Integer i2 = 127;
        Long l = new Long(127);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(l));

        Double d5 = Double.valueOf("3.14f");
        System.out.println(d5 instanceof Double);

        String s = "hex = "+ Long.toString(254, 16);
        String s1 = "hex = "+ Long.toHexString(254);
        System.out.println(s + s1);
    }
}
