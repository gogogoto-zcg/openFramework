package TestJooq;

import com.zcg.jooq.learn.codegen.tables.records.TUserRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.zcg.jooq.learn.codegen.tables.TUser.T_USER;

/**
 * @Author 周春桂
 * @Date 2020/10/13 17:16
 * @Desciption JOOQ CRUD
 **/
public class TestJooq {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/learn-jooq?serverTimezone=GMT%2B8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    @Test
    public void testQuery(){
        // 获取 JDBC 链接
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
            List<TUserRecord> userRecords = dslContext.selectFrom(T_USER)
                    .where(DSL.field(T_USER.USER_ID).eq(2))
                    .fetchInto(TUserRecord.class);
            Assert.assertEquals(1,userRecords.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testQuery1(){
//        // 获取 JDBC 链接
//        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
//            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
//            List<TUserRecord> userRecords = dslContext
//                    .select()   //查询字段
//                    .from()     //查询表1
//                    .join()     //连接表
//                    .on()       //连接条件
//                    .where()    //where过滤
//                    .groupBy()  //分组
//                    .having()   //分组过滤
//                    .orderBy()  //排序
//                    .limit()    //限制条数
//                    .fetchInto(TUserRecord.class);
//            Assert.assertEquals(2,userRecords.size());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testInsert(){
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
            InsertValuesStep1<TUserRecord, String> values = dslContext.insertInto(T_USER)
                    .columns(T_USER.USER_NAME)
                    .values("zcg");
            Assert.assertEquals(1, values.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
            UpdateConditionStep<TUserRecord> updateOperation = dslContext.update(T_USER)
                    .set(T_USER.USER_NAME, "UPDATE_NAME")
                    .where(T_USER.USER_ID.eq(3));
            Assert.assertEquals(1,updateOperation.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
            DeleteConditionStep<TUserRecord> deleteOperation = dslContext.delete(T_USER).where(T_USER.USER_ID.eq(3));
            Assert.assertEquals(1,deleteOperation.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
