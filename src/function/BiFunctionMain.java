package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * BiFunction<T, U, R>
 * */
public class BiFunctionMain {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;

        Integer result = biFunction.apply(2, 3);

        System.out.println(result);

        // take two Integers ander return a List<Integer>
        BiFunction<Integer, Integer, List<Integer>> biFunction2 = (x, y) -> Arrays.asList(x + y);

        List<Integer> result2 = biFunction2.apply(4, 5);

        System.out.println(result2);

        // BiFunction 과 Function 같이 쓰기
        BiFunction<Integer, Integer, Integer> bi3 = (x, y) -> x * y;
        Function<Integer, String> function = (input) -> "result : " + input;
        BiFunction<Integer, Integer, String> multiplyAndToString = bi3.andThen(function);
        System.out.println(multiplyAndToString.apply(6, 7));

    }
}
