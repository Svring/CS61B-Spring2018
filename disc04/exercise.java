package disc04;

import java.util.*;

import lab2.DebugPractice.In;

public class exercise {
    public static List<String> getwords(String filename) {
        In in = new In(filename);
        List<String> L = new ArrayList<String>();
        String word = in.readString();
        while (word != null) {
            L.add(word);
            word = in.readString();
        }
        return L;
    }

    public static int countUniqueWords(List<String> L) {
        Set<String> result = new HashSet<String>(L);
        return result.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> targets, List<String> words) {
        Map<String, Integer> ans = new HashMap<>();
        for (String s: targets) {
            int time = 0;
            for (String r: words) {
                if (s.equals(r)) {
                    time++;
                }
            }
            ans.put(s, time);
        }
        return ans;
    }
}