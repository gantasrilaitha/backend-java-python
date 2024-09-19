package collections.lists;

import java.util.*;

/* METHODS OF LIST INTERFACE
----------------------------
boolean add(Object): add an element at last
void add(int,Object):add element at given index
void set(int,Object): modify element at given index
boolean remove(Object): delete given element
Object remove(int): delete element at given index
Object get(int): returns element at given index
int size(): returns no.of elements

 */
public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Object> al = new ArrayList<Object>();
        al.add(10);
        al.add(20);
        al.add("xx");
        al.add("yy");
        System.out.println(al);// [10,20,xx,yy]
        al.add(2, "pp");
        System.out.println(al);// [10,20,pp,xx,yy]
        al.set(2, "qq");
        System.out.println(al);// [10,20,qq,xx,yy]
        al.remove("qq");
        System.out.println(al);// [10,20,xx,yy]
        al.remove(2);
        System.out.println(al);// [10,20,yy]
        String s = (String) al.get(2);
        System.out.println(s);// yy
        System.out.println("size " + al.size());
        for (Object oo : al) {
            System.out.println(oo);
        }
    }

}
