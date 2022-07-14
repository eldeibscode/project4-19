package com.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("contecting to database");
			
			Connection myC = DriverManager.getConnection(Secret.getJdbcUrl(), Secret.getUser(), Secret.getPass());
			
			System.out.println("connection successful !!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
