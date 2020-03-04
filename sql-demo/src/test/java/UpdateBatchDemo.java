import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 批处理更新测试
 * @author: li baojian
 * @create: 2020/01/19 13:58
 */
public class UpdateBatchDemo {


    @Test
    public void testBatch() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:mysql://192.168.0.197:3306/test?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong&allowPublicKeyRetrieval=true&autoReconnect=true", "root", "root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        String updateSql = "update batch_test set name=? where id=?";
        List<Object[]> params = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            params.add(new Object[]{"name-update" + i, i});
        }
        long start = System.currentTimeMillis();
        jdbcTemplate.batchUpdate(updateSql, params);
//        System.out.println(ints.length);
//        int[] ints1 = jdbcTemplate.batchUpdate(updateSql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                Object[] objects = params.get(i);
//                ps.setString(1, objects[0].toString());
//                ps.setString(2, objects[1].toString());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return params.size();
//            }
//        });
//        System.out.println(ints1.length);

        long end = System.currentTimeMillis();
        System.out.println("一共耗时" + (end - start) + "毫秒");
    }
}
