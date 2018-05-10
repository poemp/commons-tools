package org.poem.data.stack;

import java.util.Arrays;

/**
 * 栈对象
 */
public class Stack<T> {

    /**
     * 默认数据列表大小
     */
    private static final int INITIAL_CAPACITY = 10;

    /**
     * 自增长因子
     */
    private static final Float GROW_MULTIPLE = 0.618F;

    /**
     * 整个结构中可以保存的数据的个数
     * 会根据存入的数据多少调整大小
     */
    private int elementCount;

    /**
     * 存储的数据
     */
    private Object[] elements;

    /**
     * 当前定指针
     */
    private int count = 0;
    /**
     * 空的列表
     */
    private Stack() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.elementCount = INITIAL_CAPACITY;
        this.count = 0;
    }

    /**
     * 数据获取
     *
     * @param capacity
     */
    private Stack(int capacity) {
        if (capacity < 0) {
            throw new ArrayIndexOutOfBoundsException(capacity);
        }
        this.elementCount = capacity;
        this.elements = new Object[capacity];
        this.count = 0;
    }

    /**
     * 返回一个空的数据
     *
     * @return
     */
    public static <T> Stack<T> emptyStack() {
        return new Stack<T>();
    }

    /**
     * 初始化一个空的栈
     *
     * @param capacity
     * @return
     */
    public static <T> Stack<T> initStack(int capacity) {
        return new Stack<T>(capacity);
    }

    /**
     * 增长因子
     *
     * @return
     */
    private int growFactor() {
        return Math.round(this.elementCount * GROW_MULTIPLE);
    }

    /**
     * 插入数据
     *
     * @param element
     * @return
     */
    public synchronized T push(T element) {
        groupHelper(this.count + 1);
        this.elements[this.count ++ ] = element;
        return element;
    }

     /**
     * 把一个栈的数据放入到另外一个栈中
     * @param stack 栈
     * @return 放入另外一个栈
     */
    public synchronized Stack<T>  push(Stack<T> stack){
        while (!stack.empty()){
            this.push(stack.pop());
        }
        return this;
    }
    
    /**
     * 获取第一个元素
     *
     * @return 获取第一个元素
     */
    @SuppressWarnings("unchecked")
    public synchronized T getTop() {
        if (this.elements.length == 0) {
            throw new RuntimeException("empty stack.");
        }
        return (T) this.elements[this.count - 1];
    }

    /**
     * 出栈
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public synchronized T pop() {
        T data = getTop();
        //clear last element
        this.elements[this.count -- ] = null;
        return data;
    }

    /**
     * 是否为空
     *
     * @return true 为空 false 不为空
     */
    public boolean empty() {
        return this.count == 0;
    }
    
    /**
     * 转化为列表
     *
     * @return 返回列表
     */
    @SuppressWarnings("unchecked")
    public List<T> toList() {
        List<T> tList = Lists.empty();
        int count = this.count - 1;
        do {
            tList.add((T) this.elements[count--]);
        } while (count >= 0);
        return tList;
    }


    /**
     * 增长验证
     * 如果超出了当前的数据个数，则需要扩容
     *
     * @param mimiCapacity 增长数据
     */
    private void groupHelper(int mimiCapacity) {
        if (this.elementCount < mimiCapacity) {
            group();
        }
    }

    /**
     * 自增长
     */
    private void group() {
        int oldCapacity = this.elementCount;
        int newCapacity = oldCapacity + growFactor();
        this.elements = Arrays.copyOf(this.elements, newCapacity);
        this.elementCount = newCapacity;
    }
}
