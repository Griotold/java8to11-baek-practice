package baek.method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class CollectionMethodMain {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("younghan");

        // Iterable.forEach() : 디폴트 메서드
        name.forEach(System.out::println);

        // Iterable.splitertator() : 디폴트 메서드
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=============");
        while(spliterator1.tryAdvance(System.out::println));

        // Collection.stream() : 디폴트 메서드
        long count = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();

        System.out.println(count);

        // Collection.removeId() : 디폴트 메서드
        name.removeIf(s -> s.startsWith("k"));
        name.forEach(System.out::println);

        // Comparator.reversed() : 디폴트 메서드
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);

    }
}
