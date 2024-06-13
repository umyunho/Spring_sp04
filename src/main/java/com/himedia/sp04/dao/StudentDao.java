package com.himedia.sp04.dao;

import com.himedia.sp04.dto.StudentDto;
import com.himedia.sp04.util.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DbManager db;
    StudentDao( DbManager db){
        this.db = db;
    }

    public void insertStudent(StudentDto std) {
        con = db.getConnection();
        String sql="insert into student(snum, sid, spw, sname, sage, sgender, smajor)"
                + " values(? , ? , ? , ? , ? , ? , ? )";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, std.getsNum());
            pstmt.setString(2, std.getsId());
            pstmt.setString(3, std.getsPw());
            pstmt.setString(4, std.getsName());
            pstmt.setInt(5, std.getsAge());
            pstmt.setString(6, std.getsGender());
            pstmt.setString(7, std.getsMajor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.close(con, pstmt, rs);
        }
    }

    public ArrayList<StudentDto> seleceStudent() {
        ArrayList<StudentDto> list = new ArrayList<StudentDto>();
        String sql="select * from student";
        con = db.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                StudentDto std = new StudentDto(
                        rs.getString("sNum"),
                        rs.getString("sId"),
                        rs.getString("sPw"),
                        rs.getString("sName"),
                        rs.getInt("sAge"),
                        rs.getString("sGender"),
                        rs.getString("sMajor")
                );
                list.add(std);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.close(con, pstmt, rs);
        }
        return list;
    }

}
