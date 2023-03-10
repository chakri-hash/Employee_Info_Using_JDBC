import java.sql.*;  
import java.util.*;
class App{  
	
	public void DeleteRecord(int id) {
		try {
			Connection con = DButil.getDBconnection();
//			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("Delete from emp where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertRecord(Bean b) {
		try {
			Connection con = DButil.getDBconnection();
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
			
			
			ps.setInt(1, b.getId());
			ps.setString(2, b.getName());
			ps.setInt(3, b.getAge());
			ps.executeUpdate();	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(int id, String name, int age) {
		try {
			
			Connection con = DButil.getDBconnection();
			PreparedStatement ps = con.prepareStatement("update emp set name = ?, age = ? where id = ? ");
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(3,id);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void display() {
		try {
			Connection con = DButil.getDBconnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emp"); 
			while(rs.next())  
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t "+rs.getString(3));  
			con.close(); 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){  
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   
		int id, age;
		String name;
		int ch;
	     App ob = new App();
	     Bean b = new Bean();
	     Scanner sc = new Scanner(System.in);
	     
	     System.out.println("1.insert 2.Delete 3.Update 4.Display 5.Terminate");
	     ch = sc.nextInt();

	     
	     while(ch!=5) {
	    	
	    	switch(ch) { 
	    	 
	    	 case 1:
	    		 System.out.println("Enter id");
	    		 id = sc.nextInt();
//	    		 try {
//	    		 id = Integer.parseInt(sc.nextLine());
//	    		 } catch (NumberFormatException e) {
//	    			 e.printStackTrace();
//	    		 }
	    		 sc.nextLine();
	    		 System.out.println("Enter name");
	    		 
	    		 name = sc.nextLine();
	    		 
	    		 System.out.println("Enter Age");
	    		 age = sc.nextInt();
	    		 b.setId(id);
	    	     b.setName(name);
	    	     b.setAge(age);
	    	     ob.insertRecord(b);
	    		 break;
	    		 
	    	 case 2:
	    		 System.out.println("Enter id");
	    		 id = sc.nextInt();
	    	     ob.DeleteRecord(id);
	    	     break;

	    		 
	    		 
	    	 case 3:
	    		 System.out.println("Enter id");
	    		 id = sc.nextInt();
	    		 sc.nextLine();
	    		 System.out.println("Enter name");
	    		 name = sc.nextLine();
	    		 System.out.println("Enter Age");
	    		 age = sc.nextInt();
	    	     ob.update(id,name,age);
	    	     break;

	    		 
	    		 
	    	 case 4:
	    	     ob.display();
	    	     break;

	    		 
	    	 case 5:
	    		 System.out.println("You have terminated");
	    		 break;

	    		 
	    	 default:
	    		 System.out.println("You have entered a wrong choice..");
	    		 break;
	    			 
	    	} 
	    		 
	    	System.out.println("1.insert 2.Delete 3.Update 4.Display 5.Terminate");
	        ch = sc.nextInt();
	    	 
	     }
		}  
}