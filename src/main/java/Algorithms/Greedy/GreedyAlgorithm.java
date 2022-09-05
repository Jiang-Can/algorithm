package Algorithms.Greedy;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<Integer, HashSet<String>> numChar = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        numChar.put(1, set1);
        HashSet<String> set2 = new HashSet<>();
        set2.add("a");
        set2.add("d");
        set2.add("e");
        numChar.put(2, set2);
        HashSet<String> set3 = new HashSet<>();
        set3.add("a");
        set3.add("e");
        set3.add("f");
        numChar.put(3, set3);
        HashSet<String> set4 = new HashSet<>();
        set4.add("d");
        set4.add("f");
        set4.add("g");
        numChar.put(4, set4);
        HashSet<String> allChars = new HashSet<>();
        for (int i : numChar.keySet()) {
            allChars.addAll(numChar.get(i));
        }
        HashSet<String> tempSet;
        int maxKey;
        while (allChars.size() > 0) {
            maxKey = 0;
            for (int i : numChar.keySet()) {
                tempSet = numChar.get(i);
                tempSet.retainAll(allChars);
                if (maxKey == 0) {
                    maxKey = i;
                } else {
                    HashSet<String> maxMatch = numChar.get(maxKey);
                    maxMatch.retainAll(allChars);
                    if (tempSet.size() > 0 && tempSet.size() > maxMatch.size()) {
                        maxKey = i;
                    }
                }
            }
            HashSet<String> maxMatch = numChar.get(maxKey);
            maxMatch.retainAll(allChars);
            System.out.println("Remove " + maxKey+ " " + maxMatch);
            numChar.remove(maxKey);
            allChars.removeAll(maxMatch);
        }

    }
}

