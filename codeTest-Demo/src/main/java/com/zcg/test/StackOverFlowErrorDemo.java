package com.zcg.test;


/**
 * @Author 周春桂
 * @Date 2020/10/23 14:02
 * @Desciption
 **/
public class StackOverFlowErrorDemo {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackOverFlowErrorDemo oom = new StackOverFlowErrorDemo();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
