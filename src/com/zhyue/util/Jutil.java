package com.zhyue.util;

import java.sql.*;

public class Jutil {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    static {
        user = "root";
        password = "root";
        url = "jdbc:mysql://localhost:3306/blank";
        driver = "com.mysql.jdbc.Driver";
    }

    /**
     * 和数据库建立联系
     */
    public Connection getConnection(){
        try {
            //加载驱动
            Class.forName(driver);
            //和数据库建立连接
            con = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 释放资源
     */
    public void closeAll(ResultSet rs, PreparedStatement ps,Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }

    }
}
