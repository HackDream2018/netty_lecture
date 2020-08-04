package utils;

import java.util.Random;

/**
 * @Description TODO
 * @Author Ming
 * @Date 2020/2/27 10:40 下午
 */
public class RedeenCodeUtil {

    /**
     * 自定义进制（选择你想要的进制数，不能重复且最好不要0、1这些容易混淆的字符）
     */
    private static final char[] r = new char[]{'C', 'h', 'W', 'j', 'E', 'b', '8', 'S', 'Q', 'm', '2', 'D', 'r', 'Z', 'X', '9', 'a', 'G', '7', 'f', 'w', 'P', 't', 'K', 'e', '3', 'B', 'M', 'c', 'J', 'v', '5', 'y', 'U', 'q', 'F', 'u', 'R', '4', 'V', 'p', 'T', 'Y', 'd', 'N', '6', 'z', 'g', 'n', 'A', 's'};

    /**
     * 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的）
     */
    private static final char b = 'H';

    /**
     * 进制长度
     */
    private static final int binLen = r.length;

    /**
     * 邀请码长度
     */
    private static final int s = 10;

    /**
     * 根据ID生成随机码
     *
     * @param id ID
     * @return 随机码
     */
    public static String id2code(long id) {
        char[] buf = new char[32];
        int charPos = 32;

        while ((id / binLen) > 0) {
            int ind = (int) (id % binLen);
            buf[--charPos] = r[ind];
            id /= binLen;
        }
        buf[--charPos] = r[(int) (id % binLen)];
        String str = new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if (str.length() < s) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            Random rnd = new Random();
            for (int i = 1; i < s - str.length(); i++) {
                sb.append(r[rnd.nextInt(binLen)]);
            }
            str += sb.toString();
        }
        return str;
    }

    /**
     * 根据随机码生成ID
     *
     * @param code/随机码
     * @return ID
     */
    public static long code2id(String code) {
        char chs[] = code.toCharArray();
        long res = 0L;
        for (int i = 0; i < chs.length; i++) {
            int ind = 0;
            for (int j = 0; j < binLen; j++) {
                if (chs[i] == r[j]) {
                    ind = j;
                    break;
                }
            }
            if (chs[i] == b) {
                break;
            }
            if (i > 0) {
                res = res * binLen + ind;
            } else {
                res = ind;
            }
        }
        return res;
    }
}
