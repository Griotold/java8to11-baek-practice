package michael.practice;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;

        // 각각의 계산을 별도의 스레드에서 수행하고 그 결과를 더합니다.
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

        // 각 스레드 시작
        thread1.start();
        thread2.start();

        try {
            // 스레드 종료까지 대기
            thread1.join();
            thread2.join();

            // 결과 합산
            result = thread1.getResult().add(thread2.getResult());
        } catch (InterruptedException e) {
            // 예외 처리
            throw new RuntimeException("Thread calculation interrupted");
        }

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            // result = base ^ power 계산
            result = base.pow(power.intValue());
        }

        public BigInteger getResult() {
            return result;
        }
    }
}

