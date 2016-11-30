package com.yvwxw.saifu.ji.ex.hbmst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ji.Saifu on 2016/11/24.
 */
public class DBConnector {

    private final String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String DBUSER = "cookie";
    private final String DBPWD = "Cookie0921";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void execSQL(String sql) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != conn) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
