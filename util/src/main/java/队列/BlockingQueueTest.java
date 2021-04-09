package 队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * <p>
 * 阻塞队列
 * </p>
 *
 * @author wangzw
 * @date 2021/3/22 11:33
 */
public class BlockingQueueTest {

    private static BlockingQueue<String> queue = new PriorityBlockingQueue<>(Long.SIZE);

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                while (true) {
                    String result = queue.take();
                    System.out.println(Thread.currentThread() + ":" + result);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "获取阻塞队列内容线程").start();

        new Thread(() -> {
            for (int i = 0;i < 10;i++) {
                queue.offer(String.valueOf(i));
                System.out.println(Thread.currentThread() + ":" + i);
            }
        }, "向阻塞队列插入内容线程").start();
    }
}
