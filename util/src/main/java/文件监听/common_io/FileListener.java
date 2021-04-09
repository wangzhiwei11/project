package 文件监听.common_io;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * <p>
 * 文件变化监听器
 * 在Apache的Commons-IO中有关于文件的监控功能的代码. 文件监控的原理如下：
 * 由文件监控类FileAlterationMonitor中的线程不停的扫描文件观察器FileAlterationListenerAdaptor
 * 如果有文件的变化，则根据相关的文件比较器，判断文件时新增，还是删除，还是更改。（默认为1000毫秒执行一次扫描）
 * </p>
 *
 * @author wangzw
 * @date 2021/3/18 16:56
 */
public class FileListener extends FileAlterationListenerAdaptor {

    @Override
    public void onStart(FileAlterationObserver observer) {
        System.out.println("开始轮询");
    }

    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("创建目录：" + directory.getPath());
    }

    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("修改目录：" + directory.getPath());
    }

    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("删除目录：" + directory.getPath());
    }

    @Override
    public void onFileCreate(File file) {
        System.out.println("创建文件：" + file.getPath());
    }

    @Override
    public void onFileChange(File file) {
        System.out.println("修改文件：" + file.getPath());
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("删除文件：" + file.getPath());
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        System.out.println("轮询结束");
    }
}
