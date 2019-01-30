package ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecsite.util.DBConnector;
import ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	public int setUserProf(String loginUserID,String loginPassword,String userName){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql="insert into login_user_transaction(login_id,login_pass,user_name,insert_date) values(?,?,?,?)";
		DateUtil date = new DateUtil();
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, loginUserID);
				ps.setString(2, loginPassword);
				ps.setString(3, userName);
				ps.setString(4, date.getDate());
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
