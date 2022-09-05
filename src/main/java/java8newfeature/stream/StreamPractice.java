package java8newfeature.stream;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        //Arrays 中的stream
        IntStream stream = Arrays.stream(new int[]{1, 2, 3});

        // Collection 中有stream的接口
        Stream<Integer> integerStream1 = new ArrayList<>(Arrays.asList(1,2,3)).parallelStream();
        Stream<Integer> integerStream2 = new ArrayList<>(Arrays.asList(1,2,3)).stream();

        //Stream 自带
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        // q1
        Set<Integer> collect = integerStream.map(n -> n*n*n).collect(Collectors.toSet());
        System.out.println(collect);

        //q2

    }
}
