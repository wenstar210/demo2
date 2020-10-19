package com.dbservice;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBservice {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf8&userSSL=false&serverTimezone=GMT%2B8";
    private String username = "root";
    private String password = "Wyd210213";

    private Connection conn = null;
    private Statement smt = null;
    private ResultSet rs = null;
    private static DBservice dbservice = null;

    private DBservice() {
    }

    public static DBservice getinstance() {
        if (null == dbservice)
            dbservice = new DBservice();
        return dbservice;
    }

    public void getconn() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 执行insert/update/delete语句
    public int updateSql(String sql) {
        int result = -100;
        if (this.conn == null)
            this.getconn();

        try {
            this.smt = this.conn.createStatement();
            result = this.smt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // 执行查询语句
    public List<Map<String, Object>> selectSql(String sql) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (null == this.conn)
            this.getconn();

        try {
            this.smt = this.conn.createStatement();
            this.rs = this.smt.executeQuery(sql);
            ResultSetMetaData rms = this.rs.getMetaData();

            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= rms.getColumnCount(); i++) {
                    map.put(rms.getColumnName(i),
                            rs.getObject(rms.getColumnName(i)));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        ;

        return list;
    }

    private void close() {
        try {
            if (null != this.rs)
                rs.close();
            if (null != this.smt)
                this.smt.close();
            if (null != this.conn)
                this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
