package 文件监听.common_io;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author wangzw
 * @date 2021/3/18 17:21
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // 设置监听路径
        final String monitorDir = "E:/home/chnsys/fgap/output";
        // 设置轮询间隔
        final long interval = TimeUnit.SECONDS.toMillis(1);
        //创建过滤器
        IOFileFilter directory = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        //不关注文件类型
        //        IOFileFilter file = FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
        //                HiddenFileFilter.VISIBLE);
        //只监听规定后缀文件
        IOFileFilter file = FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
                FileFilterUtils.suffixFileFilter(".txt"));
        IOFileFilter filter = FileFilterUtils.or(directory, file);
        //装配过滤器
        FileAlterationObserver observer = new FileAlterationObserver(new File(monitorDir), filter);
        //向监听者添加监听器
        observer.addListener(new FileListener());
        //返回监听者
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        //开始监听
        monitor.start();
    }
}
