package com.sampler;

import java.sql.*;


public class SampleR {
    static int studentCount = 1;

    public static void main(String[] args) {

        String dbUrl = "jdbc:postgresql:admin";
        String user = "postgres";
        String password = "roli220579";

        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from student");
            while (myRs.next()) {
                studentCount++;
            }
            new Prezentare(myStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
