package io;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.Buffer;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/4/2 9:46
 */
public class 获取文件字符集 {
    public static void main(String[] args) {
        String str = "GBK";
        File file = new File("/home/chnsys/wj_ums/register_agreement/111.html");
        try (FileInputStream fileInputStream = new FileInputStream(file);
                InputStream inputStream = new BufferedInputStream(fileInputStream)) {
            int p = (inputStream.read() << 8) + inputStream.read();
            switch (p) {
                case 0xefbb:
                    str = "UTF-8";
                    break;
                case 0xfffe:
                    str = "Unicode";
                    break;
                case 0xfeff:
                    str = "UTF-16BE";
                    break;
                case 0x5c75:
                    str = "ANSI|ASCII";
                    break;
                default:
                    str = "GBK";
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
