package 多线程;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/4/7 16:58
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        new Thread(() -> {
            for (int i = 1;i <= 50;i++) {
                atomicInteger.getAndAdd(1);
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 1;i <= 50;i++) {
                atomicInteger.getAndAdd(1);
            }
        }, "t2").start();

        System.out.println(
                atomicInteger.compareAndSet(5, 2020) + "\t current data:" + atomicInteger.get());
        System.out.println(
                atomicInteger.compareAndSet(5, 1024) + "\t current data:" + atomicInteger.get());
    }
}
