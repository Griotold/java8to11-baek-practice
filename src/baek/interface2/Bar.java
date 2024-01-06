package baek.interface2;
// 인터페이스를 상속받는 인터페이스에서 다시 추상 메서드로 변경할 수 있다.
public interface Bar extends Foo{
    void printNameUpperCase();
}
