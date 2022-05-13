package com.ibrahim.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args)  {
	  String jdbc="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
      String name="hbstudent";
      String pass="hbstudent";

      try{
          System.out.println("connections");
          Connection connection= DriverManager.getConnection(jdbc,name,pass);
          System.out.println(connection);
      }catch (SQLException exception){
        exception.getStackTrace();
      }

    }
}
