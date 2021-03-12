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
	public void create(String id, String firstName,String lastName,String email ) {


		String sql= "INSERT INTO dblab.students(ID,firstName,lastName,email) VALUES (" + id + ", '" +firstName+"','" +lastName+"','" +email+"');";

		try {
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void readAll() {
		int affected =0;
		try {
			String strSelect = "select * from dblab.students";
			PreparedStatement ps = connect.prepareStatement(strSelect);
			ResultSet  result = ps.executeQuery();

			while( result.next()) {
				System.out.println("ID FIRSTNAME LASTNAME EMAIL");
				System.out.println( result.getString(1)+ "    "+result.getString(2)+ "    "+result.getString(3)+ "   "+result.getString(4));

			}

		} catch (SQLException e) { 
			e.printStackTrace();
		} 


	} 

	public void update(String id,String firstName) {


		try {
			String strUpdate = "UPDATE dblab.students set firstName = ? where id = ?";
			PreparedStatement ps = connect.prepareStatement(strUpdate);
			ps.setString(1, firstName);
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
