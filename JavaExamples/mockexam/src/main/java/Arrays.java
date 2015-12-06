/**
 * Created by joshika on 9/19/2014.
 */
class Arrays
{
    public static void main(String [ ] args){
        javaArrayCasting();
        argsTest(args);
        /*for(int x=0;args.length>x++;){
            System.out.print(args[x]+ " ");
        }*/
    }
    static void argsTest(String[] args) {
        if (args.length == 1 | args[1].equals("debug")) {
            System.out.println(args[0]);
        } else {
            System.out.println("Release");
        }
    }
    static void javaArrayCasting()
    {
        Object obj = new int[] { 1, 2, 3 }; // line 12
        int[] someArray = (int[])obj; // line 13
        for (int i : someArray) System.out.print(i + " "); // line 14
    }
}

