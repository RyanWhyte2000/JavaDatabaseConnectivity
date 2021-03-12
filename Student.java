package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Student {

	
	private  Connection connect;
	
	public Student() {
		String url = "jdbc:mysql://localhost:3306/";

		try {
			connect= DriverManager.getConnection(url, "root", "");
			if(connect != null) {
				
				JOptionPane.showMessageDialog(null, " Connected to local Server",
             	" JDBC Conection Status", JOptionPane.INFORMATION_MESSAGE);
					
			}
			
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void create(String id, String name) {
		
		
		String sql= "INSERT INTO dblab.students(ID,Name) VALUES (" + id + ", '" +name+"');";
		
		try {
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return affected;
	}
	public void readAll() {
       int affected =0;
		try {
			String strSelect = "select * from dblab.students";
			PreparedStatement ps = connect.prepareStatement(strSelect);
				ResultSet  result = ps.executeQuery();
				
					while( result.next()) {
						
						System.out.println(result.getString(1)+ " "+result.getString(2));
						
					}
			 
		} catch (SQLException e) { 
			e.printStackTrace();
		}


	} 
	
	 public void update(String id, String name) {
		 
	int affected =0;
 
		 try {
			 String strUpdate = "UPDATE dblab.students set name = ? where id = ?";
			PreparedStatement ps = connect.prepareStatement(strUpdate);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	public void delete(String id) {
		

		try { 
			String sqlDelete = "DELETE from dblab.students where id = "+ id;
			PreparedStatement ps = connect.prepareStatement(sqlDelete);

			ps.executeUpdate();  
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}
}
