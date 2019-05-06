package com.data.structure.study;

import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by Naq on 2019/3/7.
 */
public class App {

    private String name;

    private Integer age;

    public App() {
    }

    public App(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class TreeSetTest {
    public static void main(String[] agrs) {
        customSort();
    }

    //自定义排序顺序：升序
    public static void customSort() {
        TreeSet<App> treeSet = new TreeSet<App>();
        Stack s = new Stack();

        //排序对象：
        App app1 = new App("hello", 10);
        App app2 = new App("world", 20);
        App app3 = new App("my", 15);
        App app4 = new App("name", 25);

        //添加到集合：
        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app4);
        System.out.println("TreeSet集合顺序为：" + treeSet);
    }
}