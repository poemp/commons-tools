package org.poem.data.tree;

/**
 * 树
 * @param <T>
 */
public class BTree<T> {

    /**
     * 左边树
     */
    private BTree<T> leftNode;

    /**
     * 数据
     */
    private T date;

    /**
     * 右边数
     */
    private BTree<T> rightNode;

    public BTree<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BTree<T> leftNode) {
        this.leftNode = leftNode;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public BTree<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BTree<T> rightNode) {
        this.rightNode = rightNode;
    }


}
