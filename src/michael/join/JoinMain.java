package michael.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        // 각각의 팩토리얼 값을 얻고 싶다!
        List<Long> inputNumbers = Arrays.asList(100000000L, 0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);

        List<FactorialThread> threads = new ArrayList<>();
        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (FactorialThread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        // 모든 스레드가 종료될 때 까지 메인 스레드는 기다리게 하기
        for (FactorialThread thread : threads) {
            // 2초까지 하고 안되면 메인스레드 깨우기
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println(inputNumbers.get(i) + "는 아직 진행중임");
            }
        }
    }
}
