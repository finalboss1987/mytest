package jdk.test;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @author zhiqiang.hzq
 *
 */

public class Test {

    public static void main(String[] args) {
//        Iter a = new Iter(10);
//        Iterator<Integer> it = a.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next().intValue());
//        }
//        
//        for (Integer i : a) {
//            System.out.println(i);
//        }
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        


    }

}

class Iter implements Iterable<Integer> {

    transient Integer[] elementData;

    public Iter(int size) {
        elementData = new Integer[size];
        for (int i = 0; i < size; i++) {
            elementData[i] = new Integer(i * 10);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iter_iter();
    }

    private class Iter_iter implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != elementData.length;
        }

        @Override
        public Integer next() {
            return elementData[index++];
        }

    }

}


abstract class tt {
    public abstract void a();
    public void b() {
        System.out.println("a");
    }
}
