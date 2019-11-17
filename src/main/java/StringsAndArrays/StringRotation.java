package StringsAndArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringRotation {

    boolean solution(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        String[] s1Chars = s1.split("");
        String[] s2Chars = s2.split("");
        HashMap<String, Integer> counter = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            String s1Current = s1Chars[i];
            String s2Current = s2Chars[i];

            // If they dont exist put them in the HashMap
            if (counter.get(s1Current) == null) {
                counter.put(s1Current, 0);
            }
            if (counter.get(s2Current) == null) {
                counter.put(s2Current, 0);
            }

            Integer s1Counter = counter.get(s1Current);
            Integer s2Counter = counter.get(s2Current);
            counter.replace(s2Current, s2Counter - 1);
            counter.replace(s1Current, s1Counter + 1);
        }
        Integer[] values = objectArrayToInt(counter.values().toArray());

        // there must be a more efficient way in java to sum or reduce an array
        System.out.println(Arrays.toString(values));
        for (Integer value : values) {
            if (value != 0) return false;
        }
        return true;
    }

    static Integer[] objectArrayToInt(Object[] a) {
        return Arrays.asList(a).toArray(new Integer[0]);
    }
}
