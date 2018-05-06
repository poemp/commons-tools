package org.poem.data.string;

import org.poem.lang.exception.ParameterException;
import org.poem.utils.string.StringUtils;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 串的实现
 */
public class SeqString {
    /**
     * 字符串的大小
     */
    private static final Integer MAX_SIZE = 10;

    /**
     * 字符串
     */
    private char[] chars = new char[MAX_SIZE];

    /**
     * 串的长度
     */
    private int length = 0;


    public SeqString() {
        this.length = 0;
        this.chars = new char[MAX_SIZE];
    }

    /**
     * constructor method
     * @param chars
     */
    public SeqString(char[] chars){
        char[] newChar = Optional.of(chars).orElseGet(new Supplier<char[]>() {
            @Override
            public char[] get() {
                return new char[MAX_SIZE];
            }
        });
        this.length = newChar.length;
        try {
            this.chars = newChar.length > MAX_SIZE ? substring(newChar,0, MAX_SIZE): newChar;
        } catch (ParameterException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符的截取
     * @param dest 截取的字符串
     * @param start 开始截取位置
     * @param end 结束截取的位置
     * @return
     */
    private static char[] substring(char[] dest, int start, int end) throws ParameterException {
        if(start > end){
            throw new ParameterException("start cant\'n  more than end");
        }
        if(start >= MAX_SIZE){
            return dest;
        }
        if(end >= MAX_SIZE){
            return dest;
        }
        char[] newChar = new char[end - start];
        int j = 0;
        for(int i= start; i<= end ; i++){
            newChar[j++] = dest[i];
        }
        return newChar;
    }

    /**
     *
     * @return
     */
    public char[] getChars() {
        return chars;
    }

    /**
     *
     * @param chars
     */
    public void setChars(char[] chars) {
        this.chars = chars;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 初始化
     * @param chars
     */
    public void initSeqString(char[] chars){
        this.chars = chars;
        this.length = Optional.of(chars).orElseGet(new Supplier<char[]>() {
            @Override
            public char[] get() {
                return new char[MAX_SIZE];
            }
        }).length;
    }

    /**
     * 打印
     */
    public void  outString(){
        System.out.print(this.chars);
    }

    /**
     * 串的长度
     * @return
     */
    public int stringLength(){
        return  this
                .length;
    }

    /**
     * 串的链接
     * @param s
     * @param t
     */
    public void strngCat(SeqString s, SeqString t){
        SeqString newS = Optional.of(s).orElseGet(new Supplier<SeqString>() {
            @Override
            public SeqString get() {
                return new SeqString();
            }
        });
        SeqString newT = Optional.of(t).orElseGet(new Supplier<SeqString>() {
            @Override
            public SeqString get() {
                return new SeqString();
            }
        });
        char[] dest = newS.getChars();
        char[] resource = newT.getChars();
        if(dest.length + resource.length >= MAX_SIZE){
            int len = MAX_SIZE - dest.length;
            for (int i= 0 ; i<len; i++){
                dest[i + newS.length] = resource[i];
            }
            newS.setChars(dest);
            newS.setLength(MAX_SIZE);
        }else {
            for (int i = 0; i < resource.length; i++) {
                dest[i + newS.length] = resource[i];
            }
            newS.setChars(dest);
            newS.setLength(dest.length);
        }
    }

    /**
     * 插入位置
     * @param seqString 被插入的数据
     * @param pos 插入的位置 从0开始
     * @param seq 需要插入的串
     */
    public void insertSeqString(SeqString seqString , int pos , SeqString seq){
        //如果seq为空
        if(seqString == null || pos < 0 || seqString.length < pos){
            System.out.print("参数错误");
            return;
        }
        if(seqString.length + seq.length <= MAX_SIZE){
            //先移动原来的字符串,腾出位置存放需要插如的串
            for(int i= 0 ; i < seqString.length; i++){
                seqString.chars[i + seq.length + pos] = seqString.chars[i + pos];
            }
            //位置出来了，现在开始方
            for(int i = 0 ; i < seqString.length; i++){
                seqString.chars[i + pos] = seq.chars[i];
            }
            seqString.length += seq.length;
        }else{
            //先移动原来的字符串,腾出位置存放需要插如的串
            int lenth = MAX_SIZE - seqString.length;
            for(int i = 0 ; i<lenth ; i++){
                seqString.chars[pos + i + lenth] = seqString.chars[pos + i];
            }
            //位置出来了，现在开始方
            for(int i = 0 ; i <lenth ;i++){
                seqString.chars[pos + i] = seq.chars[i];
            }
            seqString.length = MAX_SIZE;
        }
        seqString.outString();
    }

    /**
     * 删除字符串
     * @param seqString 需要删除的字符
     * @param pos 开始删除的位子
     * @param length 删除的长度
     */
    public void deleteString(SeqString seqString , int pos , int length) throws ParameterException {
        if(seqString == null){
            return;
        }
        if(pos < 0 || pos > MAX_SIZE){
            throw new ParameterException("parameter error.");
        }
        int len = pos + length > MAX_SIZE ? MAX_SIZE - pos : length;
        for(int i =0 ;i < len ; i++){
            seqString.chars[pos + i] = seqString.chars[pos + i + len];
        }
        seqString.length -= len;
    }
}
