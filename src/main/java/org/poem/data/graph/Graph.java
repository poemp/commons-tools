package org.poem.data.graph;

/**
 * 图的临界矩阵存储方式
 * @param <T>
 */
public class Graph<T> {

    private static final int MAX_SIZE = 100;
    /**
     * 定点的数量
     */
    private int topCount;
    /**
     * 边的数量
     */
    private int sideCount;

    /**
     * 顶点的信息
     */
    private Object[] data = new Object[MAX_SIZE];

    /**
     * 临界矩阵
     */
    private int[][] edges = new int[MAX_SIZE][MAX_SIZE];


    public int getTopCount() {
        return topCount;
    }

    public void setTopCount(int topCount) {
        this.topCount = topCount;
    }

    public int getSideCount() {
        return sideCount;
    }

    public void setSideCount(int sideCount) {
        this.sideCount = sideCount;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public int[][] getEdges() {
        return edges;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }

    public static void main(String[] args) {

    }
}
