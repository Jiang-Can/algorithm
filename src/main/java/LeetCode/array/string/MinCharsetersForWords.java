package LeetCode.array.string;

import java.util.*;
import java.util.stream.Collectors;

public class MinCharsetersForWords {
    public static void main(String[] args) {
        System.out.println("14".compareTo("111"));

/*            Integer i = 1;
            Integer j = 2;
        System.out.println(i.compareTo(j));*/
        test();
    }

    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character,Integer> map = new HashMap<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                map.put(c,map.get(c)==null?1: map.get(c)+1);
            }
        }
        return build(map);
    }
    private char[] build(Map<Character,Integer> map){
        List<Character> list = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }
        char[] chars = new char[list.size()];
        int i = 0;
        for(Character c:list){
            chars[i++] = c;
         }
        return chars;
    }

    static void test(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,3,4,7,13));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,4,13,15));
        int i1=0,i2=0;
        while (i1<list1.size()&&i2< list2.size()){
            if(list1.get(i1).compareTo(list2.get(i2))==0){
                i1++;
                i2++;
            }else if(list1.get(i1).compareTo(list2.get(i2))<0){
                list1.remove(i1);
            }else if(list1.get(i1).compareTo(list2.get(i2))>0){
                i2++;
            }
        }
        while (i1<list1.size()){
            list1.remove(i1);
        }

        System.out.println(list1);
        list1.forEach(System.out::println);
    }

}
