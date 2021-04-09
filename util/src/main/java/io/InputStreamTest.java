package io;

import org.springframework.util.Assert;

import java.io.*;

/**
 * <p>
 * 测试io流
 * </p>
 *
 * @author wangzw
 * @date 2021/3/22 15:39
 */
public class InputStreamTest {
    /**
     * 行结束符字节
     */
    public static final byte LINE_SEPARATOR_BYTE = '\n';

    public static void main(String[] args) throws IOException {
        try (Writer writer = new FileWriter("util\\test.txt");InputStream is = new FileInputStream(
                "util\\test.txt")) {
            writer.write("hello world\nwangzw\n");
            String result1 = getContextToLineSeparator(is);
            System.out.println(result1);
            String result2 = getContextToLineSeparator(is);
            System.out.println(result2);
        }
    }

    //    src：要复制的数组(源数组)
    //    srcPos：复制源数组的起始位置
    //    dest：目标数组
    //    destPos：目标数组的下标位置
    //    length：要复制的长度
    public static String getContextToLineSeparator(InputStream is) throws IOException {
        Assert.notNull(is, "输入流对象不能为空...");
        byte[] buff = new byte[1024 * 8];
        byte b;
        for (int i = 0;;i++) {
            b = (byte) is.read();
            if (b == LINE_SEPARATOR_BYTE) {
                byte[] result = new byte[i + 1];
                System.arraycopy(buff, 0, result, 0, i + 1);
                return new String(result);
            } else {
                buff[i] = b;
            }
        }
    }
}
