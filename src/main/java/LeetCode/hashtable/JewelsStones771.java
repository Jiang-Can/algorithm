package LeetCode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class JewelsStones771 {


    public int bestSol(String jewels, String stones) {
        int[] record = new int[123];
        int count = 0;
        for(int i = 0; i<stones.length(); i++) {
            record[stones.charAt(i)] += 1;
        }
        for(int i = 0; i<jewels.length(); i++) {
            count += record[jewels.charAt(i)];
        }
        return count;
    }

    public int numJewelsInStones(String jewels, String stones) {
        char[] jChar=jewels.toCharArray();
        char[] sChar=stones.toCharArray();
        int count=0;
        Set<Character> set=new HashSet<>();
        for(char c:jChar){
            set.add(c);
        }
        for(char c:sChar){
            if(set.contains(c)){
                count++;
            }
        }
        return count;
    }

    public int regxSolution(String jewels, String stones){
        String reg="[^"+jewels+"]";
        return stones.replaceAll(reg,"").length();
    }

}
