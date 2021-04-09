package 队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/3/23 13:14
 */
public class ArrayBlockingQueueTest {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        //add   底层调用offer 如果count等于items长度返回false,如果返回false,throw new IllegalStateException("Queue full");
        //      否则直接添加到items[putIndex]
        boolean add = queue.add("1");
        //        for(int i=0;i<10;i++){
        //            boolean add1 = queue.add(String.valueOf(i));
        //            System.out.println(add1);
        //        }
        //将指定的元素插入此队列的尾部，如果队列已满，则等待空间变为可用
        queue.put("2");

        //如果可以在不超过队列容量的情况下立即执行此操作，则将指定的元素插入此队列的尾部；如果成功，则返回true；如果此队列已满，则返回false。通常，此方法比方法add更可取，方法add只能通过抛出异常而无法插入元素
        boolean offer = queue.offer("3");

        //检索并删除此队列的头，如有必要，请等待直到元素可用
        String take = queue.take();
        System.out.println("take=" + take);

        //检索但不删除此队列的头部，如果此队列为空，则返回null
        String peek = queue.peek();
        System.out.println("peek=" + peek);

        //检索并删除此队列的头。此方法与poll的不同之处仅在于，如果此队列为空，它将引发异常
        String remove = queue.remove();

        //检索并删除此队列的头部，如果此队列为空，则返回null。
        String poll = queue.poll();
    }
}
