package org.poem.data.graph;

import java.util.List;

/**
 * 图的邻接表
 */
public class LinkedGraph<T> {

    /**
     * 邻接表数据
     */
    private List<Node> nodes;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * 表数据
     * @param <T>
     */
    class Node<T>{
        /**
         * 数据
         */
        private T data;

        /**
         * 下一个节点
         */
        private Node<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
