package TestJooq;

import com.zcg.jooq.learn.codegen.tables.records.TUserRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.zcg.jooq.learn.codegen.tables.TUser.T_USER;

/**
 * @Author 周春桂
 * @Date 2020/10/13 16:59
 * @Desciption
 **/
public class TestJooqDemo {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/learn-jooq?serverTimezone=GMT%2B8";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
        // 获取 JDBC 链接
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            // 获取 jOOQ 执行器
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);

            // fetch方法可以返回一个结果集对象 Result
            // jOOQ的Result对象实现了List接口，可以直接当做集合使用
            Result<Record> recordResult = dslContext.select().from(T_USER).fetch();
            recordResult.forEach(record -> {
                Integer id = record.getValue(T_USER.USER_ID);
                String username = record.getValue(T_USER.USER_NAME);
                System.out.println("fetch Record     id: " + id + " , username: " + username);
            });

            // 通过 Record.into 方法可以将默认Record对象，转换为表的Record对象，例如S1UserRecord
            // Result 接口也定义了into方法，可以将整个结果集转换为指定表Record的结果集
            // 通过 S1UserRecord 可以通过get方法直接获得表对象
            // 所有表的XXXRecord对象都是实现了 Record 对象的子类
            Result<TUserRecord> userRecordResult = recordResult.into(T_USER);
            userRecordResult.forEach(record -> {
                Integer id = record.getUserId();
                String username = record.getUserName();
                System.out.println("into S1UserRecord   id: " + id + " , username: " + username);
            });

            // fetchInto方法可以可以传入任意class类型，或者表常量
            // 会直接返回任意class类型的List集合，或者指定表Record的结果集对象
            List<TUserRecord> fetchIntoClassResultList = dslContext.select().from(T_USER).fetchInto(TUserRecord.class);
            Result<TUserRecord> fetchIntoTableResultList = dslContext.select().from(T_USER).fetchInto(T_USER);

            System.out.println("fetchIntoClassResultList: \n" + fetchIntoClassResultList.toString());
            System.out.println("fetchIntoTableResultList: \n" + fetchIntoTableResultList.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
