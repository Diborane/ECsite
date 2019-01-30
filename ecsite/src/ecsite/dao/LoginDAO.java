package ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecsite.dto.LoginDTO;
import ecsite.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLogin(String loginUserId, String loginPassword){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();
		String sql = "select * from login_user_transaction where login_id=? and login_pass=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, loginUserId);
				ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				dto.setLoginUserId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setLoginFlg(true);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}


		return dto;
	}


}
