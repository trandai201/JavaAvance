/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dai
 */
public class KetNoiCSDL {
      public static Connection getConnection(){
      Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=demo;username:sa;password=12345");
            String url = "jdbc:sqlserver://localhost:1433; databaseName= THJAVA";
            String user = "sa";
            String pass = "12345";
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("ket noi thanh congtoi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
