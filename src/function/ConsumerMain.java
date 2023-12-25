package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/**
 * Consumer<T>
 * */
public class ConsumerMain {
    public static void main(String[] args) {
        // 입력만 받고 리턴값이 void
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("griotold");

        // 리스트를 받아서 출력해주는 예제
        Consumer<Integer> consumer2 = x -> System.out.println(x);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        forEach(list, consumer2);

        // 또는 한 줄로 줄일 수도 있다.
        forEach(list, (i) -> System.out.println(i));

        // 문자열 리스트를 입력 받아 글자수를 리턴
        List<String> strList = Arrays.asList("a", "ab", "abc");
        forEach(strList, x -> System.out.println(x.length()));


    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
