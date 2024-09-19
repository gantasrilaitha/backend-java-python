package collections.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/*SET INTERFACE
-----------------
Set is unordered collection of elements & no duplicates present

Classes under Set Interface
---------------------------
Hashset: unordered & no duplicates
LinkedHashSet: ordered & no duplicates
TreeSet: sorted & no dupicates
 
 */
public class SetDemo {
    public static void main(String[] args) {
        // HashSet-unordered
        HashSet<String> hs = new HashSet<String>();
        hs.add("one");
        hs.add("two");
        System.out.println(hs.add("two"));// false
        System.out.println(hs);

        // LinkedHashSet-ordered
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("one");
        lhs.add("two");
        System.out.println(lhs);

        // TreeSet-sorted
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("two");
        ts.add("three");
        System.out.println(ts);

    }

}
