package 文件监听.jdk;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * <p>
 * WatchService使用
 * 文件复制粘贴会被认定两次事件（新增+修改）
 * 这里介绍使用WatchService对本地文件的监控，
 * WatchService是jdk1.7版本引进的，位于nio包下。
 * WatchService是基于本机操作系统实现对文件的监控。
 * WatchService 用来观察被注册了的对象所有的变化和事件
 * Watchable 被观察者，与WatchService结合使用， java.nio.file.Path 已经实现
 * </p>
 * 监听key方法
 * boolean isValid()：监听key是否合法,true:合法，false:不合法；
 * List<WatchEvent<?>> pollEvents()：拉取并删除位于这个监听key的监听事件列表(可能为空)；
 * boolean reset()：监听key复位，复位后，新的pending事件才会再次进入监听,返回true:key合法且复位成功；
 * void cancel()：取消key的注册；
 * Watchable watchable()：返回该key关联的Watchable；
 *
 * @author wangzw
 * @date 2021/3/18 17:43
 */
public class Main {

    public static void main(String[] args) {
        // 设置监听路径
        final String monitorDir = "E:/home/chnsys/fgap/output";
        try {
            //WatchService 实例化
            WatchService watchService = FileSystems.getDefault().newWatchService();
            //利用 Path 实例化监控对象 Watchable
            Path dir = Paths.get(monitorDir);
            //将 Path 注册到 WatchService 中
            //这里监控文件的 创建、修改、删除
            dir.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            while (true) {
                //WatchKey take()：等待下一次的监听结果，没有则等待;
                //WatchKey poll()：获取监听结果，没有则返回null;
                //WatchKey poll(long timeout, TimeUnit unit)：获取监听结果，最多等待指定时间，没有则返回null;
                //void close()：关闭监听服务;
                WatchKey key = watchService.take();
                //拉取并删除位于这个监听key的监听事件列表(可能为空)；
                for (WatchEvent event : key.pollEvents()) {
                    //获取监听事件类型
                    WatchEvent.Kind kind = event.kind();
                    String path = key.watchable().toString() + File.separator + event.context()
                            .toString();
                    if (kind == ENTRY_CREATE) {
                        System.out.println("新增文件：" + path);
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.println("修改文件：" + path);
                    } else if (kind == ENTRY_DELETE) {
                        System.out.println("删除文件：" + path);
                    } else {
                        System.out.println("异常");
                    }
                }
                //处理监听key后(即处理监听事件后)，监听key需要复位，便于下次监听
                key.reset();
            }
        } catch (Exception e) {
            //如果异常需要重新走一遍监听流程
            e.printStackTrace();
        }
    }
}
