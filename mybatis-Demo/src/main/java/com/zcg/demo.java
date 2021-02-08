package com.zcg;

import com.zcg.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 周春桂
 * @Date 2020/10/19 17:19
 * @Desciption
 **/
public class demo {
    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    /**
     * mapper接口调用查询
     */
    private static void test2() {

    }

    /**
     * 原生mybaits执行
     * @throws IOException
     */
    private static void test1() throws IOException {
        String resource = "mybaits-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession()){
            User user = (User)session.selectOne("com.zcg.pojo.User.selectById", 1);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
