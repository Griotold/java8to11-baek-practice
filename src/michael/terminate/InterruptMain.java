package michael.terminate;

public class InterruptMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start(); // 메인 스레드가 끝나도 500초를 기다려야 끝난다.

        thread.interrupt(); // 이렇게 해야 해당 스레드가 InterruptedException이 터진다.
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }

}
