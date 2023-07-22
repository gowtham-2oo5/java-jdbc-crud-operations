package mainJava;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD_Ops {

	Connection c=null;
	Scanner sc=new Scanner(System.in);
	
	
	CRUD_Ops() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		String user="Gowtham",pass="abcd";
		c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_jdbc",user,pass);
		if(c!=null)
			System.out.println("Connection established");
		else
			System.out.println("No connection");
	}
	
	public void add(String name, long reg) throws SQLException {
		Statement s=c.createStatement();
		String qu=String.format("INSERT INTO crud_ops(name,regno) VALUES('%s',%d);",name,reg);
		s.executeUpdate(qu);
		
	}

	public void display() throws SQLException {
		Statement s=c.createStatement();
		String qu=("SELECT * FROM crud_ops;");
		 ResultSet rs = s.executeQuery(qu);
             // Print column names
             for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                 System.out.print(rs.getMetaData().getColumnName(i) + "\t");
             }
             System.out.println();

             // Print table data
             while (rs.next()) {
                 for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                     System.out.print(rs.getString(i) + "\t");
                 }
                 System.out.println();
             } 
	}

	public void update(long reg, String nm) throws SQLException {
		Statement s=c.createStatement();
		String q=String.format("UPDATE crud_ops SET name = '%s' WHERE regno = %d", nm,reg);
		int rowsAffected = s.executeUpdate(q);
		if(rowsAffected==1) {
			System.out.println("Updated successfully");
		}
      //  System.out.println("Rows affected: " + rowsAffected);
	}

	public void delete(long reg) throws SQLException {
		Statement s=c.createStatement();
		String q=String.format("DELETE FROM crud_ops where regno = %d", reg);
		int rowsAffected = s.executeUpdate(q);
		if(rowsAffected==1) {
			System.out.println("Deleted successfully");
		}
        System.out.println("Rows affected: " + rowsAffected);
	}

}
