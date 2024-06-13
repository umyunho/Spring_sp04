package com.himedia.sp04.util;

import java.sql.*;

public class DbManager {
    private String driver;
    private String url;
    private String id;
    private String pw;

    DbManager(DBConInfo di){
        driver = di.getDriver();
        url = di.getUrl();
        id = di.getId();
        pw = di.getPw();

    }

    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pw);
        } catch (ClassNotFoundException e) {e.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
        return con;
    }
    public void close(Connection con, PreparedStatement pstmt, ResultSet rs){
        try{
            if(con!=null)con.close();
            if(pstmt!=null)pstmt.close();
            if(rs!=null)rs.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
