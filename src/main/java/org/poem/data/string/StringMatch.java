package org.poem.data.string;

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

    public static StringMatch getInstance(){
        return new StringMatch();
    }

    public StringMatch dest(String dest){
        this.dest = dest;
        return this;
    }

    public StringMatch match(String mach){
        this.mach = mach;
        return this;
    }

    /**
     * 普通匹配
     * @return
     */
    public int normalMatch(){
        if(StringUtils.isEmpty(dest) || StringUtils.isEmpty(mach)){
            return -1;
        }
        char[] dest = this.dest.toCharArray();
        char[] match = this.mach.toCharArray();
        for(int i = 0 ; i < dest.length ;i++){
            boolean m = true;
            for(int j = 0 ; j < match.length;j++){
                //移动到了最后都还没有匹配上
                if(i + match.length >= dest.length){
                    m = false;
                    break;
                }
                if(dest[i+j] != match[j]){
                    m = false;
                    break;
                }
            }
            if(m){
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用KMP匹配算法
     * 该算法只需要扫描一遍原始字符串
     * @return
     */
    public int KMPMatch(){
        if(StringUtils.isEmpty(dest) || StringUtils.isEmpty(mach)){
            return -1;
        }
        char[] dest = this.dest.toCharArray();
        char[] match = this.mach.toCharArray();
        int maIndex = 0;
        for (int i = 0 ; i < dest.length;){
            boolean m = true;
            for(int j = maIndex ; i < match.length; j++){
                if(i + j >= dest.length){
                    return -1;
                }
                if(dest[i + j] != match[j]){
                    m = false;
                    maIndex = j;
                    i = i + j -1 ;
                    break;
                }
            }
            if (m){
                return  i;
            }
        }
        return -1;
    }
}
