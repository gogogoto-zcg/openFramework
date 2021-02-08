package com.zcg.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 周春桂
 * @Date 2020/10/23 11:49
 * @Desciption 测试内存溢出并做dump分析
 **/
public class memoryOutDemo {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
