import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperation {

	public static void main(String[] args) {
		
		CrudOperation cr1 = new CrudOperation();
		
		
		
		try {
       
//			Connection conn =	  DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment5", "root","test" );
//			  
//			
//			Statement statement = conn.createStatement();
//			 int update = statement.executeUpdate("insert into Employee values (5, 'sathwik', 's', 'sathwik@gmail.com', 121, 'kar') ");
//			
//			conn.close();
			// Read statement called
			cr1.Activity5();
			cr1.Activity6();
			cr1.Activity7();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Activity5() {
		try {
			System.out.println("******************************************************************************************************************************************************************"); 
			Connection conn =	  DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment5", "root","test" );
			  
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * from Employee where eid in (select eid from Participents_Meetings where meetingId in( select meetingId from MeetingDetails where topicName = 'java'))");
			
		while(result.next()) {
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println(result.getString(4));
			System.out.println(result.getString(5));
		}
			
			
			conn.close();

		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Activity6() {
		
		System.out.println("******************************************************************************************************************************************************************");
		try {
			Connection conn =	  DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment5", "root","test" );
		
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * from Employee where eid in (select eid from Participents_Meetings where meetingId in( select meetingId from MeetingDetails where not topicName ='java'));");
			
		while(result.next()) {
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println(result.getString(4));
			System.out.println(result.getString(5));
		}
			
			
			conn.close();

		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	public void Activity7() {
		try {
		       System.out.println("******************************************************************************************************************************************************************");
			Connection conn =	  DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment5", "root","test" );
			  
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Employee JOIN Participents_Meetings ON Employee.eid = Participents_Meetings.eid WHERE Participents_Meetings.assesment_Score <99");
			
		while(result.next()) {
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println(result.getString(4));
			System.out.println(result.getString(5));
		}
			
			
			conn.close();

		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
