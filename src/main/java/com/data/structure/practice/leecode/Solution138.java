//package com.data.structure.practice.leecode;
//
///**
// * Created by Naqi on 2019/9/6.
// */
//public class Solution138 {
//    class Node {
//        public int val;
//        public Node next;
//        public Node random;
//
//        public Node(int val) {}
//
//        public Node(int _val,Node _next,Node _random) {
//            val = _val;
//            next = _next;
//            random = _random;
//        }
//    };
//
//    public Node copyRandomList(Node pHead) {
//        if(pHead==null)
//            return null;
//        Node pCur = pHead;
//        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
//        while(pCur!=null){
//            Node node = new Node(pCur.val);
//            node.next = pCur.next;
//            pCur.next = node;
//            pCur = node.next;
//        }
//        pCur = pHead;
//        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
//        while(pCur!=null){
//            if(pCur.random!=null)
//                pCur.next.random = pCur.random.next;
//            pCur = pCur.next.next;
//        }
//        Node head = pHead.next;
//        Node cur = head;
//        pCur = pHead;
//        //拆分链表
//        while(pCur!=null){
//            pCur.next = pCur.next.next;
//            if(cur.next!=null)
//                cur.next = cur.next.next;
//            cur = cur.next;
//            pCur = pCur.next;
//        }
//        return head;
//    }
//
//    public static void main(String[] args) {
//        Solution138 solution138 =new Solution138();
//        solution138.copyRandomList();
//    }
//}
