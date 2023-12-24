import java.util.function.Function;

public class Foo {
    public static void main(String[] args) {
        // 클래스를 선언한 후 사용
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        // 람다식 활용
        Function<Integer, Integer> plus20 = (i) -> i + 20;
        System.out.println(plus20.apply(2));

        // default 메소드 : compose()
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        Function<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
        System.out.println(multiply2AndPlus20.apply(4));

        // default 메소드 : andThen()
        Function<Integer, Integer> plus20AndMultiply2 = plus20.andThen(multiply2);
        System.out.println(plus20AndMultiply2.apply(5));
    }
}
