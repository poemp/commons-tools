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
     * 空的列表
     */
    private  Stack() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.elementCount = INITIAL_CAPACITY;
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
    }

    /**
     * 返回一个空的数据
     *
     * @return
     */
    public static Stack emptyStack() {
        return new Stack();
    }

    /**
     * 初始化一个空的栈
     *
     * @param capacity
     * @return
     */
    public static Stack initStack(int capacity) {
        return new Stack(capacity);
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
        groupHelper(this.elements.length + 1);
        this.elements[this.elements.length + 1] = element;
        return element;
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
        T data = (T) this.elements[this.elements.length - 1];
        return data;
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
        this.elements[this.elements.length - 1] = null;
        return data;
    }

    /**
     * 是否为空
     *
     * @return true 为空 false 不为空
     */
    public boolean empty() {
        return this.elements.length == 0;
    }

    /**
     * 增长验证
     * 如果超出了当前的数据个数，则需要扩容
     *
     * @param mimiCapacity 增长数据
     */
    private void groupHelper(int mimiCapacity) {
        if (this.elementCount > mimiCapacity) {
            group(mimiCapacity);
        }
    }

    /**
     * 自增长
     */
    private void group(int miniCapacity) {
        int oldCapacity = this.elementCount;
        int newCapacity = oldCapacity + growFactor();
        this.elements = Arrays.copyOf(this.elements, newCapacity);
        this.elementCount = newCapacity;
    }
}
