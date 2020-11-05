package com.RMG.genericLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ConnectoDB {
	private Connection conn;
	private Statement stmt;
	private ResultSet result;
	
	/**
	 * Use this method to connect to DB
	 * @throws Throwable
	 */
	public void getConnectionToDB() throws Throwable {
		Driver regDriver=new Driver();
		DriverManager.registerDriver(regDriver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	
	/**
	 * close connection with DB
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		conn.close();
	}
	
	/**
	 * pass expected data in method argument to verify that data present in database or not
	 * @param query
	 * @param columnIndex
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String exceuteQuery(String query,int columnIndex,String expectedData) throws Throwable {
		stmt = conn.createStatement();
		result = stmt.executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			return expectedData;
		}else {
			System.out.println(expectedData+" is not present in DB");
		}
		
		return null;
		
	}
	
	public ArrayList<String> exceuteQuery(String query,int columnIndex) throws Throwable{
		ArrayList<String> arr=new ArrayList<String>();
		stmt = conn.createStatement();
		result = stmt.executeQuery(query);
		while(result.next()) {
			arr.add(result.getString(columnIndex));
		}
		return arr;
		
	}

}
