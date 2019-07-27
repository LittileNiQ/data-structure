package com.data.structure.practice.leecode;

/**
 * leetcode208 通过
 * Created by Naqi on 2019/7/27.
 */
public class Trie {

    public boolean isEndingChar;
    public char word;
    public Trie[] children = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {
        this.isEndingChar =false;
        this.word=' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char [] array = word.toCharArray();
        Trie node=this;
        for(int i=0;i<array.length;i++){
            int index = array[i] - 'a';
            if (node.children[index] == null) {
                Trie newNode = new Trie();
                node.children[index] = newNode;
            }
            node.word=array[i];
            node = node.children[index];
        }
        node.isEndingChar = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char [] array =word.toCharArray();
        Trie node =this;
        for(int i=0;i<array.length;i++){
            int index = array[i] - 'a';
            if (node.children[index] == null) {
                return false; // 不存在 pattern
            }
            node = node.children[index];
        }
        return node.isEndingChar==true?true:false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char [] array =prefix.toCharArray();
        Trie node =this;
        for(int i=0;i<array.length;i++){
            int index = array[i] - 'a';
            if (node.children[index] == null) {
                return false; // 不存在 pattern
            }
            node = node.children[index];
        }
        return  true ;
    }


}
