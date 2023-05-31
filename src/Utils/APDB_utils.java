package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class APDB_utils {
    private static DataSource db;


    //初始化
    {
        Properties properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(is);
            is.close();
            db = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            System.out.println("找不到druid.properties");
        } catch (Exception e) {
            System.out.println("連線失敗");
        }
    }


    public Connection getConnection() {
        try {
            return db.getConnection();
        } catch (SQLException e) {
            System.out.println("連線失敗");
            throw new RuntimeException(e);
        }
    }

    public void close(ResultSet resultSet, Statement statement, Connection conn) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}






