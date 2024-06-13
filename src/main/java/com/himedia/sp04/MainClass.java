package com.himedia.sp04;

import com.himedia.sp04.dao.StudentDao;
import com.himedia.sp04.dto.StudentDto;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        String[] sNums={"A1","A2","A3","A4","A5","A6","A7","A8","A9"};
        String[] sIds = {"hippo", "raccoon", "elephant", "lion",  "tiger", "pig", "horse", "bird", "deer"};
        String[] sPws={"9487","1528","4876","2866","6091","3002","2980","2864","2846"};
        String[] sNames={"barbara","chris","doris","elva","fiona","holly","jasmin","lena","melissa"};
        int[] sAges = {22, 20, 27, 19, 21, 19, 25, 22, 24};
        String[] sGenders = {"W", "W", "M", "M", "M", "W", "M", "W", "W"};
        String[] sMajors = {"Korean Literature",   "French Literature", "Philosophy", "History",   "Law", "Statistics", "Computer", "Economics", "Public Admin"};

        StudentDto std = new StudentDto("H39asdfaelu42o23", "hippo","9487", "barabra", 22, "W", "KoreanLiterature");

        //DbManager db = new DbManager();
        //StudentDao sdao = new StudentDao( db);
        //sdao.insertStudent(std);
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        StudentDao sdao = ctx.getBean("studentdao", StudentDao.class);
        /*sdao.insertStudent(std);
        for( int i=1; i<sNums.length; i++){
            std = new StudentDto(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]);
            sdao.insertStudent(std);
        }*/

        ArrayList<StudentDto> list = sdao.seleceStudent();
        for (StudentDto std1 : list) {
            System.out.print("| sNum : " + std1.getsNum() + "\t");
            System.out.print("| sNum : " + std1.getsId() + "\t");
            System.out.print("| sNum : " + std1.getsPw() + "\t");
            System.out.print("| sNum : " + std1.getsName() + "\t");
            System.out.print("| sNum : " + std1.getsAge() + "\t");
            System.out.print("| sNum : " + std1.getsGender() + "\t");
            System.out.print("| sNum : " + std1.getsMajor() + "\t");
        }

        }

    }

