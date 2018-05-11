package org.poem.data.tree.core;

import org.poem.data.tree.BTree;
import org.poem.utils.collection.Lists;

import java.util.List;

/**
 * B树遍历
 */
public class BTreeOrder {

    /**
     * 访问节点
     *
     * @param bTree 树节点
     * @param <T>   数据类型
     * @return 节点中保存的数据
     */
    private static <T extends Comparable<T>> T visitNode(BTree<T> bTree) {
        return bTree.getDate();
    }


    /**
     * 先根遍历
     * 算法：
     * 1、访问根节点
     * 2、遍历左子树
     * 3、遍历右子树
     *
     * @param bTreeOrder 树
     * @param <T>        类型
     * @return 栈
     */
    public static <T extends Comparable<T>> List<T> preOrder(BTree<T> bTreeOrder) {
        List<T> stack = Lists.empty();
        if (bTreeOrder != null) {
            stack.add(visitNode(bTreeOrder));
            stack.addAll(preOrder(bTreeOrder.getLeftNode()));
            stack.addAll(preOrder(bTreeOrder.getRightNode()));
        }
        return stack;
    }

    /**
     * 中根遍历
     * 算法：
     * 1、中根遍历左子树
     * 2、访问根节点
     * 3、中根遍历右子树
     *
     * @param bTreeOrder 树
     * @param <T>   ；类型
     * @return 树栈
     */
    public static <T extends Comparable<T>> List<T> inOrder(BTree<T> bTreeOrder) {
        List<T> stack = Lists.empty();
        if (bTreeOrder != null) {
            stack.addAll(inOrder(bTreeOrder.getLeftNode()));
            stack.add(visitNode(bTreeOrder));
            stack.addAll(inOrder(bTreeOrder.getRightNode()));
        }
        return stack;
    }

    /**
     * 后根遍历
     * 算法：
     * 1、后根遍历左子树
     * 2、后根遍历右子树
     * 3、访问根节点
     *
     * @param bTreeOrder 树
     * @param <T>    类型
     * @return 树栈
     */
    public static <T extends Comparable<T>> List<T> lastOrder(BTree<T> bTreeOrder) {
        List<T> stack = Lists.empty();
        if (bTreeOrder != null) {
            stack.addAll(lastOrder(bTreeOrder.getLeftNode()));
            stack.addAll(lastOrder(bTreeOrder.getRightNode()));
            stack.add(visitNode(bTreeOrder));
        }
        return stack;
    }
    
    /**
     * 使用前根遍历方式获取叶子节点数量
     * @param bTree 树
     * @param <T> 数据类型
     * @return  叶子节点的数目
     */
    public static <T extends Comparable<T>> int countLeaf(BTree<T> bTree){
         int count = 0;
         if(bTree != null){
             //叶子节点 ， 左右子树为空
             if(bTree.getRightNode() == null && bTree.getLeftNode() == null){
                 count = count + 1;
             }
             else{
                 count += countLeaf(bTree.getLeftNode());
                 count += countLeaf(bTree.getRightNode());
             }
         }
         return count;
    }

    /**
     * 统计树的深度
     * @param bTree 需要统计的树
     * @param <T> 数据类型 extend Comparable
     * @return
     */
    public static <T extends Comparable<T>> int countDepth(BTree<T> bTree){
        if(bTree != null){
            int leftDepth = countDepth(bTree.getLeftNode());
            int rightDepth = countDepth(bTree.getRightNode());
            int depth = Math.max(leftDepth,rightDepth);
            return depth+1;
        }
        return  0;
    }
}
