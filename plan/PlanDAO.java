package plan;
import java.sql.Connection;
import customer.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import customer.CustomerGS;
import customer.DBConnection;

public class PlanDAO {
	Connection c=null;
	public void CustomerDAO() throws ClassNotFoundException,SQLException
	{
		c=DBConnection.getConnection();
	}
	public void insertplan(PlanGS obj) throws SQLException
	{
		String INSERTQUERY="insert into plan values(?,?,?,?)";
		PreparedStatement stmt=c.prepareStatement(INSERTQUERY);
		stmt.setString(2,obj.getPlan_type());
		stmt.setString(3,obj.getPlan_model());
		stmt.execute();
	}
	public ResultSet selectplan(PlanGS obj) throws SQLException
	{
		String select="select user_id from user_contact where user_id=?";
		PreparedStatement pst=c.prepareStatement(select);
		
		ResultSet rs = pst.executeQuery();
		return rs;
	}
}
