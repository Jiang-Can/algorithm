package LeetCode.array.string;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CodeTest {
    public static void main(String[] args) throws Exception {
        String str = "clementisacap";
        Set<Character> set = new HashSet<>();
        int i = 0, j=0;
        int len = 0;
        int[] cache = new int[2];
        char[] chars = str.toCharArray();
        while(j<str.length()){
            if(set.contains(chars[j])){
                set.remove(chars[i++]);
            }else{
                if(j-i>len){
                    cache[0] = i;
                    cache[1] = j;
                    len = j-i;
                }
                set.add(chars[j++]);
            }
        }
        System.out.println(str.substring(cache[0],cache[1]+1));
    }

}
