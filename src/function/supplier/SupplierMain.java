package function.supplier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * Supplier<T>
 * T get() 구현 필요
 * */
public class SupplierMain {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        // 현재 날짜와 시각을 받아오는 예제
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        LocalDateTime time = supplier.get();

        System.out.println(time);

        // 포매터로 원하는 형태로 변환
        String formatted = dtf.format(time);
        System.out.println(formatted);
    }
}
