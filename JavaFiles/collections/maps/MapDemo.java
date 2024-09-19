package collections.maps;

import java.util.*;

/* MAP INTERFACE CLASSES
-------------------------
HashMap: unordered based on keys & no duplicates
LinkedHashMap: ordered based on keys & no duplicates
TreeMap:sorted based on keys & no duplicates
 */
public class MapDemo {
    public static void main(String[] args) {
        // HashMap-unordered
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("monitor", 500);
        hm.put("mouse", 200);
        hm.put("ups", 290);
        hm.put("system", 1200);
        System.out.println(hm);
        Set<String> keys = hm.keySet();// get keys of map into a set
        for (String k : keys) {
            System.out.println(k + ":" + hm.get(k));// returns value of given key
        }

        // LinkedHashMap-ordered
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        lhm.put("monitor", 500);
        lhm.put("mouse", 200);
        lhm.put("ups", 290);
        lhm.put("system", 1200);
        System.out.println(lhm);

        // TreeMap-sorted
        /*
         * TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
         * tm.put("monitor", 500);
         * tm.put("mouse", 200);
         * tm.put("ups", 290);
         * tm.put("system", 1200);
         * System.out.println(tm);
         */
    }

}
