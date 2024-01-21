package baek.optional;

import baek.OnlineClass;
import baek.Progress;

import java.util.ArrayList;
import java.util.List;

public class OptionalMain {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", true));

        // 새롭게 추가한 progress는 값이 있을 수도 있고 null일 수도
        // 1. 기존의 해결방법 -> 에러를 만들기 좋은 코드!
        OnlineClass msa = new OnlineClass(6, "MSA", true);
        Progress progress = msa.getProgress();
        if (progress != null) {
            System.out.println(progress.getStudyDuration());
        }

    }
}
