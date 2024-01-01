package interface2;

public class DefaultMethodMain {
    public static void main(String[] args) {
        FooImpl griotold = new FooImpl("griotold");
        griotold.printName();
        // 디폴트 메서드
        griotold.printNameUpperCase();

        // 스태틱 메서드
        Foo.printAnything();
    }
}
