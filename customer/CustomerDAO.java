package customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	Connection c=null;
	public CustomerDAO() throws ClassNotFoundException,SQLException
	{
		c=DBConnection.getConnection();
	}
	public void insertCustomer(CustomerGS obj) throws SQLException
	{
		
			String INSERTQUERY="insert into user_contact values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(INSERTQUERY);
			pst.setInt(1,obj.getUser_id());
			pst.setString(2,obj.getUser_name());
			pst.setString(3,obj.getUser_mail());
			pst.setString(4,obj.getUser_address());
			pst.setString(5,obj.getSecurity_question());
			pst.setString(6,obj.getSecurity_answer());
			pst.setString(7,obj.getUser_password());
			pst.setString(8,obj.getOperator());
			pst.setString(9,obj.getApproval());
		    pst.execute();
		
	}
}
