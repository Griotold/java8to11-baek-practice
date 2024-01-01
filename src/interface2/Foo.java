package interface2;
public interface Foo {
    void printName();

    String getName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 받은 값을 대문자로 출력하는 것이다.
     * */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("인터페이스의 스태틱 메서드 호출");
    }

}
