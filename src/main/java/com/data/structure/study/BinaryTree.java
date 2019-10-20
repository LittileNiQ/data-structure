package com.data.structure.study;

import java.util.Stack;

/**
 * 二叉树创建和遍历
 * 有关树的高度问题：
 * https://blog.csdn.net/qq_36667170/article/details/84142019
 * Created by Naq on 2019/3/29.
 */
public class BinaryTree {

    Node root;

    // 得到树的深度
    public Integer getHeight() {
        return getHeight(root);
    }

    private Integer getHeight(Node node) {

        if (node == null)
//            return -1;
            return 0;
        else {
            int left = getHeight(node.getLeftChildTree());
            int right = getHeight(node.getRightChildTree());
            // 左子树 右子树最深的，再加上父节点本身深度1
            if(left>right){
                return left + 1;
            }
            else{
                return right+1;
            }
        }
    }

    // 得到节点数量
    public Integer getSize() {
        return getSize(root);
    }

    ;

    private Integer getSize(Node node) {
        if (node == null)
            return 0;
        else {
            int leftSize = getSize(node.getLeftChildTree());
            int rightSize = getSize(node.getRightChildTree());
            return leftSize + rightSize + 1;
        }
    }

    // 前序遍历,迭代
    public void preOrder(Node node) {
        if (node == null)
            return;
        else {
            System.out.println("preOrder" + node.getData());
            preOrder(node.getLeftChildTree());
            preOrder(node.getRightChildTree());
        }
    }

    // 中序遍历,迭代
    public void midOrder(Node node) {
        if (node == null)
            return;
        else {
            midOrder(node.getLeftChildTree());
            System.out.println("midOrder" + node.getData());
            midOrder(node.getRightChildTree());
        }
    }

    // 后序遍历,迭代
    public void proOrder(Node node) {
        if (node == null)
            return;
        else {
            proOrder(node.getLeftChildTree());
            proOrder(node.getRightChildTree());
            System.out.println("proOrder" + node.getData());
        }
    }

    // 前序遍历，非迭代,利用栈，要遍历一个节点，就先把它压入，再弹出，输出数据，把此节点的右节点压入，再把左节点压入
    public void nonRecOrder(Node node) {
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println("nonRecOrder:" + pop.getData());
            if (pop.getRightChildTree() != null)// 不要把空节点push栈
                stack.push(pop.getRightChildTree());
            if (pop.getLeftChildTree() != null)
                stack.push(pop.getLeftChildTree());
        }
    }

    /**
     * A
     * B		C
     *     D		E		F
     */
    public BinaryTree() {
        root = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        nodeB.setLeftChildTree(nodeD);
        nodeB.setRightChildTree(nodeE);
        nodeC.setRightChildTree(nodeF);
        root.setLeftChildTree(nodeB);
        root.setRightChildTree(nodeC);
    }

    public class Node<T> {
         private Node leftChildTree;
        private Node rightChildTree;
        private T data;


        public Node getLeftChildTree() {
            return leftChildTree;
        }

        public void setLeftChildTree(Node leftChildTree) {
            this.leftChildTree = leftChildTree;
        }

        public Node getRightChildTree() {
            return rightChildTree;
        }

        public void setRightChildTree(Node rightChildTree) {
            this.rightChildTree = rightChildTree;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node(T data) {
            this.data = data;
            leftChildTree = null;
            rightChildTree = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("treeHeight" + tree.getHeight());
        System.out.println("treeSize" + tree.getSize());
        tree.preOrder(tree.root);
        tree.midOrder(tree.root);
        tree.proOrder(tree.root);
        tree.nonRecOrder(tree.root);
    }
}
