package org.poem.data.string;

import org.poem.lang.exception.ParameterException;
import org.poem.utils.logger.LoggerUtils;
import org.poem.utils.string.StringUtils;

/**
 * 字符串匹配
 */
public class StringMatch {

   
    /**
     * 目标串
     */
    private String dest;

    /**
     * 模式串
     */
    private String mach;

    /**
     * self
     */
    private StringMatch stringMatch;


    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getMach() {
        return mach;
    }

    public void setMach(String mach) {
        this.mach = mach;
    }

    public static StringMatch getInstance() {
        return new StringMatch();
    }

    public StringMatch dest(String dest) {
        this.dest = dest;
        return this;
    }

    public StringMatch match(String mach) {
        this.mach = mach;
        return this;
    }

    /**
     * 普通匹配
     *
     * @return
     */
    public int normalMatch() {
        if (StringUtils.isEmpty(dest) || StringUtils.isEmpty(mach)) {
            return -1;
        }
        char[] dest = this.dest.toCharArray();
        char[] match = this.mach.toCharArray();
        for (int i = 0; i < dest.length; i++) {
            boolean m = true;
            for (int j = 0; j < match.length; j++) {
                //移动到了最后都还没有匹配上
                if (i + match.length >= dest.length) {
                    m = false;
                    break;
                }
                if (dest[i + j] != match[j]) {
                    m = false;
                    break;
                }
            }
            if (m) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 截取字符
     *
     * @param resource 需要截取的字符
     * @param start    开始位置
     * @param end      结束位置
     * @return 截取字符串
     */
    private static char[] substring(char[] resource, int start, int end) throws ParameterException {
        if (null == resource || start < 0 || start > resource.length || end < 0 || end > resource.length || start > end) {
            LoggerUtils.warn("resource:" + (resource == null ? new char[0] : resource) + "  start:" + start + " end:" + end);
            throw new ParameterException("参数错误!");
        }
        char[] newChar = new char[end - start];
        for (int i = 0; i < end - start; i++) {
            newChar[i] = resource[start + i];
        }
        return newChar;
    }

    /**
     * 打印字符串
     *
     * @param chars
     */
    private static String printArray(char[] chars) {
        if (chars != null && chars.length > 0) {
            return new String(chars);
        }
        return "";
    }

    /**
     * 下一个位置 移动的距离
     *
     * @param dest         原始字符串
     * @param match        匹配字符串
     * @param currentIndex 当前匹配的字符串位置
     * @param matchIndex   匹配的长度
     * @return 移动的位置
     */
    private static int next(char[] dest, char[] match, int currentIndex, int matchIndex) throws ParameterException {
        char[] newMatch = substring(match, 0, matchIndex);
        for (int i = currentIndex; i < dest.length; i++) {
            boolean mat = true;
            for (int j = 0; j < newMatch.length; j++) {
                if (dest[i + j] != newMatch[j]) {
                    mat = false;
                    break;
                }
            }
            if (mat) {
                System.out.println("匹配字符位置是：" + printArray(substring(dest, 0, i + matchIndex )) + " >>>  " + (i + matchIndex ) + "  匹配字符串已匹配长度是：" + printArray(substring(match, 0, matchIndex)) + " >>>  " + matchIndex+"\n\n");
                return i + 1;
            }
        }
        return 1;
    }

    /**
     * 使用KMP匹配算法
     * 该算法只需要扫描一遍原始字符串
     *
     * @return
     */
    public int KMPMatch() throws ParameterException {
        if (StringUtils.isEmpty(dest) || StringUtils.isEmpty(mach)) {
            return -1;
        }
        char[] dest = this.dest.toCharArray();
        char[] match = this.mach.toCharArray();
        int maIndex = 0;
        for (int i = 0; i < dest.length; ) {
            boolean m = true;//是否匹配
            for (int j = maIndex; i < match.length; j++) {
                //文字结束还没有匹配完，匹配失败
                if (i + j >= dest.length) {
                    return -1;
                }
                //没有匹配，则计算需要向后移动的距离
                if (dest[i + j] != match[j]) {
                    m = false;
                    maIndex = next(dest, match, i + 1, j);
                    System.err.println("向后移动距离是：" + (i + maIndex) + "\t" + j + "\n");
                    i = i + maIndex - 1;
                    break;
                }
            }
            if (m) {
                return i;
            }
        }
        return -1;
    }
}
