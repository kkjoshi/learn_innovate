package Collections.Test;

import java.util.*;

/**
 * Created by joshika on 10/1/2014.
 */
public class CollectionTester {
    class Inner implements Comparable{
        int i = 0;
        public Inner(int in)
        {
            i = in;
        }
        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int compareTo(Object y)
        {
            return  Integer.compare(i, ((Inner)y).getI());
        }
    }
     void sortedSetDemo() {
        SortedSet objSet = new TreeSet<Inner>();
        objSet.add(new Inner(5));
        objSet.add(new Inner(6));
        objSet.add(new Inner(7));
        objSet.add(new Inner(8));
        objSet.add(new Inner(9));

         SortedSet<Inner> tail = objSet.tailSet(new Inner(7));
         System.out.println(objSet);
         Iterator<Inner> it = tail.iterator();
         while(it.hasNext()){
             it.next().setI(20);
             //System.out.println(it.next());

         }
         while(it.hasNext()){
             System.out.println(it.next());
         }

         System.out.println("after tail and set operation" + objSet);
    }
    static void setDemo()
    {
        int count[] = {34, 22,10,22,60,30,22};
        Set<Integer> set = new HashSet<Integer>();
        try{
            for(int i = 0; i< count.length; i++){
                set.add(count[i]);
            }
            System.out.println(set);

            TreeSet sortedSet = new TreeSet<Integer>(set);
            System.out.println("The sorted list is:");
            System.out.println(sortedSet);

            System.out.println("The First element of the set is: "+
                    (Integer)sortedSet.first());
            System.out.println("The last element of the set is: "+
                    (Integer)sortedSet.last());
            System.out.println("Tailset");
            SortedSet<Integer> tail = sortedSet.tailSet(30);
            Iterator<Integer> it = tail.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }

            System.out.println("Headset");
            System.out.println(sortedSet.headSet(30));
            System.out.println("subSet");
            System.out.println(sortedSet.subSet(22, 34));
        }
        catch(Exception e){}
    }
    public static void hashSetDemo()
    {
        HashSet hashset = new HashSet();
        hashset.add(10);
        hashset.add(20);
        hashset.add(30);
        hashset.add(40);
        hashset.add(50);
        hashset.add(60);

        Set set = new HashSet<Integer>();
        set.add(20);
        set.add(30);
        set.add(40);
        // hashset.(set);
        for(Object in: hashset){
            System.out.println((Integer)in);
        }

    }
    public static void main(String[] args){
        //setDemo();
        //hashSetDemo();
       // CollectionTester ct = new CollectionTester();
       // ct.sortedSetDemo();
        WeakHashMapTest wht = new WeakHashMapTest();
        wht.test();
    }

}
 class WeakHashMapTest {
    private Map map;
    public void test () {
        map = new WeakHashMap();
        map.put(new String("Maine"), "Augusta");
        Runnable runner = new Runnable() {
            public void run() {
                int i=0;
                String s = map.get("Maine").toString();
                while (map.containsKey("Maine")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread waiting");
                    System.out.println("String s"+ s);
                    System.gc();
                    if (i>2) s = null;
                    i++;
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }
}