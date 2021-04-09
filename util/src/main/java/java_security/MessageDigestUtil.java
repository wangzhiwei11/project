package java_security;

import com.sun.xml.internal.ws.util.StreamUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 消息摘要
 * </p>
 *
 * @author wangzw
 * @date 2021/3/17 16:51
 */
public class MessageDigestUtil {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "123";
        byte[] bytes = str.getBytes();
        String md5Hex = DigestUtils.md5Hex(bytes);
        System.out.println(md5Hex);
        System.out.println("===========");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(bytes);
        byte[] digest = md5.digest();
        String encodeHexString = Hex.encodeHexString(digest);
        System.out.println(encodeHexString);

    }
}
