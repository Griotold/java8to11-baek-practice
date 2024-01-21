package baek.optional;

import baek.OnlineClass;
import baek.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", true));

        // 새롭게 추가한 progress는 값이 있을 수도 있고 null일 수도
        OnlineClass msa = new OnlineClass(6, "MSA", true);
        // 1. 기존의 해결방법 -> 에러를 만들기 좋은 코드!
//        Progress progress = msa.getProgress();
//        if (progress != null) {
//            System.out.println(progress.getStudyDuration());
//        }

        // 2. 자바 8 이후 해결방법 - Optional -> 리턴 타입에만 쓸 것을 권장
        Optional<Progress> progress = msa.getProgress();
        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));


        // Optional API
        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        // isPresent()
        boolean present = spring.isPresent();
        System.out.println(present); // true

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        // isEmpty()
        boolean empty = jpa.isEmpty(); // true
        System.out.println(empty);

        // get() - 비추
        try {
            OnlineClass aClass = jpa.get();
        } catch (NoSuchElementException e) {
            System.out.println("get()은 런타임 예외가 발생할 수도 있다.");
        }

        // ifPresent() -- 없을 때는 동작 안함
        spring.ifPresent(oc -> System.out.println(oc.getTitle()));

        // orElse() - 있으면 값을 꺼내고 없으면 ... -> 비추
        OnlineClass aClass = spring.orElse(createNewOnlineClass());
        System.out.println(aClass.getTitle());

        // orElseGet() - 있으면 Supplier 실행 안함, 없으면 Supplier 호출
        OnlineClass aClass1 = jpa.orElseGet(OptionalMain::createNewOnlineClass);
        System.out.println(aClass1.getTitle());

        // orElseThrow() - 없으면 예외를 발생
        try {
            OnlineClass aClass2 = jpa.orElseThrow(IllegalStateException::new);
        } catch (IllegalStateException e) {
            System.out.println("없으면 런타임 예외를 던지는데 기본값은 NoSuchElementException");
        }

        // filter()
        Optional<OnlineClass> aClass2 = spring.filter(oc -> oc.getId() > 10);
        System.out.println(aClass2.isEmpty()); // true

        // map()
        Optional<Integer> integer = spring.map(oc -> oc.getId());
        System.out.println(integer.orElseThrow());

        // flatMap() - Optional<Optional<>> 을 처리할 때 유용
        Optional<Progress> progress1 = spring.flatMap(OnlineClass::getProgress);
        try {
            System.out.println(progress1.orElseThrow());
        } catch (NoSuchElementException e) {
            System.out.println("...");
        }
    }

    private static OnlineClass createNewOnlineClass() {
        System.out.println("creating new Class");
        return new OnlineClass(10, "New class", false);
    }
}
