package com.exam;

/**
 * Created by joshika on 9/4/2014.
 */
class abc{
    static{
        System.out.println("Static");
    }
    {
        System.out.println("Instance");
    }
}
public class AccessSpecifier {
    abstract static class Inner{
        static void printExistence(){
            System.out.println("From InnerClass");
        }

    }
    final void printHi()
    {
        System.out.println("Hi");
    }
    public AccessSpecifier () {
        System.out.println("constructor");
    }
    public void AccessSpecifier(String s) {
        System.out.println("Method with void return value");
    }

    void DefaultAccessSpecifier (int i) {
        System.out.println("DefaultAccessSpecifier" + "i: " + i);
    }
    protected AccessSpecifier (int i, float j) {
        System.out.println("DefaultAccessSpecifier" + "i: " + i + "j: " + j);
    }

    public void AccessSpecifier () {
        System.out.println("void constructor");
    }
    public static void method1()
    {
        System.out.println("called");
    }
/*
    public static void main(String[] args) {
        System.out.println("DefaultAccessSpecifier");
     }
*/


    public static void main(String[] args){
        String lineS = System.getProperty("line.separator");
        Integer i = new Integer(0);
        Float f = new Float(0);
       // System.out.println(i==f);
        System.out.println(i.equals(f));
/*
        switch (lineS) {
            case "\r\n":
                lineS = "\r\n";
                break;
            case "\n":
                lineS = "\n";
                break;
            default:
                lineS = "\r\n";
                break;
        }
*/
        int arr[] = new int[3];
        int []arr1 = new int[4];
        AccessSpecifier asp = null;
        asp.method1();
        asp = new AccessSpecifier();
        asp.AccessSpecifier();
        AccessSpecifier.Inner.printExistence();
        abc a = null;
        a = new abc();
    }

}
