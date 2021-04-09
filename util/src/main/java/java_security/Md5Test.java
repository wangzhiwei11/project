package java_security;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/3/29 14:56
 */
public class Md5Test {
    public static void main(String[] args) {
        String md5 = DigestUtils.md5Hex("qwer");
        System.out.println(md5);
    }
}
