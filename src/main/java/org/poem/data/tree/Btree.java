package org.poem.data.tree;

/**
 * 树
 * @param <T>
 */
public class Btree<T> {

    /**
     * 左边树
     */
    private Btree<T> leftNode;

    /**
     * 数据
     */
    private T date;

    /**
     * 右边数
     */
    private Btree<T> rightNode;

    public Btree<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Btree<T> leftNode) {
        this.leftNode = leftNode;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public Btree<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Btree<T> rightNode) {
        this.rightNode = rightNode;
    }


}
