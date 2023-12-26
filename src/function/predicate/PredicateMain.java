package function.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());

        System.out.println(collect);

        Predicate<Integer> noGreaterThen5 = x -> x > 5;

        List<Integer> collect2 = list.stream()
                .filter(noGreaterThen5)
                .collect(Collectors.toList());

        System.out.println(collect2);

        // multiple filters
        List<Integer> collect3 = list.stream().filter(x -> x > 5 && x < 8).collect(Collectors.toList());

        System.out.println(collect3);

    }
}
