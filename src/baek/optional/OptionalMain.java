package baek.optional;

import baek.OnlineClass;
import baek.Progress;

import java.util.ArrayList;
import java.util.List;
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

    }
}
