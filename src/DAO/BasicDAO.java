package DAO;

import Utils.APDB_utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {

    private QueryRunner qr = new QueryRunner();
    private APDB_utils apdbUtils =new APDB_utils();
    public int update(String sql, Object... parameters) {
        Connection conn = apdbUtils.getConnection();
        try {
            int row = qr.update(conn, sql, parameters);
            return row;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            apdbUtils.close(null, null, conn);
        }
    }

    public List<T> queryMulti(String sql, Class<T> cla, Object... parameters) {
        Connection conn = apdbUtils.getConnection();
        try {
            List<T> list = qr.query(conn, sql, new BeanListHandler<T>(cla),parameters);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            apdbUtils.close(null, null, conn);
        }
    }

    public T queryRow(String sql, Class<T> cla, Object... parameters) {
        Connection conn = apdbUtils.getConnection();
        try {
            T obj = qr.query(conn, sql, new BeanHandler<T>(cla), parameters);
            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            apdbUtils.close(null, null, conn);
        }
    }
    public Object queryOne(String sql,Object... parameters){
        Connection conn = apdbUtils.getConnection();
        try {
            Object obj = qr.query(conn, sql, new ScalarHandler<>(), parameters);
            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            apdbUtils.close(null, null, conn);
        }
    }
}
