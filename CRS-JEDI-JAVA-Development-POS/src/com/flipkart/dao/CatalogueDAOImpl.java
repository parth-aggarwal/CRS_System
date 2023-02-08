package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.constant.DBConnection;
import com.flipkart.constant.SQLConstants;
import com.flipkart.exception.CourseNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constant.DBConnection.*;
import static com.flipkart.constant.SQLConstants.*;


public class CatalogueDAOImpl implements CatalogueDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;

    public CatalogueDAOImpl() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addCourseInDB(Course course, String semID) {
//
//    }
//    public static void main(String args[]){
//
//         Connection conn = null;
//         PreparedStatement stmt = null;
//         Course course=new Course("123","","",5);
//         int semID=5;


        try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.prepareStatement(INSERT_CATALOGUE_QUERY);

            stmt.setString(1, course.getCourseID());
            stmt.setString(2, semID);
            stmt.setString(3, null);
            stmt.setInt(4, course.getAvailableSeats());
            if (stmt.executeUpdate() == 1) {
                System.out.println("Catalogue Updated");
            } else {
                System.out.println("Catalogue db update failed");
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Course> fetchCatalogue() {
        List<Course> courseList = new ArrayList<>();

        try{
            stmt = conn.prepareStatement(FETCH_CATALOGUE_QUERY);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Course tempcourse = new Course(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                courseList.add(tempcourse);
            }

            rs.close();
            return courseList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public void deleteCourseInDB(String courseId) {
        try {
            stmt = conn.prepareStatement(DELETE_FROM_CATALOGUE_QUERY);
            stmt.setString(1,courseId);

            int row = stmt.executeUpdate();
            stmt.close();
            conn.close();

            if (row == 0) {
                throw new CourseNotFoundException(courseId);
            }

        } catch (SQLException | CourseNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}