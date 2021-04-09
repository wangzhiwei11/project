package 算法题;

import java.util.Scanner;

/**
 * <p>
 * 题目：给定一个字符串，返回最长元音字母字串长度
 * 测试举例：
 * 输入为：asdbuiodea
 * 输出为3 因为uio三个元音字姆是最长的
 * </p>
 *
 * @author wangzw
 * @date 2021/4/8 16:47
 */
public class 找元音 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入一串字符串：");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String str = "aeiou";
            String[] str1 = line.split("");
            int[] ints = new int[line.length()];
            for (int i = 0;i < str1.length;i++) {
                if (str.contains(str1[i])) {
                    ints[i] = 1;
                }
            }
            int max = 0;
            int sum = 0;
            for (int j = 0;j < ints.length;j++) {
                if (ints[j] == 1) {
                    sum++;
                    if (sum > max) {
                        max = sum;
                    }
                } else {
                    sum = 0;
                }
            }
            System.out.println(max);
        }
    }
}
